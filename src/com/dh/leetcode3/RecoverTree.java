package com.dh.leetcode3;

/**
 * 二叉搜索树中的两个节点被错误地交换。
 * 
 * 请在不改变其结构的情况下，恢复这棵树。
 * 
 * 示例 1:
 * 
 * 输入: [1,3,null,null,2]
 * 
 *   1   /  3   \   2
 * 
 * 输出: [3,1,null,null,2]
 * 
 *   3   /  1   \   2 示例 2:
 * 
 * 输入: [3,1,4,null,null,2]
 * 
 * 3 / \ 1 4   /   2
 * 
 * 输出: [2,1,4,null,null,3]
 * 
 * 2 / \ 1 4   /  3
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class RecoverTree {

	public static TreeNode lastNode = null;

	/**
	 * \ 题目的难点在于n级别的遍历 常量级别空间。
	 * 
	 * 
	 * 思路如下，第一次中序，找出第一个顺序的节点
	 * 
	 * 第二次中序，将这个点的值和适当的值交换
	 * 
	 * @param root
	 */
	public static void recoverTree(TreeNode root) {
		if (root == null)
			return;

		/**
		 * 获取不按照顺序的node
		 */
		getNode(root);
		TreeNode targetNode = lastNode;
		System.out.println(targetNode.val);

		lastNode = null;
		getNode(root, targetNode);
		System.out.println(lastNode.val);
		
		
		int temp = targetNode.val;
		targetNode.val = lastNode.val;
		lastNode.val = temp;

	}

	public static boolean getNode(TreeNode node) {

		if (node.left != null)
			if (getNode(node.left))
				return true;

		if (lastNode == null)
			lastNode = node;

		if (node.val > lastNode.val)
			lastNode = node;

		if (node.val < lastNode.val)
			return true;

		if (node.right != null)
			if (getNode(node.right))
				return true;
		return false;
	}

	public static boolean getNode(TreeNode node, TreeNode targetNode) {
		if (node.left != null)
			if (getNode(node.left, targetNode))
				return true;

		if (lastNode == null)
			lastNode = node;
		if (node.val <= targetNode.val)
			lastNode = node;
		if (node.val > targetNode.val) {
			return true;
		}

		if (node.right != null)
			if (getNode(node.right, targetNode))
				return true;
		return false;
	}

	public static void main(String[] args) {

		TreeNode node3 = new TreeNode(3);

		TreeNode node1 = new TreeNode(1);
		TreeNode node4 = new TreeNode(4);
		TreeNode node2 = new TreeNode(2);

		node3.left = node1;
		node3.right = node4;
		node4.left = node2;

		recoverTree(node3);

	}
}
