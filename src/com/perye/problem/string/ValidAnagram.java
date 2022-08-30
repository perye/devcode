package com.perye.problem.string;

import java.util.*;

/**
 * 242.有效的字母异位词
 * 链接：https://leetcode-cn.com/problems/valid-anagram/
 * @author honggd
 */
public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : s.toCharArray()) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        for (char aChar : t.toCharArray()) {
            map.put(aChar, map.getOrDefault(aChar, 0) - 1);
            if (map.get(aChar) < 0) {
                return false;
            }
        }
        return true;
    }

}
