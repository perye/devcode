package com.perye.problem.math;

/**
 * 633. 平方数之和
 * 数学
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers/
 *
 * @author honggd
 */
public class JudgeSquareSum {

    public static boolean judgeSquareSum(int c) {
        for (long i = 0; i * i <= c; i++) {
            double b = Math.sqrt(c - i * i);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }

    /**
     * 双指针
     * @param c
     * @return
     */
    public static boolean judgeSquareSum1(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    /**
     * 费马平方和定理
     * 对 c 进行质因数分解，再判断所有形如 4k + 3 的质因子的幂是否均为偶数即可。
     * @param c
     * @return
     */
    public static boolean judgeSquareSum2(int c) {
        for (int base = 2; base * base <= c; base++) {
            // 如果不是因子，枚举下一个
            if (c % base != 0) {
                continue;
            }
            // 计算 base 的幂
            int exp = 0;
            while (c % base == 0) {
                c /= base;
                exp++;
            }
            // 根据 Sum of two squares theorem 验证
            if (base % 4 == 3 && exp % 2 != 0) {
                return false;
            }
        }
        // 例如 11 这样的用例，由于上面的 for 循环里 base * base <= c ，base == 11 的时候不会进入循环体
        // 因此在退出循环以后需要再做一次判断
        return c % 4 != 3;
    }


}
