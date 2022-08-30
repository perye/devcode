package com.perye.problem.math;

import java.util.Arrays;

/**
 * 204. 计数质数
 * 数学、哈希表
 * 链接：https://leetcode-cn.com/problems/count-primes/
 *
 * @author honggd
 */
public class CountPrimes {

    // 枚举 -begin
    public int countPrimes1(int n) {
        int ans = 0;
        for (int i = 2; i < n; i++) {
            ans += isPrime(i) ? 1 : 0;
        }
        return ans;
    }

    public boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
    // 枚举 -end

    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }




}
