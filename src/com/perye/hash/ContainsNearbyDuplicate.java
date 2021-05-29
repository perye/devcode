package com.perye.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. 存在重复元素 II
 * 哈希表
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii/
 *
 * @author honggd
 */
public class ContainsNearbyDuplicate {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
