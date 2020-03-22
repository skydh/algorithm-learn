package com.dh.lettcode5;

/**
 * 
 * 从顶层的第一个玻璃杯开始倾倒一些香槟，当顶层的杯子满了，任何溢出的香槟都会立刻等流量的流向左右两侧的玻璃杯。当左右两边的杯子也满了，
 * 就会等流量的流向它们左右两边的杯子，依次类推。（当最底层的玻璃杯满了，香槟会流到地板上）
 * 
 * 例如，在倾倒一杯香槟后，最顶层的玻璃杯满了。倾倒了两杯香槟后，第二层的两个玻璃杯各自盛放一半的香槟。在倒三杯香槟后，第二层的香槟满了 -
 * 此时总共有三个满的玻璃杯。在倒第四杯后，第三层中间的玻璃杯盛放了一半的香槟，他两边的玻璃杯各自盛放了四分之一的香槟，如下图所示。
 * 
 * 
 * 
 * 现在当倾倒了非负整数杯香槟后，返回第 i 行 j 个玻璃杯所盛放的香槟占玻璃杯容积的比例（i 和 j都从0开始）。
 * 
 * 
 * 
 * 示例 1: 输入: poured(倾倒香槟总杯数) = 1, query_glass(杯子的位置数) = 1, query_row(行数) = 1 输出:
 * 0.0 解释: 我们在顶层（下标是（0，0））倒了一杯香槟后，没有溢出，因此所有在顶层以下的玻璃杯都是空的。
 * 
 * 示例 2: 输入: poured(倾倒香槟总杯数) = 2, query_glass(杯子的位置数) = 1, query_row(行数) = 1 输出:
 * 0.5 解释: 我们在顶层（下标是（0，0）倒了两杯香槟后，有一杯量的香槟将从顶层溢出，位于（1，0）的玻璃杯和（1，1）的玻璃杯平分了这一杯香槟，
 * 所以每个玻璃杯有一半的香槟。
 * 
 * @author Lenovo
 *
 */
public class ChampagneTower {
	public double champagneTower(int poured, int query_row, int query_glass) {
		double[][] dp = new double[query_row + 1][query_row + 1];
		dp[0][0] = poured;
		for (int i = 1; i < query_row + 1; i++) {
			for (int j = 0; j <= i; j++) {
				double left = 0, right = 0;
				if (j - 1 >= 0) {
					if (dp[i - 1][j - 1] > 1) {
						left = (dp[i - 1][j - 1] - 1) / 2;
					}
				}
				if (dp[i - 1][j] > 1) {
					right = (dp[i - 1][j] - 1) / 2;
				}
				dp[i][j] = left + right;

			}
		}

		return dp[query_row][query_glass] > 1 ? 1 : dp[query_row][query_glass];

	}

	public static void main(String[] args) {
		ChampagneTower ct=new ChampagneTower();
		System.out.println(ct.champagneTower(4, 2, 1));
	}
}
