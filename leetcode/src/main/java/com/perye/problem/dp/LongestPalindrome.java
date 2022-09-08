package com.perye.problem.dp;

/**
 * 5. 最长回文子串
 * 动态规划、字符串
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author honggd
 */
public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        // dp[i][j]表示s[i..j]是否回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化:所有长度为1的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串
        for (int L = 2; L <= len; L++) {
            // 枚举左边界,左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 有L和i可以确定右边界，即j-i+1=L得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }



    /**
     * 最长回文子串
     * 回文串问题的究极答案：Manacher 算法
     * Manacher算法 是「回文串」问题的最优解
     * 时间复杂度：只对字符串进行了一次扫描。复杂度为 O(n)
     * 空间复杂度：O(1)
     * @param s 字符串 s
     * @return s 中最长的回文子串
     */
    public String longestPalindrome2(String s) {
        if (s.length() == 1) {
            return s;
        }
        char[] chars = new char[s.length() * 2 + 1];
        for (int i = 0, idx = 0; i < chars.length; i++) {
            chars[i] = (i & 1) == 0 ? '#' : s.charAt(idx++);
        }
        int n = chars.length;
        int[] pArr = new int[n];
        int c = -1, r = -1, pos = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            pArr[i] = i < r ? Math.min(pArr[c * 2 - i], r - i) : 1;
            while (i + pArr[i] < n && i - pArr[i] > -1) {
                if (chars[i + pArr[i]] == chars[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > r) {
                r = i + pArr[i];
                c = i;
            }
            if (pArr[i] > max) {
                max = pArr[i];
                pos = i;
            }
        }
        int offset = pArr[pos];
        StringBuilder sb = new StringBuilder();
        for (int i = pos - offset + 1; i <= pos + offset - 1; i++) {
            if (chars[i] != '#') {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

}
