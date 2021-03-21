package com.ken.贪心;

import java.util.Arrays;

public class 分发饼干 {

    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        if (s.length == 0) return count;
        Arrays.sort(g);
        Arrays.sort(s);
        int childNum = g.length, cookieNum = s.length;
        for (int i = 0, j = 0; i < childNum && j < cookieNum; i++, j++) {
            //挑合适的饼干给小孩，不合适就数组后移直至找到一个合适的
            while (j < cookieNum && g[i] > s[j]) {
                j++;
            }
            if (j < cookieNum) {
                count++;
            }
        }
        return count;
    }
}
