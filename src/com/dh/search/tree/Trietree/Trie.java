package com.dh.search.tree.Trietree;

public class Trie {

	/**
	 * 字典树节点
	 * 
	 * @author Lenovo
	 *
	 */
	public class TrieNode {
		/**
		 * 值
		 */
		public char data;
		/**
		 * 子节点的值，默认全是小写字母，因此数组长度是26
		 */
		public TrieNode[] children = new TrieNode[26];
		public boolean isEndingChar = false;

		public TrieNode(char data) {
			this.data = data;
		}
	}

	private TrieNode root = new TrieNode('/'); // 存储无意义字符

	// 往 Trie 树中插入一个字符串
	public void insert(char[] text) {
		TrieNode p = root;
		for (int i = 0; i < text.length; ++i) {
			int index = text[i] - 'a';
			if (p.children[index] == null) {
				TrieNode newNode = new TrieNode(text[i]);
				p.children[index] = newNode;
			}
			p = p.children[index];
		}
		p.isEndingChar = true;
	}

	// 在 Trie 树中查找一个字符串
	public boolean find(char[] pattern) {
		TrieNode p = root;
		for (int i = 0; i < pattern.length; ++i) {
			int index = pattern[i] - 'a';
			if (p.children[index] == null) {
				return false; // 不存在 pattern
			}
			p = p.children[index];
		}
		if (p.isEndingChar == false)
			return false; // 不能完全匹配，只是前缀
		else
			return true; // 找到 pattern
	}

}
