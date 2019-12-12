package com.dh.leetcode4;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 
 * 示例:
 * 
 * X X X X X O O X X X O X X O X X 运行你的函数后，矩阵变为：
 * 
 * X X X X X X X X X X X X X O X X 解释:
 * 
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class Solve {

	public void solve(char[][] board) {
		if (board == null || board.length == 0)
			return;
		boolean[][] isBoard = new boolean[board.length][board[0].length];
		/**
		 * 先计算找出不要修改的节点
		 */
		for (int i = 0; i < board[0].length; i++) {
			doHelper(board, isBoard, 0, i);
			doHelper(board, isBoard, board.length - 1, i);
		}
		for (int i = 0; i < board.length; i++) {
			doHelper(board, isBoard, i, 0);
			doHelper(board, isBoard, i, board[0].length-1);
		}
		for (int i = 1; i < board.length - 1; i++) {
			for (int j = 1; j < board[0].length - 1; j++) {
				if (board[i][j] == 'O' && !isBoard[i][j])
					board[i][j] = 'X';
			}
		}

	}

	public void doHelper(char[][] board, boolean[][] isBoard, int line, int column) {

		if (line < 0 || line > board.length - 1 || column < 0 || column > board[0].length - 1)
			return;
		if (board[line][column] == 'X')
			return;
		if (isBoard[line][column])
			return;
		isBoard[line][column] = true;
		doHelper(board, isBoard, line - 1, column);
		doHelper(board, isBoard, line + 1, column);
		doHelper(board, isBoard, line, column - 1);
		doHelper(board, isBoard, line, column + 1);
	}

}
