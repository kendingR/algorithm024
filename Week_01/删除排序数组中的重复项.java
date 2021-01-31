public class 删除排序数组中的重复项 {
    //解法：双指针，i记录重复项的初始位置，j遍历数组，一旦发现i与j不同，则将i后移一位后把j赋值给i
    //这样就能确保i每移动一次都会被赋予一个不一样的数值，i指代的数组下标+1即为长度
    //时间复杂度O(n) 空间复杂度O(1)
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
