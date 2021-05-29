package com.perye.math;

import java.math.BigInteger;

/**
 * 172. 阶乘后的零
 * 数学
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 *
 * @author honggd
 */
public class TrailingZeroes {

    public int trailingZeroes(int n) {
        BigInteger nFactorial = BigInteger.ONE;
        for (int i = 2; i < n; i++) {
            nFactorial = nFactorial.multiply(BigInteger.valueOf(i));
        }
        int zeroCount = 0;
        while (nFactorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            nFactorial = nFactorial.divide(BigInteger.TEN);
            zeroCount++;
        }
        return zeroCount;
    }

    public int trailingZeroes2(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }

}
