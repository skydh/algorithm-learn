package com.dh.leetcode3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 
 * 例如： 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * 3 / \ 9 20 / \ 15 7 返回其自底向上的层次遍历为：
 * 
 * [ [15,7], [9,20], [3] ]
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class LevelOrderBottom {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		Queue<TreeNode> treeList = new LinkedList<>();
		treeList.add(root);
		doHelper(list, treeList);
		return list;
	}

	public void doHelper(List<List<Integer>> list, Queue<TreeNode> treeList) {
		int size = treeList.size();
		if (size == 0)
			return;
		List<Integer> intList = new ArrayList<>();

		Queue<TreeNode> treeNewList = new LinkedList<>(treeList);
		for (int i = 0; i < size; i++) {
			TreeNode node = treeList.poll();
			if (node.left != null)
				treeList.offer(node.left);
			if (node.right != null)
				treeList.offer(node.right);

		}
		doHelper(list, treeList);
		for (int i = 0; i < size; i++) {
			TreeNode node = treeNewList.poll();
			intList.add(node.val);
		}
		list.add(intList);

	}

}
