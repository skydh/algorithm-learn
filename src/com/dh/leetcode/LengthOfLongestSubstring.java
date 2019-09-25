package com.dh.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * #3
 * 
 * @author Lenovo
 *
 */
public class LengthOfLongestSubstring {

	public static int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;

		int count = 1;
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			int newCount = 1;
			Set<Character> set = new HashSet<>();
			set.add(chars[i]);
			for (int j = i + 1; j < chars.length; j++) {

				if (!set.contains(chars[j])) {
					set.add(chars[j]);
					newCount++;
				} else {
					if (newCount > count)
						count = newCount;

					break;
				}

			}
			if (newCount > count) {
				count = newCount;
			}

		}
		return count;

	}

	public static void main(String[] arg) {
		System.out.println(lengthOfLongestSubstring("jbpnbwwd"));

	}
}
