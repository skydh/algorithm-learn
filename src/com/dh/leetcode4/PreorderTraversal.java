package com.dh.leetcode4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 * 
 *  示例:
 * 
 * 输入: [1,null,2,3] 1 \ 2 / 3
 * 
 * 输出: [1,2,3] 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class PreorderTraversal {

	/**
	 * 不用递归，我们仔细思考了前序遍历，发现用一个链表即可了 先插入head，然后从前面加入左节点和右节点。
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		if (root == null)
			return result;
		list.add(root);
		while (list.size() > 0) {
			TreeNode temp = list.removeFirst();
			result.add(temp.val);
			if (temp.right != null)
				list.addFirst(temp.right);
			if (temp.left != null)
				list.addFirst(temp.left);
		}
		return result;
	}
}
