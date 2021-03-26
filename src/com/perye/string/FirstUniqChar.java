package com.perye.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 387.字符串中的第一个唯一字符
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 *
 * @author honggd
 */
public class FirstUniqChar {
    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
