package com.perye.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. 串联所有单词的子串
 * 链表
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 *
 * @author honggd
 */
public class FindSubString {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (words.length == 0) {
            return ans;
        }
        int n = s.length();
        int m = words.length;
        int w = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        out:
        for (int i = 0; i + m * w <= n; i++) {
            Map<String, Integer> cur = new HashMap<>();
            String sub = s.substring(i, i + m * w);
            for (int j = 0; j < sub.length(); j += w) {
                String item = sub.substring(j, j + w);
                if (!map.containsKey(item)) {
                    continue out;
                }
                cur.put(item, cur.getOrDefault(item, 0) + 1);
            }
            if (cmp(cur, map)) {
                ans.add(i);
            }

        }
        return ans;
    }

    /**
     * 判断两个map是否相等
     */
    private boolean cmp(Map<String, Integer> m1, Map<String, Integer> m2) {
        if (m1.size() != m2.size()) {
            return false;
        }
        for (String k1 : m1.keySet()) {
            if (!m2.containsKey(k1) || !m1.get(k1).equals(m2.get(k1))) {
                return false;
            }
        }
        for (String k2 : m2.keySet()) {
            if (!m1.containsKey(k2) || !m2.get(k2).equals(m1.get(k2))) {
                return false;
            }
        }
        return true;
    }

}
