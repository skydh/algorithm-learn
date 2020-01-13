package com.dh.lettcode5;

/**
 * 给出一个二维数组 A，每个单元格为 0（代表海）或 1（代表陆地）。
 * 
 * 移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。
 * 
 * 返回网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入：[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]] 输出：3 解释： 有三个 1 被 0 包围。一个 1
 * 没有被包围，因为它在边界上。 示例 2：
 * 
 * 输入：[[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]] 输出：0 解释： 所有 1 都在边界上或可以到达边界。  
 * 
 * 提示：
 * 
 * 1 <= A.length <= 500 1 <= A[i].length <= 500 0 <= A[i][j] <= 1 所有行的大小都相同
 * 在真实的面试中遇到过这道题？
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/number-of-enclaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class NumEnclaves {

	public int numEnclaves(int[][] A) {
		if (A.length == 0)
			return 0;
		int[][] isArrive = new int[A.length][A[0].length];
		for (int i = 0; i < A[0].length; i++) {
			if (A[0][i] == 1) {
				isArrive[0][i] = 1;
				doHelper(A, isArrive, 0, i);
			}
			if (A[A.length - 1][i] == 1) {
				isArrive[A.length - 1][i] = 1;
				doHelper(A, isArrive, A.length - 1, i);
			}
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i][0] == 1) {
				isArrive[i][0] = 1;
				doHelper(A, isArrive, i, 0);
			}
			if (A[i][A[0].length - 1] == 1) {
				isArrive[i][A[0].length - 1] = 1;
				doHelper(A, isArrive, i, A[0].length - 1);
			}
		}

		int count = 0;
		for (int i = 0; i < A.length; i++)
			for (int j = 0; j < A[0].length; j++)
				if (isArrive[i][j] == 0 && A[i][j] == 1)
					count++;

		return count;

	}

	public void doHelper(int[][] A, int[][] isArrive, int i, int j) {

		if (i > 0 && A[i - 1][j] == 1 && isArrive[i - 1][j] != 1) {
			isArrive[i - 1][j] = 1;
			doHelper(A, isArrive, i - 1, j);
		}

		if (j > 0 && A[i][j - 1] == 1 && isArrive[i][j - 1] != 1) {
			isArrive[i][j - 1] = 1;
			doHelper(A, isArrive, i, j - 1);
		}

		if (i < A.length - 1 && A[i + 1][j] == 1 && isArrive[i + 1][j] != 1) {
			isArrive[i + 1][j] = 1;
			doHelper(A, isArrive, i + 1, j);
		}

		if (j < A[0].length - 1 && A[i][j + 1] == 1 && isArrive[i][j + 1] != 1) {
			isArrive[i][j + 1] = 1;
			doHelper(A, isArrive, i, j + 1);
		}

	}

	public static void main(String[] args) {

		NumEnclaves NumEnclaves = new NumEnclaves();
		int[][] data = {

				{ 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0 }, { 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0 },
				{ 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1 }, { 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1 },
				{ 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0 }, { 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0 },
				{ 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0 }, { 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1 } }

		;
		System.out.println(NumEnclaves.numEnclaves(data));
	}
}
