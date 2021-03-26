package com.perye.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.两数之和
 * 链接：https://leetcode-cn.com/problems/two-sum/
 * 暴力枚举、哈希表
 * @author honggd
 */
public class TwoSum {

    /**
     * 暴力枚举
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /**
     * 哈希表
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashTable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashTable.containsKey(target - nums[i])) {
                return new int[]{hashTable.get(target - nums[i]), i};
            }
            hashTable.put(nums[i], i);
        }
        return new int[0];
    }


}
