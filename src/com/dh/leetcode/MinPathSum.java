package com.dh.leetcode;

import java.util.PriorityQueue;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 示例:
 * 
 * 输入: [   [1,3,1], [1,5,1], [4,2,1] ] 输出: 7 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class MinPathSum {

	/**
	 * 这个问题很经典，老规矩，先回溯，再动态规划
	 * 
	 * @param grid
	 * @return
	 */
	public int minPathSum(int[][] grid) {
		// PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (a - b));
		doHelper1(grid);
		return grid[grid.length - 1][grid[0].length - 1];

	}

	/**
	 * 回溯
	 */
	public void doHelper(int[][] grid, int i, int j, int temp, PriorityQueue<Integer> pq) {
		if (i == grid.length - 1 && j == grid[0].length - 1) {
			pq.add(temp);
		}
		if (i < grid.length - 1)
			doHelper(grid, i + 1, j, temp + grid[i + 1][j], pq);
		if (j < grid[0].length - 1)
			doHelper(grid, i, j + 1, temp + grid[i][j + 1], pq);

	}

	/**
	 * 动态规划 公式如下 f(m,n)=min{f(m-1,n),f(m,n-1)}+grid[m][n]
	 */
	public void doHelper1(int[][] grid) {
		// 初始化数组
		for (int i = 1; i < grid.length; i++) {
			grid[i][0] = grid[i - 1][0] + grid[i][0];
		}
		for (int i = 1; i < grid[0].length; i++) {
			grid[0][i] = grid[0][i - 1] + grid[0][i];
		}
		for (int i = 1; i < grid.length; i++) {
			for (int j = 1; j < grid[0].length; j++) {
				grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
			}
		}

	}
}
