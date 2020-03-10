package com.dh.lettcode5;

/**
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地)
 * 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 * 
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class MaxAreaOfIsland {

	public int maxAreaOfIsland(int[][] grid) {
		boolean[][] isUse = new boolean[grid.length][grid[0].length];
		int max = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1 && !isUse[i][j]) {
					isUse[i][j] = true;
					max = Math.max(max, doHelper(grid, isUse, i, j));
				}
			}
		}
		return max;

	}

	public int doHelper(int[][] grid, boolean[][] isUse, int i, int j) {
		int size = 1;
		if (i - 1 >= 0) {
			if (grid[i - 1][j] == 1 && !isUse[i - 1][j]) {
				isUse[i - 1][j] = true;
				size = size + doHelper(grid, isUse, i - 1, j);
			}
		}
		if (i + 1 < grid.length) {
			if (grid[i + 1][j] == 1 && !isUse[i + 1][j]) {
				isUse[i + 1][j] = true;
				size = size + doHelper(grid, isUse, i + 1, j);
			}
		}
		if (j - 1 >= 0) {
			if (grid[i][j - 1] == 1 && !isUse[i][j - 1]) {
				isUse[i][j - 1] = true;
				size = size + doHelper(grid, isUse, i, j - 1);
			}
		}

		if (j + 1 < grid[0].length) {
			if (grid[i][j + 1] == 1 && !isUse[i][j + 1]) {
				isUse[i][j + 1] = true;
				size = size + doHelper(grid, isUse, i, j + 1);
			}
		}

		return size;

	}

	public static void main(String[] args) {

		MaxAreaOfIsland s = new MaxAreaOfIsland();
		// int[][] data = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1,
		// 1 }, { 0, 0, 0, 1, 1 } };
		int[][] data = { { 0, 1 }, { 1, 1 } };
		System.out.println(s.maxAreaOfIsland(data));
	}
}
