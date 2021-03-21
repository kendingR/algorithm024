package com.ken.String;

import java.util.HashMap;
import java.util.Map;
import java.util.function.ToIntFunction;

public class 有效的字母异位词 {

    public static void main(String[] args) {
        System.out.println(isAnagram("aacc", "ccac"));
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (Integer count : map.values()) {
            if (count != 0) return false;
        }
        return true;
    }
}
