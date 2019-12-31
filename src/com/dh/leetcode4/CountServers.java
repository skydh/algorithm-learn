package com.dh.leetcode4;

/**
 * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
 * 
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 * 
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-servers-that-communicate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class CountServers {

	public int countServers(int[][] grid) {
		if (grid.length == 0)
			return 0;

		int count = 0;

		boolean[][] isGet = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {

			int cursorColumn = 0;

			int column = 0;
			while (cursorColumn < grid[0].length) {
				if (grid[i][cursorColumn] == 1)
					column++;

				cursorColumn++;
			}
			if (column >= 2) {
				cursorColumn = 0;
				while (cursorColumn < grid[0].length) {
					if (grid[i][cursorColumn] == 1)
						isGet[i][cursorColumn] = true;
					cursorColumn++;
				}
				count = count + column;
			}

		}
		for (int j = 0; j < grid[0].length; j++) {

			int cursorRow = 0;

			int row = 0;
			while (cursorRow < grid.length) {
				if (grid[cursorRow][j] == 1)
					row++;

				cursorRow++;
			}
			if (row >= 2) {
				cursorRow = 0;
				while (cursorRow < grid.length) {
					if (grid[cursorRow][j] == 1)
						if (isGet[cursorRow][j]) {
							row--;
						}

					cursorRow++;
				}
				count = count + row;
			}

		}
		return count;

	}

}
