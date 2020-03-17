package com.dh.lettcode5;

import java.util.HashSet;

/**
 * 给定不同面额的硬币 coins 和一个总金额
 * amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < coins.length; i++) {
			set.add(coins[i]);

		}

		for (int i = 0; i <= amount; i++)
			dp[i] = -1;

		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			if (set.contains(i))
				dp[i] = 1;
			else {
				for (int j = 0; j < coins.length; j++) {
					if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
						if (dp[i] == -1)
							dp[i] = dp[i - coins[j]] + 1;
						else
							dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
					}
				}

			}

		}
		return dp[amount];

	}

	public static void main(String[] args) {
		CoinChange cc = new CoinChange();
		int[] data = { 1, 2, 5 };
		System.out.println(cc.coinChange(data, 11));
	}

}
