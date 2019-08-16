package com.dh.backtracking;

/**
 * 八皇后问题 采用回溯算法，来实现这个问题 假设存在一个8*8的棋盘，要满足放8个皇后的方法。
 * 一行行试试，然后不断往下面走，不行了就回溯，然后不断尝试，直到找到存放方法
 * 
 * @author Lenovo
 *
 */
public class Cal8queens {

	private int[] data;
	private static int how=0;
	private int nodeNum;

	/**
	 * 8皇后问题
	 * 
	 * 
	 * 参数是n*n的棋盘
	 * 
	 * @param i
	 */
	public Cal8queens(int n) {

		data = new int[n];
		nodeNum = n;

	}

	/**
	 * 目的是找到其中任意一种解法
	 */
	public void doQueens() {
		queensAll(0);

	}

	/**
	 * 找出任意一种
	 * 
	 * @param row
	 * @return
	 */
	public boolean queens(int row) {
		if (row == nodeNum) {
			for (int i = 0; i < nodeNum; i++) {
				System.out.println(data[i]);
			}
			return true;
		}
		boolean isUse = false;
		for (int i = 0; i < nodeNum; i++) {
			if (isOk(row, i)) {
				data[row] = i;
				if (queens(row + 1)) {
					isUse = true;
					break;
				}
			}

		}
		return isUse;

	}

	/**
	 * 找出所有解法
	 * 
	 * @param row
	 * @return
	 */
	public void queensAll(int row) {
		
		if (row == nodeNum) {
			for (int i = 0; i < nodeNum; i++) {
				System.out.print("   " + data[i]);
			}
			
			System.out.println(" -------"+how++);
			return;
		}

		for (int i = 0; i < nodeNum; i++) {
			if (isOk(row, i)) {
				data[row] = i;
				queensAll(row + 1);

			}
		}
	}

	/***
	 * 判断条件是否成立
	 * 
	 * @param i
	 * @param j
	 * @param data
	 * @return
	 */
	public boolean isOk(int row, int column) {
		for (int i = 0; i < row; i++) {
			if (data[i] == column)
				return false;
			if (Math.abs(i - row) == Math.abs(data[i] - column)) {
				return false;
			}
		}
		return true;
	}

}
