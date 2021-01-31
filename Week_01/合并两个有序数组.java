public class 合并两个有序数组 {

    //解法1：双指针，需要借助nums1的拷贝数组，对比nums1copy和nums2的数值，依次覆盖到nums1中
    //时间复杂度 O(m+n) 空间复杂度O(m)
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] copy = new int[m];
        System.arraycopy(nums1, 0, copy, 0, m);

        int a = 0, b = 0, c = 0;
        while ((a < m) && (b < n))
            nums1[c++] = (copy[a] < nums2[b]) ? copy[a++] : nums2[b++];
        if (a < m)
            System.arraycopy(copy, a, nums1, c, m + n - c);
        if (b < n)
            System.arraycopy(nums2, b, nums1, c, m + n - c);
    }

    //解法2：双指针，解法1由于从头开始更新nums1的值需要额外借助一个拷贝数组
    //但是nums1最后是预留了空间的，因此可以考虑指针从后向前遍历
    //时间复杂度O(m+n) 空间复杂度O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = m - 1, b = n - 1, c = m + n - 1;

        while (a >= 0 && b >= 0) nums1[c--] = nums1[a] < nums2[b] ? nums2[b--] : nums1[a--];

        System.arraycopy(nums2, 0, nums1, 0, b + 1);
    }
}
