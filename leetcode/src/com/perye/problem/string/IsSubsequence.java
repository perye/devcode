package com.perye.problem.string;


/**
 * 392. 判断子序列
 * 贪心算法、二分查找、动态规划
 * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/
 *
 * @author honggd
 */
public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        char[] tChars = t.toCharArray();
        char[] sChars = s.toCharArray();
        if (sChars.length == 0) {
            return true;
        }
        int index = 0;
        for (char tChar : tChars) {
            if (index < sChars.length && tChar == sChars[index]) {
                index++;
            }
        }
        return index == sChars.length;
    }

}
