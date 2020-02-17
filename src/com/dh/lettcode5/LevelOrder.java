package com.dh.lettcode5;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * 
 * @author Lenovo
 *
 */
public class LevelOrder {
	class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};

	public List<List<Integer>> levelOrder(Node root) {

		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		List<Node> list = new ArrayList<>();
		list.add(root);

		doHelper(result, list);
		return result;

	}

	public void doHelper(List<List<Integer>> result, List<Node> list) {
		if (list == null || list.size() == 0)
			return;
		List<Integer> elementResult = new ArrayList<>();
		List<Node> newList = new ArrayList<>();
		for (Node node : list) {
			elementResult.add(node.val);
			newList.addAll(node.children);

		}
		result.add(elementResult);
		doHelper(result, newList);
	}

}
