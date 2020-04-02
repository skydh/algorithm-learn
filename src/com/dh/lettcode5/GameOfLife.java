package com.dh.lettcode5;

public class GameOfLife {
	/***
	 * 原地的算法思想只有一个 用其他状态位来代替 这里我用3->d-l 4->l-d
	 * 
	 * @param board
	 */
	public void gameOfLife(int[][] board) {
		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[0].length; j++) {

				int count = 0;
				if (i - 1 >= 0) {
					if (board[i - 1][j] == 1 || board[i - 1][j] == 4) {
						count++;
					}
					if (j - 1 >= 0 && (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 4)) {
						count++;
					}
					if (j + 1 < board[0].length && (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 4)) {
						count++;
					}
				}

				if (j - 1 >= 0 && (board[i][j - 1] == 1 || board[i][j - 1] == 4)) {
					count++;
				}
				if (j + 1 < board[0].length && (board[i][j + 1] == 1 || board[i][j + 1] == 4)) {
					count++;
				}
				if (i + 1 < board.length) {
					if (board[i + 1][j] == 1 || board[i + 1][j] == 4) {
						count++;
					}
					if (j - 1 >= 0 && (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 4)) {
						count++;
					}
					if (j + 1 < board[0].length && (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 4)) {
						count++;
					}
				}

				if (board[i][j] == 0) {
					if (count == 3)
						board[i][j] = 3;
				} else {
					if (count > 3 || count < 2)
						board[i][j] = 4;
				}

			}
		}
		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 3) {
					board[i][j] = 1;
				}
				if (board[i][j] == 4) {
					board[i][j] = 0;
				}
			}
		}
	}

}
