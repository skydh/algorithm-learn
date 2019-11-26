package com.dh.leetcode3;

/**
 * 
 * 
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 
 * 本题中，一棵高度平衡二叉树定义为：
 * 
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 
 * 示例 1:
 * 
 * 给定二叉树 [3,9,20,null,null,15,7]
 * 
 * 3 / \ 9 20 / \ 15 7 返回 true 。
 * 
 * 示例 2:
 * 
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * 
 * 1 / \ 2 2 / \ 3 3 / \ 4 4 返回 false 。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class IsBalanced {

	public boolean isSuit = true;

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		doHelper(root, 0);

		return isSuit;

	}

	public int doHelper(TreeNode node, int times) {
		if (node == null) {
			return times;
		}
		int left = doHelper(node.left, times + 1);
		int right = doHelper(node.right, times + 1);
		if (Math.abs(left - right) > 1)
			isSuit = false;

		return Math.max(left, right);

	}

}
