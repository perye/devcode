package com.perye.problem.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律
 * 哈希表
 * 链接：https://leetcode-cn.com/problems/word-pattern/
 *
 * @author honggd
 */
public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {
        Map<String, Character> sMap = new HashMap<>();
        Map<Character, String> pMap = new HashMap<>();
        String[] strings = s.split(" ");
        if (pattern.length() != strings.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char pChar = pattern.charAt(i);
            String s1 = strings[i];
            if ((sMap.containsKey(s1) && sMap.get(s1) != pChar)
                    || (pMap.containsKey(pChar) && !pMap.get(pChar).equals(s1))) {
                return false;
            }
            sMap.put(s1, pChar);
            pMap.put(pChar, s1);
        }
        return true;
    }

}
