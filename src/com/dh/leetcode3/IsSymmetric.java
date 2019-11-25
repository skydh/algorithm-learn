package com.dh.leetcode3;

/**
 * 
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 
 * 1 / \ 2 2 / \ / \ 3 4 4 3 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * 
 * 1 / \ 2 2 \ \ 3 3
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class IsSymmetric {

	/**
	 * 最简单的思路是，广度优先搜索，然后维护一个栈，一个队列，进行遍历，但是人家说了，最后是递归。。。。
	 * 
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return doHelper(root.left, root.right);
	}

	public boolean doHelper(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null)
			return true;
		if (node1 != null && node2 == null)
			return false;
		if (node1 == null && node2 != null)
			return false;
		if (node1.val != node2.val)
			return false;

		if (!doHelper(node1.left, node2.right))
			return false;

		if (!doHelper(node1.right, node2.left))
			return false;
		return true;

	}

}
