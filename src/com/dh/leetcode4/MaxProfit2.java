package com.dh.leetcode4;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * 
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * 
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 
 * 示例 1:
 * 
 * 输入: [3,3,5,0,0,3,1,4] 输出: 6 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 =
 * 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。   随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 =
 * 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 示例 2:
 * 
 * 输入: [1,2,3,4,5] 输出: 4 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出,
 * 这笔交易所能获得利润 = 5-1 = 4 。     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。    
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。 示例 3:
 * 
 * 输入: [7,6,4,3,1] 输出: 0 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class MaxProfit2 {

	/**
	 * 这道题，dp是一定有的，然后就是暴力，这边，我计划从简单到复杂一一实现一次。
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		if (prices.length <= 1)
			return 0;

		return method1(prices);
	}

	public static void main(String[] args) {

		MaxProfit2 sb = new MaxProfit2();
		int[] a = { 3, 3, 5, 0, 0, 3, 1, 4 };
		sb.maxProfit(a);

	}

	/**
	 * 本方法使用dp dp(i,k)表示的是第i天，最多k次交易的情况下，最大利润。
	 * 
	 * dp(i,k)=max{dp(i-1,k),p(i)-p(j)+dp(j-1,k-1)}
	 * 
	 * @param prices
	 * @return
	 */
	public int method1(int[] prices) {
		int[][] data = new int[prices.length][3];

		if (prices[1] > prices[0]) {
			data[1][1] = prices[1] - prices[0];
			data[1][2] = prices[1] - prices[0];
		}
		for (int i = 2; i < prices.length; i++) {
			for (int j = 1; j <= 2; j++) {
				data[i][j] = Math.max(data[i - 1][j], doHelper(prices, i, j, data));
			}

		}

		return data[prices.length - 1][2];

	}

	public int doHelper(int[] prices, int cursor, int k, int[][] data) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < cursor; i++) {
			int sub = prices[cursor] - prices[i];
			int temp = 0;
			if (i - 1 >= 0)
				temp = data[i - 1][k - 1];
			max = Math.max(max, sub + temp);

		}
		System.out.println(max);
		return max;

	}

	/**
	 * 暴力解法，2次，那么我们可以把数组划分为2段，每一段计算最大差值，然后相加，即可得到答案。
	 * 
	 * @param prices
	 * @return
	 */
	public int method(int[] prices) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++)
			max = Math.max(max, doHelper(prices, 0, i) + doHelper(prices, i + 1, prices.length - 1));
		return max;

	}

	/**
	 * 其实就是第一个股票问题的题解
	 * 
	 * @param prices
	 * @param start
	 * @param end
	 * @return
	 */
	public int doHelper(int[] prices, int start, int end) {
		if (start >= end)
			return 0;
		int max = Integer.MIN_VALUE;
		int min = prices[start];
		for (int i = start; i <= end; i++) {
			int sub = prices[i] - min;
			max = Math.max(sub, max);
			min = Math.min(min, prices[i]);
		}
		return max;

	}

}
