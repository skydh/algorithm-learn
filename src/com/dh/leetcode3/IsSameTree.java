package com.dh.leetcode3;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 
 * @author Lenovo
 *
 */
public class IsSameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		return isSuit(p, q);

	}

	public boolean isSuit(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null)
			return true;

		if (node1 == null && node2 != null)
			return false;

		if (node2 == null && node1 != null)
			return false;

		if (node1.val != node2.val)
			return false;

		if (!isSuit(node1.left, node2.left))
			return false;

		if (!isSuit(node1.right, node2.right))
			return false;

		return true;

	}

}
