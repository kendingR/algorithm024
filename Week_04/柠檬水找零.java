package com.ken.贪心;

public class 柠檬水找零 {

    public static void main(String[] args) {
        int[] bills = new int[]{5, 10, 10};
        System.out.println(lemonadeChange(bills));
    }

    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) five++; //5元不用找零
            else if (bills[i] == 10) { //10元需要找零1张5元
                if (five <= 0) return false;
                ten++;
                five--;
            } else {
                //20元可以找零1张10元+1张5元
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else {
                    //20元可以找零3张5元
                    five -= 3;
                    if (five < 0) return false;
                }
            }
        }
        return true;
    }
}
