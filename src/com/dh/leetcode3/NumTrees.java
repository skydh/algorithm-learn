package com.dh.leetcode3;

/**
 * 
 * 
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * 
 * 示例:
 * 
 * 输入: 3 输出: 5 解释: 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * 
 * 1 3 3 2 1 \ / / / \ \ 3 2 1 1 3 2 / / \ \ 2 1 2 3
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 1/4
 * 
 * 
 * @author Lenovo
 *
 */
public class NumTrees {

	/**
	 * 找规律
	 * 
	 * @param n
	 * @return
	 */
	public int numTrees(int n) {

		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		int[] datas = new int[n + 1];
		datas[0] = 1;
		datas[1] = 1;
		datas[2] = 2;

		for (int i = 3; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= i; j++) {
				sum = sum + datas[j - 1] * datas[i - j];
			}
			datas[i] = sum;
		}

		return datas[n];

	}

}
