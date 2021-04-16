package com.perye.binarySearch;

/**
 * 35. 搜索插入位置
 * 二分查找
 * 链接：https://leetcode-cn.com/problems/search-insert-position/
 *
 * @author honggd
 */
public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
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
        return left;
    }

}
