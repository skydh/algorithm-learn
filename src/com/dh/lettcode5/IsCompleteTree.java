package com.dh.lettcode5;

import java.util.LinkedList;

/**
 * 给定一个二叉树，确定它是否是一个完全二叉树。
 * 
 * 百度百科中对完全二叉树的定义如下：
 * 
 * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h
 * 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class IsCompleteTree {
	public boolean isCompleteTree(TreeNode root) {

		LinkedList<TreeNode> list = new LinkedList<>();
		list.add(root);
		return isSuit(list, 1);

	}

	public boolean isSuit(LinkedList<TreeNode> list, int size) {
		
		for (int i = 0; i < size; i++) {
			TreeNode node = list.removeFirst();
			list.add(node.left);
			list.add(node.right);
		}
		size = size * 2;

		int newSize = size - 1;
		while (newSize >= 0) {
			if (list.get(newSize) == null) {
				list.remove(newSize);
			} else {
				break;
			}
			newSize--;

		}
		for (int i = 0; i <= newSize; i++) {
			if (list.get(i) == null)
				return false;
		}
		if (list.size() == size) {
			return isSuit(list, size);
		} else {
			for (int i = 0; i <= newSize; i++) {
				if (list.get(i).left != null || (list.get(i).right != null))
					return false;
			}
			return true;
		}

	}

}
