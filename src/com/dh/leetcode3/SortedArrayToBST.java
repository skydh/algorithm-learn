package com.dh.leetcode3;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 
 * 示例:
 * 
 * 给定有序数组: [-10,-3,0,5,9],
 * 
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * 
 * 0 / \ -3 9 / / -10 5
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-
 * tree 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class SortedArrayToBST {

	/**
	 * 前面刷了前序和中序，后序，转换为树的题目，对于中序和前序和后序理解更加深入。
	 * 
	 * @param nums
	 * @return
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		return doHelper(nums, 0, nums.length - 1);

	}

	public TreeNode doHelper(int[] nums, int start, int end) {

		if (start > end)
			return null;
		if (start == end)
			return new TreeNode(nums[start]);
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = doHelper(nums, start, mid - 1);
		root.right = doHelper(nums, mid + 1, end);
		return root;
	}

}
