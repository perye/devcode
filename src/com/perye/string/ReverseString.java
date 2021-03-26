package com.perye.string;

/**
 * 344.反转字符串
 * 链接：https://leetcode-cn.com/problems/reverse-string/
 * 双指针
 * @author honggd
 */
public class ReverseString {

    /**
     * 双指针
     */
    public static void reverseString(char[] s) {
        int n = s.length;
        for (int left = 0, right = n - 1; left < right; ++left, --right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }

}
