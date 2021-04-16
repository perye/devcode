package com.perye.lcp;

/**
 * LCP 06. 拿硬币
 * 链接：https://leetcode-cn.com/problems/na-ying-bi/
 *
 * @author honggd
 */
public class NaYingBi {

    public static int minCount(int[] coins) {
        int count = 0;
        for (int coin : coins) {
            count += (coin + 1) / 2;
        }
        return count;
    }

}
