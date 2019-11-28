package com.dh.leetcode3;

/**
 * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 * 
 * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列
 * ，而 "AEC" 不是）
 * 
 * 示例 1:
 * 
 * 输入: S = "rabbbit", T = "rabbit" 输出: 3 解释:
 * 
 * 如下图所示, 有 3 种可以从 S 中得到 "rabbit" 的方案。 (上箭头符号 ^ 表示选取的字母)
 * 
 * rabbbit ^^^^ ^^ rabbbit ^^ ^^^^ rabbbit ^^^ ^^^ 示例 2:
 * 
 * 输入: S = "babgbag", T = "bag" 输出: 5 解释:
 * 
 * 如下图所示, 有 5 种可以从 S 中得到 "bag" 的方案。 (上箭头符号 ^ 表示选取的字母)
 * 
 * babgbag ^^ ^ babgbag ^^ ^ babgbag ^ ^^ babgbag ^ ^^ babgbag ^^^
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/distinct-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class NumDistinct {

	public int numDistinct(String s, String t) {
		if (s == null || t == null)
			return 0;
		if (s.equals("") || t.equals(""))
			return 0;
		int[][] dp = new int[t.length()][s.length()];
		if (s.charAt(0) == t.charAt(0))
			dp[0][0] = 1;
		for (int i = 1; i < s.length(); i++)
			if (s.charAt(i) == t.charAt(0))
				dp[0][i] = dp[0][i - 1] + 1;
			else
				dp[0][i] = dp[0][i - 1];

		/**
		 * 这里，最后一个字符不一样的情况很简单，直接取前面的值
		 * 
		 * 
		 * 一样时，则是这样的，去掉被匹配串的最后一个，也就是取前面的值，一样，那么我去掉匹配和被匹配最后一个串的值，取前面的值即可
		 * 
		 */
		for (int i = 1; i < t.length(); i++) {
			for (int j = 1; j < s.length(); j++) {
				if (s.charAt(j) == t.charAt(i)) {
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
					;
				} else {
					dp[i][j] = dp[i][j - 1];
				}

			}
		}
		return dp[t.length() - 1][s.length() - 1];

	}

}
