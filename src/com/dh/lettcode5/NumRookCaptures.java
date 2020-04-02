package com.dh.lettcode5;

public class NumRookCaptures {
	public int numRookCaptures(char[][] board) {
		int row = 0, column = 0, sum = 0;
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
				if (board[i][j] == 'R') {
					row = i;
					column = j;
					break;
				}

		/**
		 * left
		 */
		int currentRow = row;
		while (currentRow >= 0) {
			if (board[currentRow][column] == 'B') {
				break;
			}
			if (board[currentRow][column] == 'p') {
				sum++;
				break;
			}

			currentRow--;

		}
		currentRow = row;
		while (currentRow < 8) {
			if (board[currentRow][column] == 'B') {
				break;
			}
			if (board[currentRow][column] == 'p') {
				sum++;
				break;
			}

			currentRow++;

		}
		int currentColumn = column;

		while (currentColumn < 8) {
			if (board[row][currentColumn] == 'B') {
				break;
			}
			if (board[row][currentColumn] == 'p') {
				sum++;
				break;
			}

			currentColumn++;

		}

		currentColumn = column;

		while (currentColumn >= 0) {
			if (board[row][currentColumn] == 'B') {
				break;
			}
			if (board[row][currentColumn] == 'p') {
				sum++;
				break;
			}

			currentColumn--;

		}
		return sum;
	}

}
