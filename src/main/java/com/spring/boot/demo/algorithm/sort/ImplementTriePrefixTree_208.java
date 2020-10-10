package com.spring.boot.demo.algorithm.sort;

/**前缀树
 * Created by weiyongjun on 2020/8/28
 * 实现前缀树，主要就是自定义一个node， 包含这一层出现的字符树和是否结束。
 *
 * https://leetcode.com/problems/implement-trie-prefix-tree/submissions/
 *
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/trie-tree-de-shi-xian-gua-he-chu-xue-zhe-by-huwt/
 */
public class ImplementTriePrefixTree_208 {

    class Trie {

        class TireNode {

            private boolean isEnd;
            TireNode[] node;

            public TireNode() {
                isEnd = false;
                node = new TireNode[26];
            }
        }

        private TireNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TireNode();
        }


        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TireNode node = root;
            for (char c : word.toCharArray()) {
                if (node.node[c - 'a'] == null) {
                    node.node[c - 'a'] = new TireNode();
                }
                node = node.node[c - 'a'];
            }
            node.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TireNode node = root;

            for (char c : word.toCharArray()) {
                node = node.node[c - 'a'];
                if (node == null) {
                    return false;
                }
            }
            return node.isEnd;
        }


        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            {
                TireNode node = root;

                for (char c : prefix.toCharArray()) {
                    node = node.node[c - 'a'];

                    if (node == null) {
                        return false;
                    }
                }
                return true;
            }
        }
    }
}
