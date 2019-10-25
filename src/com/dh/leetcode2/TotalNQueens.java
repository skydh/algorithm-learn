package com.dh.leetcode2;

import java.util.HashSet;
import java.util.Set;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * 
 * 
 * 上图为 8 皇后问题的一种解法。
 * 
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * 
 * 示例:
 * 
 * 输入: 4 输出: 2 解释: 4 皇后问题存在如下两个不同的解法。 [  [".Q..",  // 解法 1   "...Q",   "Q...",  
 * "..Q."],
 * 
 *  ["..Q.",  // 解法 2   "Q...",   "...Q",   ".Q.."] ]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class TotalNQueens {

	public int totalNQueens(int n) {

		int[] sum = new int[1];
		char[][] queens = new char[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				queens[i][j] = '.';
			}

		int[][] isUse = new int[n][n];
		Set<Integer> cloumns = new HashSet<>();
		doHelper(n, sum, queens, 0, cloumns, isUse);
		return sum[0];
	}

	public static void doHelper(int n, int[] sum, char[][] queens, int row, Set<Integer> cloumns, int[][] isUse) {
		if (row == n) {
			sum[0]++;
			return;
		}
		for (int i = 0; i < n; i++) {
			if (cloumns.contains(i))
				continue;
			if (isUse[row][i] > 0)
				continue;
			dealData(n, row, i, cloumns, isUse, true, queens);
			doHelper(n, sum, queens, row + 1, cloumns, isUse);
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
}
