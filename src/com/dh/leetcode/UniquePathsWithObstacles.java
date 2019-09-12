package com.dh.leetcode;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 
 * 输入: [   [0,0,0],   [0,1,0],   [0,0,0] ] 输出: 2 解释: 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径： 1. 向右 -> 向右 -> 向下 -> 向下 2. 向下 -> 向下 -> 向右 -> 向右
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 
 * @author Lenovo
 *
 */
public class UniquePathsWithObstacles {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//		int[] count = { 0 };
//		if (obstacleGrid[0][0] == 1)
//			return 0;
//		doHelper(obstacleGrid, 0, 0, count);
//		return count[0];
		return doHelper(obstacleGrid);

	}

	/**
	 * 基于动态规划 首先，寻找规律。我们发现。
	 * 
	 * 到达 n[i][j]=n[i-1][j]+n[i][j-1]
	 * 
	 * @param obstacleGrid
	 * @param cursor1
	 * @param cursor2
	 * @param count
	 */
	public int doHelper(int[][] obstacleGrid) {
		int[][] count = new int[obstacleGrid.length][obstacleGrid[0].length];
		for (int i = 0; i < obstacleGrid.length; i++) {
			if (obstacleGrid[i][0] == 0)
				count[i][0] = 1;
			else
				break;
		}
		for (int i = 0; i < obstacleGrid[0].length; i++) {
			if (obstacleGrid[0][i] == 0)
				count[0][i] = 1;
			else
				break;
		}

		for (int i = 1; i < obstacleGrid.length; i++) {
			for (int j = 1; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] == 0) {
					count[i][j] = count[i - 1][j] + count[i][j - 1];
				}

			}
		}
		return count[obstacleGrid.length-1][obstacleGrid[0].length-1];

	}

	/**
	 * 采用回溯的算法来进行处理。 遍历所有的情况，当遇到阻拦点，或者边界值，那么直接pass
	 * 
	 * 代码没有通过，时间复杂度太高。
	 * 
	 * @param obstacleGrid
	 * @return
	 */
	public void doHelper(int[][] obstacleGrid, int cursor1, int cursor2, int[] count) {
		if (cursor1 == obstacleGrid.length - 1 && cursor2 == obstacleGrid[0].length - 1) {
			count[0]++;
		}
		if (cursor1 < obstacleGrid.length - 1 && obstacleGrid[cursor1 + 1][cursor2] == 0) {

			doHelper(obstacleGrid, cursor1 + 1, cursor2, count);
		}
		if (cursor2 < obstacleGrid[0].length - 1 && obstacleGrid[cursor1][cursor2 + 1] == 0) {
			doHelper(obstacleGrid, cursor1, cursor2 + 1, count);
		}

	}

}
