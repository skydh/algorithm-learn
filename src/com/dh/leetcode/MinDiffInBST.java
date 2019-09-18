package com.dh.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 * 
 * 示例：
 * 
 * 输入: root = [4,2,6,1,3,null,null] 输出: 1 解释: 注意，root是树结点对象(TreeNode
 * object)，而不是数组。
 * 
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 * 
 * 4 / \ 2 6 / \ 1 3
 * 
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class MinDiffInBST {
	/**
	 * 二叉搜索树，前序遍历，得到有序数组，然后计算即可。
	 * 
	 * @param root
	 * @return
	 */
	public int minDiffInBST(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		preorder(root, list);
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (a - b));
		for (int i = 1; i < list.size(); i++) {
			pq.offer(list.get(i) - list.get(i - 1));
		}
		return pq.remove();
	}

	public void preorder(TreeNode node, List<Integer> list) {
		if (node.left != null) {
			preorder(node.left, list);
		}
		list.add(node.val);
		if (node.right != null) {
			preorder(node.right, list);
		}
	}
}
