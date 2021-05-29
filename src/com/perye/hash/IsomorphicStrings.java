package com.perye.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * 哈希表
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings/
 *
 * @author honggd
 */
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if ((sMap.containsKey(sChar) && sMap.get(sChar) != tChar)
                    || (tMap.containsKey(tChar) && tMap.get(tChar) != sChar)) {
                return false;
            }
            sMap.put(sChar, tChar);
            tMap.put(tChar, sChar);
        }
        return true;
    }

}
