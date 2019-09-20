package com.dh.leetcode;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 
 * 问总共有多少条不同的路径？
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class UniquePaths {
	/**
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths(int m, int n) {
		int[][] data = new int[m][n];
		for (int i = 0; i < data.length; i++) {
			data[i][0] = 1;
		}
		for (int i = 0; i < data[0].length; i++) {
			data[0][i] = 1;
		}
		for (int i = 1; i < data.length; i++) {
			for (int j = 1; j < data[0].length; j++) {
				data[i][j] = data[i - 1][j] + data[i][j - 1];
			}
		}
		return data[data.length - 1][data[0].length - 1];

	}
}
