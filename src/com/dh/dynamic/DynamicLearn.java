package com.dh.dynamic;

/**
 * 动态规划就是把问题分成一个一个进行处理， 比如0/1背包问题，可以使用决策树进行处理。分成一个一个的，每一个都要在前一个的基础上处理
 * 
 * 
 * 举个简单的例子，回溯算法，和动态规划有点分不清楚，但是这里我有了新的想法，使用回溯时，是把每条线都一个个走下去，走到底，动态规划则是，更具你前一个走的
 * 结果，再来走下一步
 * 
 * @author Lenovo
 *
 */
public class DynamicLearn {

	// weight: 物品重量，n: 物品个数，w: 背包可承载重量
	public int knapsack(int[] weight, int n, int w) {
		boolean[][] states = new boolean[n][w + 1]; // 默认值 false
		states[0][0] = true; // 第一行的数据要特殊处理，可以利用哨兵优化
		if (weight[0] <= w) {
			states[0][weight[0]] = true;
		}
		for (int i = 1; i < n; ++i) { // 动态规划状态转移
			for (int j = 0; j <= w; ++j) {// 不把第 i 个物品放入背包
				if (states[i - 1][j] == true)
					states[i][j] = states[i - 1][j];
			}
			for (int j = 0; j <= w - weight[i]; ++j) {// 把第 i 个物品放入背包

				if (states[i - 1][j] == true)
					states[i][j + weight[i]] = true;
			}
		}
		for (int i = w; i >= 0; --i) { // 输出结果
			if (states[n - 1][i] == true)
				return i;
		}
		return 0;
	}

	public static int knapsack3(int[] weight, int[] value, int n, int w) {
		int[][] temp = new int[n][w];
		if (weight[0] < w) {
			temp[0][weight[0]] = value[0];
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= w; j++) {
				temp[i][j] = temp[i - 1][j];
			}
			for (int j = 0; j < w - weight[i]; j++) {
				temp[i][j + weight[i]] = temp[i - 1][j] + value[i];
			}

		}
		return w;

	}

}
