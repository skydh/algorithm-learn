package com.dh.leetcode3;

/**
 * 给定一个二叉树，找出其最小深度。
 * 
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * 3 / \ 9 20 / \ 15 7 返回它的最小深度  2.
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class MinDepth {

	public int min = Integer.MAX_VALUE;

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;

		doHelper(root, 0);

		return min;

	}

	public void doHelper(TreeNode node, int times) {

		if (node.left == null && node.right == null) {
			if (times+1 < min)
				min = times+1;
			return;
		}
		if (node.left != null) {
			doHelper(node.left, times + 1);

		}
		if (node.right != null) {
			doHelper(node.right, times + 1);
		}

	}

	public static void main(String[] args) {

		MinDepth ms = new MinDepth();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.right = node5;

		System.out.println(ms.minDepth(node1));

	}
}
