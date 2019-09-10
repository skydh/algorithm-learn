package com.dh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x
 * 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 *
 * 
 * @author Lenovo
 *
 */
public class LowestCommonAncestor {

	/**
	 * 深度优先遍历，记录整条路径，找到则记录存起来，然后比对这2个路径，然后找出最深的那个节点。
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		List<TreeNode> list1 = new ArrayList<>();
		List<TreeNode> list2 = new ArrayList<>();
		getData(root, p, list1);
		getData(root, q, list2);
		int cursor = 0;
		for (; cursor < list1.size() && cursor < list2.size(); cursor++) {
			if (list1.get(cursor) != list2.get(cursor))
				break;

		}
		return list1.get(cursor - 1);

	}

	public boolean getData(TreeNode node, TreeNode p, List<TreeNode> list) {
		if (node == p) {
			list.add(node);
			return true;
		}
		list.add(node);
		if (node.left != null) {
			if (getData(node.left, p, list))
				return true;
		}
		if (node.right != null) {
			if (getData(node.right, p, list))
				return true;
		}
		list.remove(list.size() - 1);
		return false;

	}

	public static void main(String[] args) {
		LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
		TreeNode ListNode1 = new TreeNode(1);
		TreeNode ListNode2 = new TreeNode(2);
		TreeNode ListNode3 = new TreeNode(3);
		TreeNode ListNode4 = new TreeNode(4);
		ListNode1.left = ListNode2;
		ListNode1.right = ListNode3;
		ListNode2.left = ListNode4;

		lowestCommonAncestor.lowestCommonAncestor(ListNode1, ListNode3, ListNode4);
	}

}
