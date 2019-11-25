package com.dh.leetcode3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ，以此类推，层与层之间交替进行）。
 * 
 * 例如： 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * 3 / \ 9 20 / \ 15 7 返回锯齿形层次遍历如下：
 * 
 * [ [3], [20,9], [15,7] ]
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class ZigzagLevelOrder {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		Stack<TreeNode> treeList = new Stack<>();

		treeList.add(root);
		doHelper(list, treeList, true);
		return list;

	}

	public void doHelper(List<List<Integer>> list, Stack<TreeNode> treeList, boolean isLeft) {

		int size = treeList.size();
		if (size == 0)
			return;
		List<Integer> intList = new ArrayList<>();

		Stack<TreeNode> treeNewList = new Stack<>();
		if (isLeft) {
			for (int i = 0; i < size; i++) {
				TreeNode node = treeList.pop();
				intList.add(node.val);
				if (node.left != null)

					treeNewList.push(node.left);
				if (node.right != null)
					treeNewList.push(node.right);

			}
		} else {

			for (int i = 0; i < size; i++) {
				TreeNode node = treeList.pop();
				intList.add(node.val);
				if (node.right != null)
					treeNewList.push(node.right);
				if (node.left != null)
					treeNewList.push(node.left);

			}

		}
		list.add(intList);
		treeList = null;
		doHelper(list, treeNewList, !isLeft);

	}

}
