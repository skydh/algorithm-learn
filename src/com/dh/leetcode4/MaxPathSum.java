package com.dh.leetcode4;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 * 
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 
 * 1 / \ 2 3
 * 
 * 输出: 6 示例 2:
 * 
 * 输入: [-10,9,20,null,null,15,7]
 * 
 *   -10    / \   9  20     /  \    15   7
 * 
 * 输出: 42
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class MaxPathSum {

	/**
	 * 中序遍历，左主右 前序遍历，主，左 ，右 后序遍历 左，右 ，主
	 * 
	 * 
	 * 正数，那么一定是优势，必须加 负数一定是劣势，但是作为关键节点，可能连接了更大的正数，所以判断。
	 * 
	 * 
	 * 
	 * 那么思路就很清晰了，后序遍历，左，右2个节点的和，以及当前子树最大值，以及最大值的和，代码逻辑很清晰，大家可以看看
	 * 
	 * 
	 * 
	 * @param root
	 * @return
	 */
	public int maxPathSum(TreeNode root) {
		/**
		 * 说了不为null，，，为null，题目就冲突了，但是为了代码稳健性，加个非空判断
		 */
		if (root == null)
			return 0;
		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		
		max[0]=Math.max(doHelper(root, max),max[0]);
		return max[0];

	}

	public int doHelper(TreeNode node, int[] max) {
		int left = 0;
		int val = node.val;
		if (node.left != null) {
			left = doHelper(node.left, max);
			max[0] = Math.max(max[0], left);
			max[0] = Math.max(max[0], left+val);
		}
		int right = 0;
		if (node.right != null) {
			right = doHelper(node.right, max);
			max[0] = Math.max(max[0], right);
			max[0] = Math.max(max[0], left+val+right);
		}
		
		int temp=Math.max(left, right);		
		val = temp > 0 ? val + temp : val;
	
		return val;

	}

}
