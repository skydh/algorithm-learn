package com.dh.dynamic;

/**
 * 动态规划解决 01背包问题，这个只，仅仅求出最大值即可，不需要求出具体搭配
 * 
 * 其实也很简单，放入一个个物品，看看有多少种可能，超过的pass即可
 * 
 * @author Lenovo
 *
 */
public class DynamicFor01 {

	public int maxSize(int[] data, int packageCapacity) {
		boolean[][] maxWeights = new boolean[data.length][packageCapacity + 1];
		if (data.length <= 0)
			return 0;

		if (data[0] <= packageCapacity)
			maxWeights[0][data[0]] = true;
		maxWeights[0][0] = true;
		for (int i = 1; i < data.length; i++) {

			// 这里要做的是要么把数据放进去，要么不放数据进去
			for (int j = 0; j < packageCapacity; j++) {
				maxWeights[i][j] = maxWeights[i - 1][j];
			}
			// 放进去
			for (int j = 0; j < packageCapacity - data[i]; j++) {
				if (maxWeights[i - 1][j]) {
					maxWeights[i][j + data[i]] = true;
				}
			}
		}
		int maxWeight = 0;
		for (int i = packageCapacity - 1; i >= 0; i--) {
			if (maxWeights[data.length - 1][i]) {
				maxWeight = i;
				break;
			}

		}
		return maxWeight;
	}

}
