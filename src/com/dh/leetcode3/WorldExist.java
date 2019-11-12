package com.dh.leetcode3;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 
 * 示例:
 * 
 * board = [ ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E'] ]
 * 
 * 给定 word = "ABCCED", 返回 true. 给定 word = "SEE", 返回 true. 给定 word = "ABCB", 返回
 * false.
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class WorldExist {

	public boolean exist(char[][] board, String word) {
		if (board.length == 0)
			return false;
		/**
		 * 第一次遍历，找出第一个字母
		 */

		boolean[][] hasGo = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					hasGo[i][j] = true;
					if (doHelper(board, word, i, j, 1, hasGo))
						return true;
					hasGo[i][j] = false;
				}
			}
		return false;

	}

	public boolean doHelper(char[][] board, String word, int i, int j, int cursor, boolean[][] hasGo) {
		if (cursor == word.length())
			return true;
		if (i - 1 >= 0 && !hasGo[i - 1][j] && board[i - 1][j] == word.charAt(cursor)) {
			hasGo[i - 1][j] = true;
			if (doHelper(board, word, i - 1, j, cursor + 1, hasGo))
				return true;
			hasGo[i - 1][j] = false;
		}
		if (i + 1 < board.length && !hasGo[i + 1][j] && board[i + 1][j] == word.charAt(cursor)) {
			hasGo[i + 1][j] = true;
			if (doHelper(board, word, i + 1, j, cursor + 1, hasGo))
				return true;
			hasGo[i + 1][j] = false;
		}
		if (j - 1 >= 0 && !hasGo[i][j - 1] && board[i][j - 1] == word.charAt(cursor)) {
			hasGo[i][j - 1] = true;
			if (doHelper(board, word, i, j - 1, cursor + 1, hasGo))
				return true;
			hasGo[i][j - 1] = false;
		}
		if (j + 1 < board[0].length && !hasGo[i][j + 1] && board[i][j + 1] == word.charAt(cursor)) {
			hasGo[i][j + 1] = true;
			if (doHelper(board, word, i, j + 1, cursor + 1, hasGo))
				return true;
			hasGo[i][j + 1] = false;
		}

		return false;

	}

}
