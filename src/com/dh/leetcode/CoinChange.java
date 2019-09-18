package com.dh.leetcode;

import java.util.PriorityQueue;

/**
 * 给定不同面额的硬币 coins 和一个总金额
 * amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 
 * 示例 1:
 * 
 * 输入: coins = [1, 2, 5], amount = 11 输出: 3 解释: 11 = 5 + 5 + 1 示例 2:
 * 
 * 输入: coins = [2], amount = 3 输出: -1 说明: 你可以认为每种硬币的数量是无限的。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class CoinChange {

	/**
	 * 
	 * 
	 * @param coins
	 * @param amount
	 * @return
	 */
	public int coinChange(int[] coins, int amount) {
		if (amount == 0)
			return 0;

		int[] memorandum = new int[amount + 1];

		// PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (a - b));
		// doHelper1(coins, amount, 0, pq, coins.length - 1);
		// if (pq.size() == 0)
		// return -1;
		doHelper2(coins, amount, memorandum);
		return memorandum[amount];

	}

	/**
	 * 回溯算法
	 * 
	 * @param coins
	 * @param amount
	 * @param times
	 * @param pq
	 */
	public void doHelper(int[] coins, int amount, int times, PriorityQueue<Integer> pq) {
		if (amount == 0) {
			pq.add(times);
			return;
		}
		for (int i = coins.length - 1; i >= 0; i--) {
			if (amount - coins[i] >= 0)
				doHelper(coins, amount - coins[i], times + 1, pq);
		}
	}

	/**
	 * 回溯算法优化下
	 * 
	 * @param coins
	 * @param amount
	 * @param times
	 * @param pq
	 */
	public void doHelper1(int[] coins, int amount, int times, PriorityQueue<Integer> pq, int cursor) {
		if (amount == 0) {
			pq.add(times);
			return;
		}
		for (; cursor >= 0; cursor--) {
			if (amount - coins[cursor] >= 0)
				doHelper1(coins, amount - coins[cursor], times + 1, pq, cursor);
		}
	}

	/**
	 * 动态规划
	 * 
	 * f(n)=min{f(n-i)}+1 f(0)=0;
	 * 
	 * @param coins
	 * @param amount
	 * @param times
	 * @param pq
	 */
	public void doHelper2(int[] coins, int amount, int[] memorandum) {
		for (int i = 1; i <= amount; i++) {
			int cost = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (i - coins[j] >= 0 && memorandum[i - coins[j]] >= 0) {
					cost = Math.min(cost, memorandum[i - coins[j]] + 1);
				}
			}
			memorandum[i] = cost == Integer.MAX_VALUE ? -1 : cost;
		}
	}

	public static void main(String[] arg) {
		// ScheduleCourse scheduleCourse = new ScheduleCourse();
		//
		// int[][] group = { { 5, 5 }, { 4, 6 }, { 2, 6 } };
		//
		// System.out.println(scheduleCourse.scheduleCourse(group));

		CoinChange coinChange = new CoinChange();

		int[] temp = { 1,2,5 };
		System.out.println(coinChange.coinChange(temp, 11));
	}
}
