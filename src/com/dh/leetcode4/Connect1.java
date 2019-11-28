package com.dh.leetcode4;

public class Connect1 {

	public Node connect(Node root) {
		doHelper(root);
		return root;

	}

	public void doHelper(Node node) {

		if (node == null || (node.left == null && node.right == null))
			return;

		Node temp = null;
		Node temp1 = node;
		if (node.left != null && node.right != null) {
			node.left.next = node.right;
			temp = node.right;
		}
		if (node.left == null && node.right != null)
			temp = node.right;
		if (node.left != null && node.right == null)
			temp = node.left;
		while (temp1.next != null) {
			if (temp1.next.left != null && temp1.next.right != null) {
				temp.next = temp1.next.left;
				temp1.next.left = temp1.next.right;
				temp = temp1.next.right;
			}
			if (temp1.next.left == null && temp1.next.right != null) {
				temp1.next = temp1.next.right;
				temp1 = temp1.next.right;
			}
			if (temp1.next.left != null && temp1.next.right == null) {
				temp1.next = temp1.next.left;
				temp = temp1.next.left;
			}
			temp1 = temp1.next;

		}

		doHelper(node.left);

		doHelper(node.right);
	}

}
