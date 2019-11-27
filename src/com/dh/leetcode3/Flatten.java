package com.dh.leetcode3;

/**
 * 给定一个二叉树，原地将它展开为链表。
 * 
 * 例如，给定二叉树
 * 
 * 1 / \ 2 5 / \ \ 3 4 6 将其展开为：
 * 
 * 1 \ 2 \ 3 \ 4 \ 5 \ 6
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class Flatten {

	public void flatten(TreeNode root) {
		if (root == null)
			return;
		doHelper(root);
	}

	public TreeNode doHelper(TreeNode node) {

		TreeNode left = null;
		TreeNode right = null;
		TreeNode temp = node;
		if (node.left != null) {
			left = doHelper(node.left);
		}
		if (node.right != null) {
			right = doHelper(node.right);
		}
		temp.right = left;
		while (temp.right != null) {
			temp = temp.right;
		}
		temp.right = right;

		node.left = null;
		return node;

	}

	public static void main(String[] args) {

		Flatten ms = new Flatten();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);

		node1.left = node2;
		node1.right = node3;
		// node2.left = node4;
		// node3.right = node5;

		ms.flatten(node1);

	}
}
