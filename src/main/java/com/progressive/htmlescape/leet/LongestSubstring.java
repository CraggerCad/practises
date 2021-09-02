package com.progressive.htmlescape.leet;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int i = 0, j = 0, max = 0, count = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            count++;
            if (!set.contains(s.charAt(j))) {
                System.out.println("\ndoesnt contains add");
                System.out.println(s.charAt(j));
                System.out.println(set);
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                System.out.println("\ncontains remove");
                System.out.println(s.charAt(j));
                System.out.println(set);
                set.remove(s.charAt(i++));
            }
        }

        System.out.println("Count= " + count + " max= " + max);
    }
}
