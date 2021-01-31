public class 加一 {

    //解法：考虑边界情况9+1需要进位，因此一旦和某位相加结果非0则直接返回，极端情况下每一位都是9，则最后需要扩充数组，最高位放1
    //时间复杂度O(n) 空间复杂度视是否出现极端情况为O(1)~O(n+1)
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while(i>=0){
            digits[i] = (digits[i] + 1) % 10;
            if(digits[i]!=0) return digits;
            i--;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
