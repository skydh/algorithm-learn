package com.dh.lettcode5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 你现在手里有一份大小为 N x N
 * 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，
 * 你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 * 
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 -
 * x1| + |y0 - y1| 。
 * 
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/as-far-from-land-as-possible
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class MaxDistance {

	public int maxDistance(int[][] grid) {
		Queue<List<Integer>> queue = new LinkedList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					List<Integer> temp = new ArrayList<>();
					temp.add(i);
					temp.add(j);
					queue.add(temp);
				}
			}
		}
		if (queue.size() == 0 || queue.size() == grid.length * grid.length)
			return -1;
		int[][] length = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					length[i][j] = 0;
				} else {
					length[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		while (queue.size() > 0) {
			List<Integer> temp = queue.remove();
			int x = temp.get(0);
			int y = temp.get(1);
			int tempLength = length[x][y] + 1;
			/**
			 * 四种情况，
			 */
			if (x + 1 < grid.length && tempLength < length[x + 1][y]) {

				length[x + 1][y] = tempLength;
				List<Integer> temp1 = new ArrayList<>();
				temp1.add(x + 1);
				temp1.add(y);
				queue.add(temp1);

			}
			if (x - 1 >= 0 && tempLength < length[x - 1][y]) {
				length[x - 1][y] = tempLength;
				List<Integer> temp1 = new ArrayList<>();
				temp1.add(x - 1);
				temp1.add(y);
				queue.add(temp1);

			}
			if (y - 1 >= 0 && tempLength < length[x][y - 1]) {
				length[x][y - 1] = tempLength;
				List<Integer> temp1 = new ArrayList<>();
				temp1.add(x);
				temp1.add(y - 1);
				queue.add(temp1);
			}
			if (y + 1 < grid.length && tempLength < length[x][y + 1]) {
				length[x][y + 1] = tempLength;
				List<Integer> temp1 = new ArrayList<>();
				temp1.add(x);
				temp1.add(y + 1);
				queue.add(temp1);
			}

		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {

				max = Math.max(length[i][j], max);

			}
		}
		return max;

	}

	public static void main(String[] args) {

		int[][] data = { { 1, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		MaxDistance max = new MaxDistance();
		System.out.println(max.maxDistance(data));
	}

}
