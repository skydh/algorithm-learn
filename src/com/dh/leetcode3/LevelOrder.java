package com.dh.leetcode3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 
 * 例如: 给定二叉树: [3,9,20,null,null,15,7],
 * 
 * 3 / \ 9 20 / \ 15 7 返回其层次遍历结果：
 * 
 * [ [3], [9,20], [15,7] ]
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class LevelOrder {

	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> list = new ArrayList<>();
		if(root==null)
			return list;
		Queue<TreeNode> treeList = new LinkedList<>();
		
		treeList.add(root);
		doHelper(list, treeList);
		return list;

	}

	public void doHelper(List<List<Integer>> list, Queue<TreeNode> treeList) {
		
		
		int size = treeList.size();
		if(size==0)
			return;
		List<Integer> intList = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			TreeNode node = treeList.poll();
			intList.add(node.val);
			if (node.left != null)
				treeList.offer(node.left);
			if (node.right != null)
				treeList.offer(node.right);

		}
		list.add(intList);
		doHelper(list, treeList);

	}

}
