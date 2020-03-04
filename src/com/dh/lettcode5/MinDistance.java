package com.dh.lettcode5;

/**
 * 
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 * 
 * 示例 1:
 * 
 * 输入: "sea", "eat" 输出: 2 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea" 说明:
 * 
 * 给定单词的长度不超过500。 给定单词中的字符只含有小写字母。
 * 
 * @author Lenovo
 *
 */
public class MinDistance {

	/**
	 * dp算法， 先求出最长公共子串。
	 * 
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int minDistance(String word1, String word2) {
		if (word1 == null || word2 == null)
			return -1;
		if (word1.length() == 0)
			return word2.length();
		if (word2.length() == 0)
			return word1.length();
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		/**
		 * 若是 i,j一样，那么最长公共子串等于dp(i-1)(j-1)+1 不一样，那么随机去掉一个i,或者j,剩余的那个大就是哪个
		 */
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return word1.length()+word2.length()-2*dp[word1.length()][word2.length()];

	}

	public static void main(String[] args) {

		MinDistance min = new MinDistance();
		System.out.println(min.minDistance("intet", "exect"));

	}
}
