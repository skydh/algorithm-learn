package com.dh.leetcode;

import java.util.PriorityQueue;

/**
 * # 5 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。 示例 2：
 * 
 * 输入: "cbbd" 输出: "bb
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 *
 */
public class LongestPalindrome {

	/**
	 * 每个字符为中心点，来试试 成功的条件是 1，左右各减一的字符相同 .
	 * 
	 * 回文串是偶数的情况则是，用2个点，不断位移
	 * 
	 * 还有一种情况是demo2,就是一样的字符，我这样是检测不出来的，在遍历一次就好。
	 * 
	 * @param s
	 * @return
	 */
	public static String longestPalindrome(String s) {
		if (s == null)
			return "";
		if (s.length() == 0)
			return "";
		char[] chars = s.toCharArray();
		PriorityQueue<String[]> pq = new PriorityQueue<>((a, b) -> (Integer.parseInt(b[1]) - Integer.parseInt(a[1])));
		for (int i = 0; i < chars.length; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append(chars[i]);
			int left = i - 1, right = i + 1;
			while (left >= 0 && right < chars.length) {
				if (chars[left] == chars[right]) {
					sb.insert(0, chars[left--]);
					sb.append(chars[right++]);
				} else {
					break;
				}

			}
			if (right - left - 2 > 0) {
				String[] newString = new String[2];
				newString[0] = sb.toString();
				newString[1] = String.valueOf(right - left - 1);
				pq.add(newString);

			}

		}

		for (int i = 1; i < chars.length; i++) {
			if (chars[i - 1] == chars[i]) {
				StringBuilder sb = new StringBuilder();
				sb.append(chars[i]);
				sb.insert(0, chars[i - 1]);
				int left = i - 2, right = i + 1;
				while (left >= 0 && right < chars.length) {
					if (chars[left] == chars[right]) {
						sb.insert(0, chars[left--]);
						sb.append(chars[right++]);
					} else {
						break;
					}

				}

				String[] newString = new String[2];
				newString[0] = sb.toString();
				newString[1] = String.valueOf(right - left - 1);
				pq.add(newString);

			}
		}

		if (pq.size() == 0 && chars.length > 0)
			return String.valueOf(chars[0]);
		return pq.remove()[0];
	}

	public static void main(String[] arg) {

		// "tattar rattat"
		// "tattarrattat"
		System.out.println(longestPalindrome("bbb"));
	}
}
