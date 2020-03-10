package com.dh.lettcode5;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 
 * 假定 BST 有如下定义：
 * 
 * 结点左子树中所含结点的值小于等于当前结点的值 结点右子树中所含结点的值大于等于当前结点的值 左子树和右子树都是二叉搜索树
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class FindMode {
	/**
	 * 要求不能使用任何额外空间，但是无法判定数组大小，怎么说？
	 * 所以这是一个伪命题，意思就是空间复杂度为o(1),常量级别空间，其次，还要定义一个常量，那也是额外空间，想了下，在中序遍历的时候就可以这么做，
	 * 但是我懒，嫌麻烦，算了
	 * 
	 * @param root
	 * @return
	 */
	public int[] findMode(TreeNode root) {
		if (root == null) {
			int[] re = new int[0];
			return re;
		}

		List<Integer> list = new ArrayList<>();
		doHelper(root.left, list);
		List<Integer> result = new ArrayList<>();

		int max = 0;
		int currentMax = 1;
		int current = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			System.out.println("list.get(i)=  "+list.get(i)+"currentMax=  "+currentMax+" current =  "+current+" max =  "+max);
			if (list.get(i) == current)
				currentMax++;
			else {
				if (currentMax > max) {
					result.clear();
					result.add(current);
					max = currentMax;
					current = list.get(i);
					currentMax = 1;

				} else if (currentMax == max) {

					result.add(current);
					current = list.get(i);
					currentMax = 1;
				}

			}

		}
		if (currentMax > max) {
			result.clear();
			result.add(current);

		} else if (currentMax == max) {
			result.add(current);
		}

		int[] re = new int[result.size()];
		for (int i = 0; i < re.length; i++)
			re[i] = result.get(i);

		return re;

	}

	public void doHelper(TreeNode root, List<Integer> result) {

		if (root.left != null) {
			doHelper(root.left, result);
		}
		result.add(root.val);
		
		if (root.right != null) {
			doHelper(root.right, result);
		}

	}

}
