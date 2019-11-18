package com.dh.leetcode3;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3] 1 \ 2 / 3
 * 
 * 输出: [1,3,2]
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class InorderTraversal {

	/**
	 * 中序：左-本-右
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		
		List<Integer> list = new ArrayList<>();
		if(root==null)
			return list;
		doHelper(root, list);
		return list;

	}

	public void doHelper(TreeNode node, List<Integer> list) {
		if (node.left != null) {
			doHelper(node.left, list);
		}
		list.add(node.val);
		if (node.right != null) {
			doHelper(node.right, list);
		}

	}

}
