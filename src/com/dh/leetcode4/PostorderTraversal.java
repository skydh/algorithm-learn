package com.dh.leetcode4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3] 1 \ 2 / 3
 * 
 * 输出: [3,2,1] 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class PostorderTraversal {

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		LinkedList<Boolean> isExpand = new LinkedList<Boolean>();
		if (root == null)
			return result;
		list.add(root);
		isExpand.add(false);
		while (list.size() > 0) {
			TreeNode temp = list.getFirst();
			boolean isSuit = isExpand.getFirst();
			if (temp.left != null || temp.right != null) {
				if (!isSuit) {
					isExpand.removeFirst();
					isExpand.addFirst(true);
					if (temp.right != null) {
						list.addFirst(temp.right);
						isExpand.addFirst(false);
					}
					if (temp.left != null) {
						list.addFirst(temp.left);
						isExpand.addFirst(false);
					}
				} else {
					result.add(list.removeFirst().val);
					isExpand.removeFirst();
				}

			} else {
				result.add(list.removeFirst().val);
				isExpand.removeFirst();

			}

		}
		return result;
	}

}
