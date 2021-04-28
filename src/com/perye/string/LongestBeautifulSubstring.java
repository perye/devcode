package com.perye.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1839. 所有元音按顺序排布的最长子字符串
 * 状态机、字符串、双指针、滑动窗口
 * 链接：https://leetcode-cn.com/problems/longest-substring-of-all-vowels-in-order/
 *
 * @author honggd
 */
public class LongestBeautifulSubstring {

    public int longestBeautifulSubstring(String word) {
        List<Character> window = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        int left;
        int res = 0;
        int right = 0;
        while (right < word.length()) {
            if (window.isEmpty() || word.charAt(right) >= window.get(window.size() - 1)) {
                window.add(word.charAt(right));
                set.add(word.charAt(right));
                if (set.size() == 5) {
                    res = Math.max(res, window.size());
                }
            } else {
                window.clear();
                set.clear();
                left = right;
                window.add(word.charAt(left));
                set.add(word.charAt(left));
            }
            right++;
        }
        return res;
    }

}
