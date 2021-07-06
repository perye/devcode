package com.perye.design;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存机制
 * <p>
 * 链接：https://leetcode-cn.com/problems/lru-cache/
 *
 * @author perye
 */
public class LRUCache {

    class Node {
        int k, v;
        Node l, r;

        Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    int capacity;
    Node head, tail;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.r = tail;
        tail.l = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            // 刷新
            refresh(node);
            return node.v;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.v = value;
        } else {
            if (map.size() == capacity) {
                Node del = tail.l;
                map.remove(del.k);
                // 删除
                delete(del);
            }
            node = new Node(key, value);
        }
        map.put(key, node);
        // 刷新
        refresh(node);
    }

    /**
     * 将当前节点从双向链表中移除
     * 由于我们预先建立 head 和 tail 两位哨兵，因此如果 node.l 不为空，则代表了 node 本身存在于双向链表（不是新节点）
     *
     * @param node
     */
    void delete(Node node) {
        if (node.l != null) {
            Node left = node.l;
            left.r = node.r;
            node.r.l = left;
        }
    }

    void refresh(Node node) {
        // 先将当前节点从双向链表中删除（如果该节点本身存在于双向链表中的话）
        delete(node);
        // 将当前节点添加到双向链表头部
        node.r = head.r;
        node.l = head;
        head.r.l = node;
        head.r = node;
    }

}
