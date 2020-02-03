package com.dh.lettcode5;

/**
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1
 * -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * 
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * 
 * 以 10^9 + 7 为模，返回这些数字之和
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class SumRootToLeaf {
	public int sumRootToLeaf(TreeNode root) {

		return doHelper(root, root.val);

	}

	public int doHelper(TreeNode node, int temp) {
		System.out.println(temp);
		int left = 0;
		int right = 0;
		if (node.left != null)
			left = doHelper(node.left, temp * 2 + node.left.val);
		if (node.right != null)
			right = doHelper(node.right, temp * 2 + node.right.val);
		return left + right == 0 ? temp : left + right;
	}

}
