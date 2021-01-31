public class 合并两个有序链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 解法1：递归
     * 时间复杂度 O(m+n) 空间复杂度O(m+n)
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

    /**
     * 解法2：双指针哨兵，设置一个虚拟头节点，两个链表各自维护一个指针并比对所指元素的大小，将元素小的节点赋值给虚拟头节点的next引用。
     * 时间复杂度 O(m+n) 空间复杂度 O(1)
     */
    public ListNode mergeTwoLists2 (ListNode l1, ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                current = current.next;
                l1 = l1.next;
            } else {
                current.next = l2;
                current = current.next;
                l2 = l2.next;
            }
        }
        //循环合并完后可能其中一个链表还有剩余节点，直接挂在current指针后面即可
        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }
        return dummy.next;
    }
}
