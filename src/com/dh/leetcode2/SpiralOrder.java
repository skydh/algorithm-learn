package com.dh.leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 
 * 示例 1:
 * 
 * 输入: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] 输出: [1,2,3,6,9,8,7,4,5] 示例 2:
 * 
 * 输入: [ [1, 2, 3, 4], [5, 6, 7, 8], [9,10,11,12] ] 输出:
 * [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class SpiralOrder {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		int m = matrix.length;
		if (m == 0) {
			return list;
		}
		int n = matrix[0].length;
		doHelper(matrix, list, m, n, 0);
		return list;

	}

	/**
	 * 一圈圈遍历就好了，按照规则，，，，
	 * 
	 * @param matrix
	 * @param list
	 * @param m
	 * @param n
	 * @param times
	 */
	public void doHelper(int[][] matrix, List<Integer> list, int m, int n, int times) {
		if (times * 2 >= n || times * 2 >= m)
			return;
		/**
		 * 先遍历上边
		 */
		for (int i = times; i < n - times; i++) {
			list.add(matrix[times][i]);
		}
		/**
		 * 再遍历右边
		 */
		for (int i = times + 1; i < m - times; i++) {
			list.add(matrix[i][n - times - 1]);
		}

		if ((m - 2 * times) > 1)
			/**
			 * 再遍历下边
			 */
			for (int i = n - times - 2; i >= times; i--) {
			list.add(matrix[m - times - 1][i]);
			}

		if ((n - 2 * times) > 1)

			/**
			 * 再遍历左边
			 */
			for (int i = m - times - 2; i >= times + 1; i--) {
			list.add(matrix[i][times]);
			}

		doHelper(matrix, list, m, n, times + 1);

	}

}
