package com.dh.leetcode2;

import java.util.HashSet;

/**
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * 
 * 一个数独的解法需遵循如下规则：
 * 
 * 数字 1-9 在每一行只能出现一次。 数字 1-9 在每一列只能出现一次。 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * 
 * 
 * 
 * 一个数独。
 * 
 * 
 * 
 * 答案被标成红色。
 * 
 * Note:
 * 
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。 你可以假设给定的数独只有唯一解。 给定数独永远是 9x9 形式的。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class SolveSudoku {

	/**
	 * 时间复杂度有点高，需要剪
	 * 
	 * @param board
	 */
	@SuppressWarnings("unchecked")
	public static void solveSudoku(char[][] board) {
		HashSet<Character>[] rows = new HashSet[9];
		HashSet<Character>[] cloums = new HashSet[9];

		HashSet<Character>[] subBoard = new HashSet[9];
		for (int i = 0; i < 9; i++) {
			rows[i] = new HashSet<>();
			cloums[i] = new HashSet<>();
			subBoard[i] = new HashSet<>();
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int index = getIndex(i / 3, j / 3);
					rows[i].add(board[i][j]);
					cloums[j].add(board[i][j]);
					subBoard[index].add(board[i][j]);
				}

			}

		}
		System.out.println(doHelper(0, 0, board, rows, cloums, subBoard));
	}

	public static boolean doHelper(int i, int j, char[][] board, HashSet<Character>[] rows, HashSet<Character>[] cloums,
			HashSet<Character>[] subBoard) {

		if (i == 8 && j == 8)
			return true;
		int index = getIndex(i / 3, j / 3);
		if (board[i][j] != '.') {
			int newI, newJ;
			if (j == 8) {
				newI = i + 1;
				newJ = 0;
			} else {
				newI = i;
				newJ = j + 1;
			}
			return doHelper(newI, newJ, board, rows, cloums, subBoard);

		} else {
			for (int cursor = 1; cursor < 10; cursor++) {
				if (rows[i].contains(Character.forDigit(cursor, 10))
						|| cloums[j].contains(Character.forDigit(cursor, 10))
						|| subBoard[index].contains(Character.forDigit(cursor, 10))) {

					continue;
				} else {
					rows[i].add(Character.forDigit(cursor, 10));
					cloums[j].add(Character.forDigit(cursor, 10));
					subBoard[index].add(Character.forDigit(cursor, 10));
					board[i][j] = Character.forDigit(cursor, 10);
					int newI, newJ;
					if (j == 8) {
						newI = i + 1;
						newJ = 0;
					} else {
						newI = i;
						newJ = j + 1;
					}
					if (!doHelper(newI, newJ, board, rows, cloums, subBoard)) {
						rows[i].remove(Character.forDigit(cursor, 10));
						cloums[j].remove(Character.forDigit(cursor, 10));
						subBoard[index].remove(Character.forDigit(cursor, 10));
						board[i][j] = '.';

					} else {
						return true;
					}
				}

			}

		}
		return false;

	}

	public static int getIndex(int i, int j) {
		if (i == 0)
			return j;
		else if (i == 1)
			return 3 + j;
		else
			return 6 + j;

	}

	public static void main(String[] args) {
		
		
		System.out.println('1'>'0' && '1'<'9');

	}
}
