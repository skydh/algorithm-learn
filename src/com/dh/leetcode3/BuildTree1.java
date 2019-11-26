package com.dh.leetcode3;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 
 * 注意: 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 中序遍历 inorder = [9,3,15,20,7] 后序遍历 postorder = [9,15,7,20,3] 返回如下的二叉树：
 * 
 * 3 / \ 9 20 / \ 15 7
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-
 * postorder-traversal 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class BuildTree1 {

	/**
	 * 1：根据后序遍历来确定每次根节点的位置，因为后序遍历最后访问的是根节点，所以后序遍历最后一个位置就是根节点。
	 * 2：根据根节点和中序遍历将树划分为左右两棵树。3：根据第一步和第二步递归的处理左右两棵树。
	 * 
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public static TreeNode buildTree(int[] inorder, int[] postorder) {

		if (inorder.length == 0) {
			return null;
		}

		return doHelper(postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1);

	}

	public static TreeNode doHelper(int[] preorder, int[] inorder, int start, int end, int start1, int end1) {

		if (start > end || start > preorder.length)
			return null;
		TreeNode root = new TreeNode(preorder[end]);
		if (start == end)
			return root;

		/**
		 * 将中序的树划分为2个阶段
		 */
		int cursor = 0;
		int i = start1;
		for (; i <= end1; i++, cursor++)
			if (inorder[i] == preorder[end])
				break;
		

		root.left = doHelper(preorder, inorder, start, start + cursor-1, start1, i - 1);
		root.right = doHelper(preorder, inorder, start + cursor , end - 1, i + 1, end1);

		return root;

	}

	public static void main(String[] args) {

		int[] preorder = { 9, 3, 15, 20, 7 };
		int[] inorder = { 9, 15, 7, 20, 3 };
		System.out.println(buildTree(preorder, inorder));

	}
}
