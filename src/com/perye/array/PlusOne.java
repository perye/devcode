package com.perye.array;

/**
 * 66.加一
 * 链接：https://leetcode-cn.com/problems/plus-one/
 *
 * @author honggd
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[length + 1];
        digits[0] = 1;
        return digits;
    }

}
