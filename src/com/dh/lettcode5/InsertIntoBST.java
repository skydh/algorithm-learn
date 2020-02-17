package com.dh.lettcode5;

public class InsertIntoBST {

	public TreeNode insertIntoBST(TreeNode root, int val) {
		TreeNode node = root;
		TreeNode newNode = new TreeNode(val);
		while (node != null) {
			if (node.val >= val) {
				if (node.left == null) {
					node.left = newNode;
					break;
				}
			} else {
			}

		}

		return root;

	}

}
