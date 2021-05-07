package com.perye.heap;

import java.util.PriorityQueue;

/**
 * 1710. 卡车上的最大单元数
 * 贪心算法、排序
 * 链接：https://leetcode-cn.com/problems/maximum-units-on-a-truck/
 *
 * @author honggd
 */
public class LastStoneWeight {

    /**
     * 最大堆
     * 时间   nlogn
     * 空间   n
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {
        // 最大堆
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a > b) {
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }

}
