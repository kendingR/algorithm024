package com.ken.字符串;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 翻转字符串里的单词 {

    public static void main(String[] args) {
        String s = "the sky  is blue";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        s= trimSpaces(s);
        StringBuilder sb = new StringBuilder(s);
        //字符串整体翻转
        sb.reverse();
        int start, end = 0;
        //单词逐个翻转
        while (end < sb.length()) {
            start = end;
            while (end < sb.length() && sb.charAt(end) != ' ') {
                end++;
            }
            reverseWord(sb, start, end - 1);
            end++;
        }
        return sb.toString();
    }

    private static String trimSpaces(String s) {
        s = s.trim();
        return s.replaceAll("\\s+"," ");
    }

    private static void reverseWord(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, temp);
        }
    }

    /*public static String reverseWords(String s) {
        s = s.trim();
        String[] split = s.split("\\s+");
        List<String> wordList = Arrays.asList(split);
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }*/
}
