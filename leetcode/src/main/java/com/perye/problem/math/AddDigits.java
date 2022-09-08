package com.perye.problem.math;

/**
 * 258. 各位相加
 * 数学
 * 链接：https://leetcode-cn.com/problems/add-digits/
 *
 * @author honggd
 */
public class AddDigits {

    public static int addDigits(int num) {
        while (num > 10) {
            num = num / 10 + num % 10;
        }
        return num;
    }
}
