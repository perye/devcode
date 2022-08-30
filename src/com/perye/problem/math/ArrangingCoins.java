package com.perye.problem.math;


/**
 * 441. 排列硬币
 * 数学
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square/
 *
 * @author honggd
 */
public class ArrangingCoins {

    public int arrangeCoins(int n) {
        int curr = 1;
        int count = 0;
        while (n > 0) {
            n -= curr;
            curr++;
            if (n >= 0) {
                count++;
            }
        }
        return count;
    }
}
