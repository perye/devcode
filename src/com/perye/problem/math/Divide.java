package com.perye.problem.math;

/**
 * 29. 两数相除
 * 数学
 * 链接：https://leetcode-cn.com/problems/divide-two-integers/
 *
 * @author honggd
 */
public class Divide {

    /**
     * 可以简单概括为： 60/8 = (60-32)/8 + 4 = (60-32-16)/8 + 2 + 4 = 1 + 2 + 4 = 7
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE) {
                // 只要不是最小的那个整数，都是直接返回相反数
                return -dividend;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        long a = dividend;
        long b = divisor;
        int sign = 1;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
            sign = -1;
        }
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;
        long res = div(a, b);
        if (sign > 0) {
            return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
        }
        return (int) -res;
    }

    private static long div(long a, long b) {
        if (a < b) {
            return 0;
        }
        long count = 1;
        // 在后面的代码中不更新b
        long tb = b;
        while ((tb + tb) <= a) {
            // 最小解翻倍
            count = count + count;
            // 当前测试的值也翻倍
            tb = tb + tb;
        }
        return count + div(a - tb, b);
    }
}
