public class 旋转数组 {
    /**
     * 解法1：额外准备一个数组，将原数组迁移后的元素放入该数组中，再将结果修改回原数组，因为方法返回值是void类型
     * 时间复杂度O(2n)=O(n) 空间复杂度O(n)
     */
    public void rotate1(int[] nums, int k) {
        k = k % nums.length;
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[(i + k) % nums.length] = nums[i];
        }
        //修改原数组元素
        System.arraycopy(copy, 0, nums, 0, nums.length);
    }

    /**
     * 解法2：解法1额外准备数组是为了解决数组元素迁移时原来的值被迁移后的值覆盖的情况。因此通过一个变量pre来保存之前被覆盖的值。解法2采用环状替换，即从初始位置跳跃k个距离替换目标数值，被替换的数值使用变量pre保存，并用pre替换下k个距离的数值，依此类推，最终会跳回最开始的位置。可以发现数组中每个位置都经过一次跳跃就到达了目标位置，因此只需要跳跃nums.length的次数即可。但是有可能出现nums.length是k的整数倍的情况，这样经过跳跃回到原地的时候依然会有元素没有被覆盖到，因此从下一个元素开始再进行连续的跳跃直至跳跃次数达到nums.length即可。
     * 时间复杂度O(n) 空间复杂度O(1)
     */
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int i = 0; i < nums.length && count < nums.length; i++) {
            int pre = nums[i];
            int cur = i;
            do {
                int next = (cur + k) % nums.length;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                cur = next;
                count++;
            } while (cur != i && count < nums.length);
        }
    }

    /**
     * 解法3：数组翻转。先将所有元素进行翻转，这样尾部的 k%n 个元素就被移至数组头部，然后再分别翻转 [0, k%n-1]区间的元素和[k%n,n−1] 区间的元素即能得到最后的答案。
     * 时间复杂度O(2n)=O(n) 空间复杂度O(1)
     */
    public void rotate3(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
