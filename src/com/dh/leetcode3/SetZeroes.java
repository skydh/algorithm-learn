package com.dh.leetcode3;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * 
 * 示例 1:
 * 
 * 输入: [   [1,1,1],   [1,0,1],   [1,1,1] ] 输出: [   [1,0,1],   [0,0,0],   [1,0,1]
 * ] 示例 2:
 * 
 * 输入: [   [0,1,2,0],   [3,4,5,2],   [1,3,1,5] ] 输出: [   [0,0,0,0],   [0,4,5,0],
 *   [0,3,1,0] ] 进阶:
 * 
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。 一个简单的改进方案是使用 O(m + n)
 * 的额外空间，但这仍然不是最好的解决方案。 你能想出一个常数空间的解决方案吗？
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class SetZeroes {

	/**
	 * 用自己存自己啊
	 * 
	 * @param matrix
	 */
	public void setZeroes(int[][] matrix) {

		int k = Integer.MIN_VALUE;
		for (; k <= Integer.MAX_VALUE; k++) {
			boolean isUse = false;
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[0].length; j++) {
					if (matrix[i][j] == k) {
						isUse = true;
					}
				}
			}
			if (!isUse) {
				break;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					for (int l = 0; l < matrix[0].length; l++) {
						if (matrix[i][l] != 0) {
							matrix[i][l] = k;
						}
					}

					for (int l = 0; l < matrix.length; l++) {
						if (matrix[l][j] != 0) {
							matrix[l][j] = k;
						}
					}
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == k) {
					matrix[i][j] = 0;
				}
			}
		}

	}

}
