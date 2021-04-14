package com.ken.字符串;

public class 字符串转换整数Atoi {

    public int myAtoi(String s) {
        if (s.length() == 0) return 0;
        // 声明三个变量分别代表字符串遍历下标，正负号标识，字符代表的数值绝对值
        int index = 0, sign = 1, abs = 0;
        //消除前置空格
        while (index < s.length() && s.charAt(index) == ' ') index++;
        if (index<s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        while (index < s.length()) {
            //正负号后出现非数字直接结束计算
            if (!Character.isDigit(s.charAt(index))) break;
            int num = s.charAt(index) - '0';
            //如果本轮循环abs计算后会超过Integer上界，则直接返回Integer的边界值
            if (abs > Integer.MAX_VALUE / 10 || (abs == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            abs = 10 * abs + num;
            index++;
        }
        return sign * abs;
    }
}
