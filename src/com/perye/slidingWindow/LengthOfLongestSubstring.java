package com.perye.slidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 滑动窗口
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author honggd
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> set = new HashSet<>();
        int ans = 0;
        // 定义右指针，初始值为-1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                set.remove(s.charAt(i - 1));
            }
            while (rk + 1 < s.length() && !set.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                set.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

}
