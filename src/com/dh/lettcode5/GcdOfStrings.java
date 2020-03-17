package com.dh.lettcode5;

import java.util.HashSet;

/**
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 * 
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/greatest-common-divisor-of-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class GcdOfStrings {
	public String gcdOfStrings(String str1, String str2) {
		HashSet<String> set1 = new HashSet<>();
		HashSet<String> set2 = new HashSet<>();
		for (int i = 1; i <= str1.length() / 2 + 1; i++) {
			if (str1.length() % i == 0) {
				if (isSuit(str1, str1.substring(0, i))) {
					set1.add(str1.substring(0, i));
				}
				if (isSuit(str1, str1.substring(0, str1.length() / i))) {
					set1.add(str1.substring(0, str1.length() / i));
				}
			}

		}

		for (int i = 1; i <= str2.length() / 2 + 1; i++) {
			if (str2.length() % i == 0) {
				if (isSuit(str2, str2.substring(0, i))) {
					set2.add(str2.substring(0, i));
				}
				if (isSuit(str2, str2.substring(0, str2.length() / i))) {
					set2.add(str2.substring(0, str2.length() / i));
				}
			}

		}
		set1.retainAll(set2);
		String result = "";
		for (String str : set1) {
			if (str.length() > result.length())
				result = str;

		}

		return result;

	}

	public boolean isSuit(String str1, String str2) {
		for (int i = 0; i < str1.length() ;) {
			for (int j = 0; j < str2.length(); j++) {

				if (str2.charAt(j) != str1.charAt(i))
					return false;
				i++;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		GcdOfStrings s = new GcdOfStrings();
		System.out.println(s.gcdOfStrings("abcdef", "abc"));
	}
}
