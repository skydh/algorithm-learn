package com.dh.leetcode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallest {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * 个人觉得不难，简单来说，对于二叉搜索树，先中序遍历（左主右），然后获取数据即可
	 * 
	 * @param root
	 * @param k
	 * @return
	 */
	public int kthSmallest(TreeNode root, int k) {
		List<Integer> list = new ArrayList<>();
		doHelper(root,k,list);
		return list.get(k-1);

	}

	public void doHelper(TreeNode root, int k, List<Integer> list) {
		if (list.size() == k)
			return;
		if (root.left != null)
			doHelper(root.left, k, list);
		list.add(root.val);
		if (root.right != null)
			doHelper(root.right, k, list);

	}

}
