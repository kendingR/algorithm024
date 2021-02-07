package com.ken.ArrayAndLinkedList;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class 丑数II {

    static class Ugly {
        public int[] nums;

        public Ugly() {
            this.nums = new int[1690];
            nums[0] = 1;
            int ugly, i2 = 0, i3 = 0, i5 = 0;

            for (int i = 1; i < 1690; ++i) {
                ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
                nums[i] = ugly;

                if (ugly == nums[i2] * 2) ++i2;
                if (ugly == nums[i3] * 3) ++i3;
                if (ugly == nums[i5] * 5) ++i5;
            }
        }
    }

    public  int nthUglyNumber(int n) {
        Ugly ugly = new Ugly();
        return ugly.nums[n - 1];
    }
}
