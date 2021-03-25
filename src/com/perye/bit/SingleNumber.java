package com.perye.bit;

import java.util.Arrays;

/**
 * 136.只出现一次的数字
 * 位运算
 * 链接：https://leetcode-cn.com/problems/single-number
 * @author honggd
 */
public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }

    /**
     * 流
     */
    public static int singleNumber2(int[] nums) {
        return Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
    }

    /*
        交换律：a ^ b ^ c <=> a ^ c ^ b
        任何数于0异或为任何数 0 ^ n => n
        相同的数异或为0: n ^ n => 0
    */
}
