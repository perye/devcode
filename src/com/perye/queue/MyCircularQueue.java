package com.perye.queue;

/**
 * 622. 设计循环队列
 * 设计、队列
 * 链接：https://leetcode-cn.com/problems/design-circular-queue/
 * <p>
 * 支持如下操作：
 * <p>
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 *
 * @author honggd
 */
public class MyCircularQueue {

    private int[] queue;
    private int headIndex;
    private int count;
    private int capacity;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
        this.headIndex = 0;
        this.count = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (this.count == this.capacity) {
            return false;
        }
        this.queue[(this.headIndex + this.count) % this.capacity] = value;
        this.count += 1;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (this.count == 0) {
            return false;
        }
        this.headIndex = (this.headIndex + 1) % this.capacity;
        this.count -= 1;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (this.count == 0) {
            return -1;
        }
        return this.queue[this.headIndex];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (this.count == 0) {
            return -1;
        }
        int tailIndex = (this.headIndex + this.count - 1) % this.capacity;
        return this.queue[tailIndex];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return (this.count == 0);
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (this.count == this.capacity);
    }

}
