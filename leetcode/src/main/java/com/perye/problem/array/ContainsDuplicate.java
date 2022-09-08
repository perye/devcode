package com.perye.problem.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 217.存在重复元素
 * 哈希表、排序
 * 链接：https://leetcode-cn.com/problems/contains-duplicate
 * @author honggd
 */
public class ContainsDuplicate {

    /**
     * 哈希表
     * 对于数组中每个元素，我们将它插入到哈希表中。如果插入一个元素时发现该元素已经存在于哈希表中，则说明存在重复的元素
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 排序
     * 在对数字从小到大排序之后，数组的重复元素一定出现在相邻位置中。
     * 因此，我们可以扫描已排序的数组，每次判断相邻的两个元素是否相等，如果相等则说明存在重复的元素。
     */
    public static boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

}
