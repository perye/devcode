package com.perye.problem.design;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 705. 设计哈希集合
 * <p>
 * 链地址法处理冲突
 * 链接：https://leetcode-cn.com/problems/design-hashset/
 *
 * @author perye
 */
public class MyHashSet {

    private static final int BASE = 769;
    private LinkedList[] data;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int hash = hash(key);
        Iterator<Integer> iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                return;
            }
        }
        data[hash].offerLast(key);
    }

    public void remove(int key) {
        int hash = hash(key);
        Iterator<Integer> iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                data[hash].remove(element);
                return;
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int hash = hash(key);
        Iterator<Integer> iterator = data[hash].iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (element == key) {
                return true;
            }
        }
        return false;
    }

    private static int hash(int key) {
        return key % BASE;
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */