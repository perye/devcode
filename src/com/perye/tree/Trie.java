package com.perye.tree;

/**
 * 208. 实现 Trie (前缀树)
 * 设计、字典树
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
 *
 * @author honggd
 */
public class Trie {

    private Trie[] children;

    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

}
