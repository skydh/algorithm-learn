package com.dh.leetcode;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * 
 * '.' 匹配任意单个字符 '*' 匹配零个或多个前面的那一个元素 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * 
 * 说明:
 * 
 * s 可能为空，且只包含从 a-z 的小写字母。 p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class StringIsMatch {
	/**
	 * 从第一个开始比对 普通字符直接对比，不一样直接false. 如果是.,直接下一个字符。
	 * 如果是*,比对前一个元素，一样，s进去下一个字符，但是p可能继续保持，或者进入下一个字符。 条件终止是s走完，或者不匹配。
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatch(String s, String p) {
		char[] chars = s.toCharArray();
		char[] charp = p.toCharArray();
		if (s.equals("")) {
			if (p.equals(".")) {
				return true;
			} else {
				return false;
			}
		}
		if (p.equals("")) {
			if (p.equals("")) {
				return true;
			} else {
				return false;
			}
		}

		int i = 0, j = 0;
		return isMatch(chars, charp, i, j);
	}

	public static boolean isMatch(char[] chars, char[] charp, int i, int j) {

		while (i < chars.length) {
			if (charp[j] == '.') {

				if (j + 1 < charp.length) {
					j++;
					i++;
				} else {

					break;
				}
				continue;
			}
			if (charp[j] != '.' && charp[j] != '*') {
				if (j + 2 < charp.length && charp[j + 1] == '*') {

					if (isMatch(chars, charp, i, j + 2))
						return true;

				}
				if (chars[i] == charp[j]) {

					if (j + 1 < charp.length) {
						j++;
						i++;
					} else {

						break;
					}
					continue;
				} else {
					return false;
				}

			}
			if (charp[j] == '*') {
				if (j + 1 < charp.length) {
					if (isMatch(chars, charp, i, j + 1))
						return true;
				}
				if (j - 1 < 0) {
					return false;
				}
				if (chars[i] == chars[i - 1] || charp[i - 1] == '.') {
					if (isMatch(chars, charp, i + 1, j))
						return true;

					if (j + 1 < charp.length) {
						j++;
						i++;
					} else {

						break;
					}
				} else {
					return false;
				}

			}
		}

		System.out.println("i==" + i + "j==" + j);
		/**
		 * 这里要判断j 判断，最后一个字符，若是
		 * 
		 */
		if (i - 1 >= 0) {
			if (j == charp.length - 1 && chars[chars.length - 1] == charp[j] && i == chars.length - 1)
				return true;
		}

		if (j == charp.length - 1 && charp[j] == '*' && i == chars.length - 1)
			return true;
		if (j == charp.length - 2 && charp[j + 1] == '*' && i == chars.length - 1)
			return true;

		if (j == charp.length - 1 && i == chars.length - 1)
			return true;
		if (j + 1 < charp.length)
			if (j == charp.length - 2 && charp[j + 1] == '*' && i == chars.length - 1)
				return true;

		return false;
	}

	public static void main(String[] arg) {

		System.out.println(isMatch("aa", "a*c"));
	}

}
