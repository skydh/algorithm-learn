package com.dh.leetcode3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例: 给定如下二叉树，以及目标和 sum = 22，
 * 
 * 5 / \ 4 8 / / \ 11 13 4 / \ / \ 7 2 5 1 返回:
 * 
 * [ [5,4,11,2], [5,8,4,5] ]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class PathSum {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		List<List<Integer>> list = new ArrayList<>();

		if (root == null)
			return list;
		LinkedList<Integer> tempList = new LinkedList<>();
		tempList.add(0);
		doHelper(root, tempList, list, sum);
		return list;

	}

	public void doHelper(TreeNode node, LinkedList<Integer> tempList, List<List<Integer>> list, int target) {

		if (node.left == null && node.right == null) {
			int tempData = tempList.removeLast();
			if (tempData + node.val == target) {
				List<Integer> newList = new ArrayList<>(tempList);
				newList.add(node.val);
				list.add(newList);
			}
			tempList.add(tempData);
			return;
		}

		int tempData = tempList.removeLast();
		tempList.add(node.val);
		tempList.add(tempData + node.val);

		if (node.left != null) {
			doHelper(node.left, tempList, list, target);

		}
		if (node.right != null) {
			doHelper(node.right, tempList, list, target);
		}
		tempList.removeLast();
		tempList.removeLast();
		tempList.add(tempData);
	}

	public static void main(String[] args) {

		PathSum ms = new PathSum();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.right = node5;

		System.out.println(ms.pathSum(node1,7));

	}
}
