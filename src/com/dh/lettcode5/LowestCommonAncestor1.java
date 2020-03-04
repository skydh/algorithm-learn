package com.dh.lettcode5;

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
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class LowestCommonAncestor1 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> listp = doHelper(root, p);
		List<TreeNode> listq = doHelper(root, q);
		int cursorp = listp.size() - 1;
		int cursorq = listq.size() - 1;
		while (cursorp >= 0 && cursorq >= 0) {
			if (listp.get(cursorp) != listq.get(cursorq))
				break;
			cursorp--;
			cursorq--;
		}

		return listq.get(cursorq + 1);

	}

	public List<TreeNode> doHelper(TreeNode node, TreeNode p) {
		if (node == p) {
			List<TreeNode> list = new ArrayList<>();
			list.add(p);
			return list;
		}
		if (node.left != null) {
			List<TreeNode> list = doHelper(node.left, p);
			if (list != null) {

				list.add(node);
				return list;
			}

		}
		if (node.right != null) {
			List<TreeNode> list = doHelper(node.right, p);
			if (list != null) {
				list.add(node);
				return list;
			}

		}

		return null;

	}

}
