package com.dh.lettcode5;

/**
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * 
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * 
 * 请你返回最终形体的表面积。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入：[[2]] 输出：10 示例 2：
 * 
 * 输入：[[1,2],[3,4]] 输出：34 示例 3：
 * 
 * 输入：[[1,0],[0,2]] 输出：16
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class SurfaceArea {

	public int surfaceArea(int[][] grid) {

		int sum = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {

				int size = grid[i][j] == 0 ? 0 : 2 + 4 * grid[i][j];

				sum = sum + size;
				if (i - 1 >= 0) {
					int min = Math.min(grid[i - 1][j], grid[i][j]);
					sum = sum - min * 2;
				}
				if (j - 1 >= 0) {
					int min = Math.min(grid[i][j - 1], grid[i][j]);
					sum = sum - min * 2;
				}

			}
		}
		return sum;

	}

	public static void main(String[] args) {
		SurfaceArea surfaceArea = new SurfaceArea();
		int[][] data = { { 1, 0 }, { 0, 2 } };
		System.out.println(surfaceArea.surfaceArea(data));

	}
}
