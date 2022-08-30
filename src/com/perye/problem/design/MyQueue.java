package com.perye.problem.design;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 232. 用栈实现队列
 * <p>
 * 将一个栈当作输入栈，用于压入 push 传入的数据；
 * 另一个栈当作输出栈，用于 pop 和 peek 操作。
 * 每次 pop 或 peek 时，若输出栈为空则将输入栈的全部数据依次弹出并压入输出栈，这样输出栈从栈顶往栈底的顺序就是队列从队首往队尾的顺序
 * <p>
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks/
 *
 * @author perye
 */
public class MyQueue {

    Deque<Integer> inStack;
    Deque<Integer> outStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */