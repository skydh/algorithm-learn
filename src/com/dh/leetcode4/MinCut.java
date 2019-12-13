package com.dh.leetcode4;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 
 * 返回符合要求的最少分割次数。
 * 
 * 示例:
 * 
 * 输入: "aab" 输出: 1 解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class MinCut {
	/**
	 * 找出公式， dp(n)=min(dp(i)+1) 这个i指的是这当前字母回溯前面的点。
	 */
	public int minCut(String s) {
		int[] dp = new int[s.length()];

		for (int i = 1; i < s.length(); i++) {

			if (isSuit(s, 0, i)) {
				dp[i] = 0;
				continue;
			}

			int min = Integer.MAX_VALUE;
			int j = 0;

			while (j <= i) {
				if (isSuit(s, j, i)) {
					int temp = dp[j - 1] + 1;
					if (min > temp)
						min = temp;

				}
				j++;
			}

			dp[i] = min;
		}
		return dp[s.length() - 1];

	}

	/**
	 * 判断字符串是否为回文串
	 * 
	 * @param s
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean isSuit(String s, int i, int j) {
		int end = j;
		while (i <= end) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;

	}
}
