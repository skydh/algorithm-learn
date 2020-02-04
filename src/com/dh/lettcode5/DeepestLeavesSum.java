package com.dh.lettcode5;

import java.util.LinkedList;

/**
 * 给你一棵二叉树，请你返回层数最深的叶子节点的和。
 * 
 * @author Lenovo
 *
 */
public class DeepestLeavesSum {
	public int deepestLeavesSum(TreeNode root) {
		LinkedList<TreeNode> list = new LinkedList<>();
		list.add(root);
		return isSuit(list, 1, root.val);

	}

	public int isSuit(LinkedList<TreeNode> list, int size, int sum) {
		int newSum = 0;
		for (int i = 0; i < size; i++) {
			TreeNode node = list.removeFirst();
			if (node.left != null) {
				list.add(node.left);
				newSum = newSum + node.left.val;
			}
			if (node.right != null) {
				list.add(node.right);
				newSum = newSum + node.right.val;
			}
		}
		if (list.size() == 0)
			return sum;

		return isSuit(list, list.size(), newSum);

	}

}
