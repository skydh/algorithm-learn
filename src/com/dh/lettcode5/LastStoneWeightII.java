package com.dh.lettcode5;

/**
 * 有一堆石头，每块石头的重量都是正整数。
 * 
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 
 * 如果 x == y，那么两块石头都会被完全粉碎； 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头最小的可能重量。如果没有石头剩下，就返回 0。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/last-stone-weight-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class LastStoneWeightII {
	/**
	 * 很简单，先求和，除二，然后找出最接近这个值的组合，然后用剩余的减去这个值即可
	 * 
	 * @param stones
	 * @return
	 */
	public int lastStoneWeightII(int[] stones) {

		int sum = 0;
		for (int i = 0; i < stones.length; i++) {
			sum = sum + stones[i];
		}
		int ave = sum / 2;
		boolean[][] dp = new boolean[stones.length][ave + 1];
		if (stones[0] <= ave)
			dp[0][stones[0]] = true;
		dp[0][0] = true;
		for (int i = 1; i < stones.length; i++) {
			for (int j = 0; j <= ave; j++) {
				if (dp[i - 1][j]) {

					dp[i][j] = true;
					if (j <= ave - stones[i])
						dp[i][j + stones[i]] = true;
				}
			}
		}
		int min = dp[0].length - 1;
		for (; min >= 0; min--) {
			if (dp[stones.length - 1][min])
				break;

		}

		return sum - min * 2;

	}

	public static void main(String[] args) {

		LastStoneWeightII s = new LastStoneWeightII();
		int[] data = { 31, 26, 33, 21, 40 };
		System.out.println(s.lastStoneWeightII(data));

	}

}
