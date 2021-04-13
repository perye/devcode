package com.perye.array;


/**
 * 1588. 所有奇数长度子数组的和
 * 数组
 * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/
 *
 * @author honggd
 */
public class SumOddLengthSubArrays {

    public int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length, res = 0;
        for (int i = 0; i < len; i++) {
            int leftOdd = (i + 1) / 2, leftEven = i / 2 + 1;
            int rightOdd = (len - i) / 2, rightEven = (len - 1 - i) / 2 + 1;
            res += arr[i] * (leftOdd * rightOdd + leftEven * rightEven);
        }
        return res;
    }
}
