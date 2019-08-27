package com.dh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证一个树是否为二叉搜索树。
 * 
 * 最简单的方式是中序遍历 然后判断是否从大到小有序即可。
 * 
 * @author Lenovo
 *
 */
public class IsValidBST {
	/**
	 * 中序遍历，然后判断是否有序即可 分别是左右，和右左
	 * 
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {
		/**
		 * 这个list用来存储list
		 */
		List<Integer> list = new ArrayList<>();
		if (root == null)
			return true;
		if (root.left != null)
			helper(root.left, list);
		list.add(root.val);
		if (root.right != null)
			helper(root.right, list);

		for (int i = 0; i < list.size() - 1; i++) {
			if (!(list.get(i + 1) > list.get(i)))
				return false;

		}
		return true;

	}

	public void helper(TreeNode node, List<Integer> list) {
		if (node.left != null)
			helper(node.left, list);
		list.add(node.val);
		if (node.right != null)
			helper(node.right, list);
	}

	static class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(10);
		TreeNode node2 = new TreeNode(5);

		TreeNode node3 = new TreeNode(15);

		TreeNode node4 = new TreeNode(6);

		TreeNode node5 = new TreeNode(20);
		node1.left = node2;
		node1.right = node3;

		node3.left = node4;
		node3.right = node5;
		// System.out.println(isValidBST(node1));
	}

}
