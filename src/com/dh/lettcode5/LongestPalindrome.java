package com.dh.lettcode5;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 
 * 注意: 假设字符串的长度不会超过 1010。
 * 
 * 示例 1:
 * 
 * 输入: "abccccdd"
 * 
 * 输出: 7
 * 
 * 解释: 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 
 * @author Lenovo
 *
 */
public class LongestPalindrome {
	public int longestPalindrome(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Integer temp = map.get(s.charAt(i));
			if (temp == null)
				temp = 0;
			map.put(s.charAt(i), temp + 1);

		}
		boolean isA = false;
		int sum = 0;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			int value = entry.getValue();
			if (value % 2 != 0) {
				isA = true;
				sum = sum + value - 1;
			} else
				sum = sum + value;

		}
		if (isA)
			sum++;
		return sum;

	}

}
