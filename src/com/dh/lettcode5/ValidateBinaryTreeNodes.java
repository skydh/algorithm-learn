package com.dh.lettcode5;

/**
 * 二叉树上有 n 个节点，按从 0 到 n - 1 编号，其中节点 i 的两个子节点分别是 leftChild[i] 和 rightChild[i]。
 * 
 * 只有 所有 节点能够形成且 只 形成 一颗 有效的二叉树时，返回 true；否则返回 false。
 * 
 * 如果节点 i 没有左子节点，那么 leftChild[i] 就等于 -1。右子节点也符合该规则。
 * 
 * 注意：节点没有值，本问题中仅仅使用节点编号。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class ValidateBinaryTreeNodes {

	public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
		boolean[] isUse = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (!doHelper(leftChild, rightChild, isUse, i)) {
				return false;
			}
			boolean isDo = true;
			for (int j = 0; j < n; j++) {
				if (j != i) {
					if (!isUse[j]) {
						isDo = false;

					}
				}
				isUse[j] = false;
			}
			if (isDo)
				return true;
		}

		return false;

	}

	public boolean doHelper(int[] leftChild, int[] rightChild, boolean[] isUse, int cursor) {
		int left = leftChild[cursor];
		if (left != -1) {
			if (isUse[left]) {
				return false;
			} else {
				isUse[left] = true;

				if (!doHelper(leftChild, rightChild, isUse, left)) {
					return false;
				}
			}
		}
		int right = rightChild[cursor];
		if (right != -1) {
			if (isUse[right]) {
				return false;
			} else {
				isUse[right] = true;

				if (!doHelper(leftChild, rightChild, isUse, right)) {
					return false;
				}
			}
		}
		return true;

	}

}
