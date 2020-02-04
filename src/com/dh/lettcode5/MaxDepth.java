package com.dh.lettcode5;

import java.util.LinkedList;

/**
 * 给定一个 N 叉树，找到其最大深度。
 * 
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * @author Lenovo
 *
 */
public class MaxDepth {

	public int maxDepth(Node root) {
		if (root == null)
			return 0;
		LinkedList<Node> list = new LinkedList<>();
		list.add(root);
		return isSuit(list, 1, 1);

	}

	public int isSuit(LinkedList<Node> list, int size, int length) {
		if (list.size() == 0)
			return length-1;
		for (int i = 0; i < size; i++) {
			Node node = list.removeFirst();
			list.addAll(node.children);

		}
		return isSuit(list, list.size(), length + 1);

	}

}
