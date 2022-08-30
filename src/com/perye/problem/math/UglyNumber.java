package com.perye.problem.math;

/**
 * 263.丑数
 * 数学
 * 链接：https://leetcode-cn.com/problems/ugly-number/
 *
 * @author honggd
 */
public class UglyNumber {

    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 == 0) {
            return isUgly(n / 2);
        } else if (n % 3 == 0) {
            return isUgly(n / 3);
        } else if (n % 5 == 0) {
            return isUgly(n / 5);
        }
        return false;
    }

}
