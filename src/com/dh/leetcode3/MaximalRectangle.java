package com.dh.leetcode3;

/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 
 * 示例:
 * 
 * 输入: [ ["1","0","1","0","0"], ["1","0","1","1","1"], ["1","1","1","1","1"],
 * ["1","0","0","1","0"] ] 输出: 6
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class MaximalRectangle {

	/**
	 * 看见矩阵，求最值，直接想到了dp算法
	 * 
	 * @param matrix
	 * @return
	 */
	public static int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0)
			return 0;

		int[][] data = new int[matrix.length][matrix[0].length];
		if (matrix[0][0] == '1') {
			data[0][0] = 1;
		}

		/**
		 * 初始化数据
		 */
		for (int i = 1; i < matrix[0].length; i++) {
			if (matrix[0][i] == '0') {
				data[0][i] = data[0][i - 1];
			} else {
				int cursor = i - 1;
				while (cursor >= 0) {
					if (matrix[0][cursor] == '1') {
						cursor--;
					} else
						break;
				}
				data[0][i] = Math.max(data[0][i - 1], i - cursor);
			}

		}

		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == '0') {
				data[i][0] = data[i - 1][0];
			} else {
				int cursor = i - 1;
				while (cursor >= 0) {
					if (matrix[cursor][0] == '1') {
						cursor--;
					} else
						break;
				}
				data[i][0] = Math.max(data[i - 1][0], i - cursor);
			}

		}

		/**
		 * 
		 */
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == '0') {
					data[i][j] = Math.max(data[i - 1][j], data[i][j - 1]);
				} else {
					/**
					 * 若是1的话就麻烦了
					 */
					int cursorColumn = j - 1, cursorRow = i;
					int minColumn = Integer.MAX_VALUE;
					int maxValue = Integer.MIN_VALUE;
					while (cursorRow >= 0 && matrix[cursorRow][j] == '1') {
						while (cursorColumn >= 0) {
							if (matrix[cursorRow][cursorColumn] == '1') {
								cursorColumn--;
							} else
								break;

						}
						int lengthColumn = j - cursorColumn;
						if (minColumn > lengthColumn) {
							minColumn = lengthColumn;
						}
						int area = minColumn * (i - cursorRow + 1);
						if (area > maxValue) {
							maxValue = area;
						}
						cursorColumn = j - 1;
						cursorRow--;

					}
					int tempMax = Math.max(data[i - 1][j], data[i][j - 1]);
					data[i][j] = Math.max(maxValue, tempMax);

				}

			}
		}

		return data[matrix.length - 1][matrix[0].length - 1];

	}

	/**
	 * [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1",
	 * "0","0","1","0"]]
	 */

	public static void main(String[] args) {

		char[][] chars = { { '1', '1', '0', '1' }, { '1', '1', '0', '1' }, { '1', '1', '1', '1' } };
		System.out.println(maximalRectangle(chars));

	}
}
