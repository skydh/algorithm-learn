package com.dh.leetcode4;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * 
 * 示例 1:
 * 
 * @author Lenovo
 *
 */
public class FindBottomLeftValue {

	public int findBottomLeftValue(TreeNode root) {

		if (root == null)
			return -1;

		List<TreeNode> list = new ArrayList<>();
		list.add(root);

		return doHelper(list);

	}

	public int doHelper(List<TreeNode> list) {

		List<TreeNode> newList = new ArrayList<>();
		for (TreeNode node : list) {
			if (node.left != null)
				newList.add(node.left);
			if (node.right != null)
				newList.add(node.right);
		}
		if (newList.size() == 0)
			return list.get(0).val;
		else
			return doHelper(newList);

	}

}
