package com.dh.leetcode2;

/**
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * 
 * 示例 1:
 * 
 * 给定 matrix = [ [1,2,3], [4,5,6], [7,8,9] ],
 * 
 * 原地旋转输入矩阵，使其变为: [ [7,4,1], [8,5,2], [9,6,3] ] 示例 2:
 * 
 * 给定 matrix = [ [ 5, 1, 9,11], [ 2, 4, 8,10], [13, 3, 6, 7], [15,14,12,16] ],
 * 
 * 原地旋转输入矩阵，使其变为: [ [15,13, 2, 5], [14, 3, 4, 1], [12, 6, 8, 9], [16, 7,10,11] ]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class Rotate {
	/**
	 * 主要是原地，2次循环即可，按照人正常逻辑去处理即可。 2次循环，第一次，每一列，倒序，第二次，每一行斜对角交换。
	 * 
	 * @param matrix
	 */
	public void rotate(int[][] matrix) {
		int length = matrix.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < matrix.length / 2; j++) {
				swap(matrix, j, i, length - j - 1, i);
			}

		}
		for (int i = 0; i < length; i++) {
			for (int j = i; j < matrix.length; j++) {
				swap(matrix, i, j, j, i);
			}

		}

	}

	/**
	 * 交换
	 * 
	 * @param data
	 * @param i
	 * @param j
	 */
	public static void swap(int[][] data, int i, int j, int i1, int j1) {
		int temp = data[i][j];
		data[i][j] = data[i1][j1];
		data[i1][j1] = temp;
	}

}
