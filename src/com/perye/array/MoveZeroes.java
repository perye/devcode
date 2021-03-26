package com.perye.array;

/**
 * 283.移动零
 * 链接：https://leetcode-cn.com/problems/move-zeroes/
 *
 * @author honggd
 */
public class MoveZeroes {


    /**
     * 遍历一遍数组，将非0往前覆盖，一遍之后index前的全是非0  ，index后的不管全替换0就可
     */
    public static void moveZeroes(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    /**
     * 双指针
     */
    public void moveZeroes2(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    
}
