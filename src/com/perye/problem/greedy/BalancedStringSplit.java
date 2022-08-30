package com.perye.problem.greedy;

/**
 * 1221. 分割平衡字符串
 * 贪心算法、字符串
 * 链接：https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 *
 * @author honggd
 */
public class BalancedStringSplit {

    public int balancedStringSplit(String s) {
        int ans = 0;
        int lCount = 0;
        int rCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                lCount++;
            } else {
                rCount++;
            }
            if (lCount == rCount) {
                ans++;
                lCount = 0;
                rCount = 0;
            }
        }
        return ans;
    }

}
