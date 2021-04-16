package com.perye.binarySearch;

/**
 * 287. 寻找重复数
 * 数组、二分查找、双指针
 * 链接：https://leetcode-cn.com/problems/scramble-string/
 *
 * @author honggd
 */
public class FindTheDuplicateNumber {

    /**
     * 二分法结合抽屉原理
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        while (left < right) {
            // 在 Java 里可以这么用，当 left + right 溢出的时候，无符号右移保证结果依然正确
            int mid = (left + right + 1) >>> 1;

            int cnt = 0;
            for (int num : nums) {
                if (num < mid) {
                    cnt += 1;
                }
            }

            // 根据抽屉原理，严格小于 4 的数的个数如果大于等于 4 个，
            // 此时重复元素一定出现在 [1, 3] 区间里

            if (cnt >= mid) {
                // 重复的元素一定出现在 [left, mid - 1] 区间里
                right = mid - 1;
            } else {
                // if 分析正确了以后，else 搜索的区间就是 if 的反面
                // [mid, right]
                // 注意：此时需要调整中位数的取法为上取整
                left = mid;
            }
        }
        return left;
    }
}
