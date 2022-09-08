package com.perye.problem.binarySearch;

/**
 * 704. 二分查找
 * 二分查找
 * 链接：https://leetcode-cn.com/problems/binary-search/
 *
 * @author honggd
 */
public class BinarySearch {

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] > target || nums[right] < target) {
                return -1;
            }
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

}
