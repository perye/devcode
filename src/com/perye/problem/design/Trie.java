package com.perye.problem.design;

/**
 * Trie (前缀树)
 *
 * @author honggd
 */
public class Trie {

    class TrieNode {
        boolean end;
        TrieNode[] trieNodes = new TrieNode[26];
    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (p.trieNodes[u] == null) {
                p.trieNodes[u] = new TrieNode();
            }
            p = p.trieNodes[u];
        }
        p.end = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (p.trieNodes[u] == null) {
                return false;
            }
            p = p.trieNodes[u];
        }
        return p.end;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            int u = prefix.charAt(i) - 'a';
            if (p.trieNodes[u] == null) {
                return false;
            }
            p = p.trieNodes[u];
        }
        return true;
    }
}
