package com.perye.bit;

/**
 * 338. 比特位计数
 *
 * 位运算、动态规划
 * 链接：https://leetcode-cn.com/problems/counting-bits/
 *
 * @author honggd
 */
public class CountBits {

    public static int[] countBits(int num) {
        int[] ans = new int[num + 1];
        int index = 0;
        for (int i = 0; i <= num; i++) {
            ans[index++] = countOnes(i);
        }
        return ans;
    }

    public static int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }

}
