package com.ken.字符串;

import java.util.HashMap;
import java.util.Map;

public class 同构字符串 {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i), tChar = t.charAt(i);
            if ((sMap.containsKey(sChar) && !sMap.get(sChar).equals(tChar))
                    || (tMap.containsKey(tChar) && !tMap.get(tChar).equals(sChar))) {
                return false;
            }
            sMap.put(sChar, tChar);
            tMap.put(tChar, sChar);
        }
        return true;
    }
}
