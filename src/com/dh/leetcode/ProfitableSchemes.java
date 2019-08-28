package com.dh.leetcode;

/**
 * 帮派里有 G 名成员，他们可能犯下各种各样的罪行。
 * 
 * 第 i 种犯罪会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。
 * 
 * 让我们把这些犯罪的任何子集称为盈利计划，该计划至少产生 P 的利润。
 * 
 * 有多少种方案可以选择？因为答案很大，所以返回它模 10^9 + 7 的值。
 * 
 * 
 * 示例 1：
 * 
 * 输入：G = 5, P = 3, group = [2,2], profit = [2,3] 输出：2 解释： 至少产生 3 的利润，该帮派可以犯下罪 0
 * 和罪 1 ，或仅犯下罪 1 。 总的来说，有两种方案。 示例 2:
 * 
 * 输入：G = 10, P = 5, group = [2,3,5], profit = [6,7,8] 输出：7 解释： 至少产生 5
 * 的利润，只要他们犯其中一种罪就行，所以该帮派可以犯下任何罪行 。 有 7 种可能的计划：(0)，(1)，(2)，(0,1)，(0,2)，(1,2)，以及
 * (0,1,2)
 * 
 * 
 * 1 <= G <= 100 0 <= P <= 100 1 <= group[i] <= 100 0 <= profit[i] <= 100 1 <=
 * group.length = profit.length <= 100
 * 
 * 
 * 
 * @author Lenovo
 *
 */
public class ProfitableSchemes {

	/**
	 * 这是一个01背包问题，先用回溯写，在总结规律，用动态规划来玩。 我们可以分为执行方案1，和不执行方案2个。
	 * 
	 * @param G
	 * @param P
	 * @param group
	 * @param profit
	 * @return
	 */
	public int profitableSchemes(int G, int P, int[] group, int[] profit) {
		if (group.length == 0)
			return 0;
		int[] ans = { 0 };
		doHelper(G, P, group, profit, 1, group.length, 0, 0, ans);
		if (group[0] <= G) {
			doHelper(G, P, group, profit, 1, group.length, profit[0], group[0], ans);
		}
		return ans[0];
	}

	public void doHelper(int G, int P, int[] group, int[] profit, int cursor, int length, int currentProfit,
			int currentGroup, int[] ans) {
		if (cursor >= length) {
			if (currentProfit >= P)
				ans[0]++;
		} else {
			doHelper(G, P, group, profit, cursor + 1, length, currentProfit, currentGroup, ans);
			if (currentGroup + group[cursor] <= G) {
				doHelper(G, P, group, profit, cursor + 1, length, currentProfit + profit[cursor],
						currentGroup + group[cursor], ans);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] arg) {
		ProfitableSchemes profitableSchemes = new ProfitableSchemes();
		int G = 100;
		int P = 10;
		int[] group = { 66, 24, 53, 49, 86, 37, 4, 70, 99, 68, 14, 91, 70, 71, 70, 98, 48, 26, 13, 86, 4, 82, 1, 7, 51,
				37, 27, 87, 2, 65, 93, 66, 99, 28, 17, 93, 83, 91, 45, 3, 59, 87, 92, 62, 77, 21, 9, 37, 11, 4, 69, 46,
				70, 47, 28, 40, 74, 47, 12, 3, 85, 16, 91, 100, 39, 24, 52, 50, 40, 23, 64, 22, 2, 15, 18, 62, 26, 76,
				3, 60, 64, 34, 45, 40, 49, 11, 5, 8, 40, 71, 12, 60, 3, 51, 31, 5, 42, 52, 15, 36 };
		int[] profit = { 8, 4, 8, 8, 9, 3, 1, 6, 7, 10, 1, 10, 4, 9, 7, 11, 5, 1, 7, 4, 11, 1, 5, 9, 9, 5, 1, 10, 0, 10,
				4, 1, 1, 1, 6, 9, 3, 6, 2, 5, 4, 7, 8, 5, 2, 3, 0, 6, 4, 5, 9, 9, 10, 7, 1, 8, 9, 6, 0, 2, 9, 2, 2, 8,
				6, 10, 3, 4, 6, 1, 10, 7, 5, 4, 8, 1, 8, 5, 5, 4, 1, 1, 10, 0, 8, 0, 1, 11, 5, 4, 7, 9, 1, 11, 1, 0, 1,
				6, 8, 3 };
		System.out.println(profitableSchemes.profitableSchemes(G, P, group, profit));
	}
}
