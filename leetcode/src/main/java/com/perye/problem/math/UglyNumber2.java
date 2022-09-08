package com.perye.problem.math;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 264.丑数2
 * 数学、堆、动态规划
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii/
 *
 * @author honggd
 */
public class UglyNumber2 {

    public static int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            Long curr = heap.poll();
            ugly = curr.intValue();
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }


}
