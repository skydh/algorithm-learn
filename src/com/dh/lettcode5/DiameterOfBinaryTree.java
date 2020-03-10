package com.dh.lettcode5;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 * 
 * @author Lenovo
 *
 */
public class DiameterOfBinaryTree {
	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		int[] max = { 0 };
		doHelper(root, max);
		return max[0];

	}

	public int doHelper(TreeNode node, int[] max) {
		int left = 0, right = 0;
		if (node.left != null) {
			left = doHelper(node.left, max);
		}
		if (node.right != null) {
			right = doHelper(node.right, max);
		}
		max[0] = Math.max(max[0], left + right);

		return Math.max(left, right) + 1;

	}

}
