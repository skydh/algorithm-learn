package com.dh.leetcode3;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意: 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7] 中序遍历 inorder = [9,3,15,20,7] 返回如下的二叉树：
 * 
 * 3 / \ 9 20 / \ 15 7
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-
 * inorder-traversal 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class BuildTree {

	/**
	 * 1：根据前序遍历来确定每次根节点的位置，因为前序遍历先访问的是根节点，所以前序遍历第一个位置就是根节点。
	 * 2：根据根节点和中序遍历将树划分为左右两棵树。3：根据第一步和第二步递归的处理左右两棵树。
	 * 
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public static TreeNode buildTree(int[] preorder, int[] inorder) {

		if (preorder.length == 0) {
			return null;
		}

		return doHelper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);

	}

	public static TreeNode doHelper(int[] preorder, int[] inorder, int start, int end, int start1, int end1) {

		if (start > end || start > preorder.length)
			return null;
		TreeNode root = new TreeNode(preorder[start]);
		if (start == end)
			return root;

		/**
		 * 将中序的树划分为2个阶段
		 */
		int cursor = 0;
		int i = start1;
		for (; i <= end1; i++, cursor++)
			if (inorder[i] == preorder[start])
				break;

		root.left = doHelper(preorder, inorder, start + 1, start + cursor, start1, i - 1);
		root.right = doHelper(preorder, inorder, start + cursor + 1, end, i + 1, end1);

		return root;

	}

	public static void main(String[] args) {

		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		System.out.println(buildTree(preorder, inorder));

	}

}
