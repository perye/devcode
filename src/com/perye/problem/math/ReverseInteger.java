package com.perye.problem.math;

/**
 * 7.整数反转
 * 链接：https://leetcode-cn.com/problems/reverse-integer/
 *
 * @author honggd
 */
public class ReverseInteger {

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
