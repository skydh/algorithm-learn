package com.dh.search.tree.Trietree;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典树，第二次实现啦还是和之前一样时26个小写字母。 因此字典树是个超级多叉树，由于只有26个小写字母，因此是最多26叉树
 * 算法分析，首先是个root节点，然后就是节点的定义，如何设计呢，比如数据a,ab,abc,acd,adf,因此一个节点下可能存在多个子节点
 * 
 * 我们要做到输入一个a，出来所有的abc，adf等之类的效果，根绝ASCII码表，所有字母-'a'得到index
 * 
 * 
 * 
 * 
 * @author Lenovo
 *
 */
public class TrieTree {

	/**
	 * 我们如此定义节点的
	 * 
	 * @author Lenovo
	 *
	 */
	public class TrieNode {
		public char data;// 节点数据
		public TrieNode[] children = new TrieNode[26];// 子节点地址。

		public boolean isWorld = false;// 判断到了这个节点是否为一个完整的单词

		public TrieNode(char data) {
			this.data = data;
		}
	}

	private TrieNode root;

	public TrieTree() {
		root = new TrieNode('/');
	}

	/**
	 * 插入值进去
	 * 
	 * @param chars
	 */
	public void insert(char[] chars) {
		TrieNode temp = root;
		for (int i = 0; i < chars.length; i++) {
			int index = chars[i] - 'a';
			if (temp.children[index] == null) {
				TrieNode newNode = new TrieNode(chars[i]);
				temp.children[index] = newNode;
			}

			temp = temp.children[index];

		}
		temp.isWorld = true;
	}

	/**
	 * 根据输入的提示信息，返回所有的匹配字段。 这里采用的手段是全匹配原则，只要前缀匹配，后续的字符串都加到list里面去。
	 * 
	 * @param chars
	 * @return
	 */
	public List<String> getData(char[] chars) {

		List<String> list = new ArrayList<>();
		TrieNode temp = root;
		boolean isRun = true;
		for (int i = 0; i < chars.length; i++) {
			int index = chars[i] - 'a';
			if (temp.children[index] == null) {
				isRun = false;
				break;
			}
			temp = temp.children[index];
		}
		if (isRun) {
			travel(temp, new String(chars).substring(0,chars.length - 1), list);
		}
		return list;

	}

	/**
	 * 采用递归的方式，遍历这个节点下所有的其他节点
	 */
	public void travel(TrieNode node, String prefix, List<String> list) {

		if (node == null) {
			return;
		}
		if (node.isWorld) {
			list.add(prefix + node.data);
		}
		for (int i = 0; i < node.children.length; i++) {
			if (node.children[i] != null) {
				travel(node.children[i], new StringBuilder(prefix).append(node.data).toString(), list);
			}
		}
	}

}
