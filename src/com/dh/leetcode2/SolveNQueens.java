package com.dh.leetcode2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * 
 * 
 * 上图为 8 皇后问题的一种解法。
 * 
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 
 * 示例:
 * 
 * 输入: 4 输出: [ [".Q..", // 解法 1 "...Q", "Q...", "..Q."],
 * 
 * ["..Q.", // 解法 2 "Q...", "...Q", ".Q.."] ] 解释: 4 皇后问题存在两个不同的解法。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class SolveNQueens {
	/**
	 * n^n的时间复杂度，要剪，优化。目测可以dp算法处理。
	 * 
	 * @param n
	 * @return
	 */
	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> list = new ArrayList<>();
		char[][] queens = new char[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				queens[i][j] = '.';
			}

		int[][] isUse = new int[n][n];
		Set<Integer> cloumns = new HashSet<>();
		doHelper(n, list, queens, 0, cloumns, isUse);
		return list;
	}

	public static void doHelper(int n, List<List<String>> list, char[][] queens, int row, Set<Integer> cloumns,
			int[][] isUse) {
		if (row == n) {
			List<String> tempList = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				tempList.add(String.valueOf(queens[i]));
			}
			list.add(tempList);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (cloumns.contains(i))
				continue;
			if (isUse[row][i] > 0)
				continue;
			dealData(n, row, i, cloumns, isUse, true, queens);
			doHelper(n, list, queens, row + 1, cloumns, isUse);
			/**
			 * 复原
			 */
			dealData(n, row, i, cloumns, isUse, false, queens);

		}

	}

	public static void dealData(int n, int row, int column, Set<Integer> cloumns, int[][] isUse, boolean istrue,
			char[][] queens) {

		if (istrue) {
			queens[row][column] = 'Q';
			cloumns.add(column);
			isUse[row][column]++;
		} else {
			queens[row][column] = '.';
			cloumns.remove(column);
			isUse[row][column]--;
		}

		/**
		 * ** 前面行就不管了，只需要辐射到下面的行
		 *
		 * / 右下斜
		 */
		int tempRow = row + 1;
		int tempCloumns = column + 1;
		while (tempRow < n) {
			if (tempCloumns >= n)
				break;
			else {
				if (istrue)
					isUse[tempRow][tempCloumns]++;
				else
					isUse[tempRow][tempCloumns]--;
				tempRow++;
				tempCloumns++;
			}
		}
		/**
		 * 左下斜
		 */
		tempRow = row + 1;
		tempCloumns = column - 1;
		while (tempRow < n) {
			if (tempCloumns < 0)
				break;
			else {
				if (istrue)
					isUse[tempRow][tempCloumns]++;
				else
					isUse[tempRow][tempCloumns]--;
				tempRow++;
				tempCloumns--;
			}
		}
	}

	public static void main(String[] args) {

		solveNQueens(6);
		System.out.println(Integer.MAX_VALUE);

	}
}
