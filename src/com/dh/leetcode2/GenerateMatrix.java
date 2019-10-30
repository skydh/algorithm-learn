package com.dh.leetcode2;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 
 * 示例:
 * 
 * 输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class GenerateMatrix {
	/**
	 * 按照题意，一圈圈写。
	 * 
	 * @param n
	 * @return
	 */
	public static int[][] generateMatrix(int n) {
		int[][] data = new int[n][n];
		doHelper(data, 0, 1, n);
		return data;

	}

	public static void doHelper(int[][] data, int cursor, int start, int n) {
		if (cursor * 2 >= n)
			return;
		for (int i = cursor; i < n - cursor; i++) {
			data[cursor][i] = start++;
		}

		for (int i = cursor + 1; i < n - cursor; i++) {
			data[i][n - cursor - 1] = start++;
		}

		for (int i = n - cursor - 2; i >= cursor; i--) {
			data[n - cursor - 1][i] = start++;
		}

		for (int i = n - cursor - 2; i >= cursor + 1; i--) {
			data[i][cursor] = start++;
		}
		doHelper(data, cursor+1, start, n);
	}

	public static void main(String[] args) {

		System.out.println(generateMatrix(3));

	}
}
