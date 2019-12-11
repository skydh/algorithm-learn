package com.dh.leetcode4;

/**
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * 
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 
 * 计算从根到叶子节点生成的所有数字之和。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3] 1 / \ 2 3 输出: 25 解释: 从根到叶子节点路径 1->2 代表数字 12. 从根到叶子节点路径 1->3 代表数字
 * 13. 因此，数字总和 = 12 + 13 = 25. 示例 2:
 * 
 * 输入: [4,9,0,5,1] 4 / \ 9 0  / \ 5 1 输出: 1026 解释: 从根到叶子节点路径 4->9->5 代表数字 495.
 * 从根到叶子节点路径 4->9->1 代表数字 491. 从根到叶子节点路径 4->0 代表数字 40. 因此，数字总和 = 495 + 491 + 40
 * = 1026.
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class SumNumbers {

	public int sumNumbers(TreeNode root) {
		if(root==null)
			return 0;
		return doHelper(root, 0);

	}

	public int doHelper(TreeNode node, int num) {
		int sum = 0;
		if (node.left != null)
			sum = sum + doHelper(node.left, (num + node.val) * 10);
		if (node.right != null)
			sum = sum + doHelper(node.right, (num + node.val) * 10);

		if (sum == 0)
			return num + node.val;
		return sum;

	}

}
