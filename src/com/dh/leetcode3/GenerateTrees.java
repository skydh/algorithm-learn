package com.dh.leetcode3;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * 
 * 示例:
 * 
 * 输入: 3 输出: [   [1,null,3,2],   [3,2,null,1],   [3,1,null,null,2],   [2,1,3],  
 * [1,null,2,null,3] ] 解释: 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * 
 * 1 3 3 2 1 \ / / / \ \ 3 2 1 1 3 2 / / \ \ 2 1 2 3
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class GenerateTrees {
	/**
	 * 参考了别人的题解
	 */
	public static List<TreeNode> generateTrees(int n) {

		return getNode(1, n);

	}

	/**
	 * 思路如下：从根节点开始，从1到n
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static List<TreeNode> getNode(int start, int end) {
		List<TreeNode> list = new ArrayList<>();
		if (start > end)
			return list;
		else if(start==end)
		{
			TreeNode node=new TreeNode(start);
			list.add(node);
			return list;
			
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> leftNodes = getNode(start, i - 1);
			List<TreeNode> rightNodes = getNode(i + 1, end);
			if (leftNodes.size() == 0) {
				for (TreeNode newNode : rightNodes) {
					TreeNode node = new TreeNode(i);
					node.left = null;
					node.right = newNode;
					list.add(node);
				}
			} else if (rightNodes.size() == 0) {
				for (TreeNode newNode : leftNodes) {
					TreeNode node = new TreeNode(i);
					node.right = null;
					node.left = newNode;
					list.add(node);
				}

			} else {
				for (TreeNode newLNode : leftNodes) {
					for (TreeNode newRNode : rightNodes) {
						TreeNode node = new TreeNode(i);
						node.left = newLNode;
						node.right = newRNode;
						list.add(node);
					}
				}

			}

		}

		return list;
	}

	public static void main(String[] args) {

		System.out.println(generateTrees(3));

	}

}
