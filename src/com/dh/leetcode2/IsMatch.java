package com.dh.leetcode2;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * 
 * '?' 可以匹配任何单个字符。 '*' 可以匹配任意字符串（包括空字符串）。 两个字符串完全匹配才算匹配成功。
 * 
 * 说明:
 * 
 * s 可能为空，且只包含从 a-z 的小写字母。 p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。 示例 1:
 * 
 * 输入: s = "aa" p = "a" 输出: false 解释: "a" 无法匹配 "aa" 整个字符串。 示例 2:
 * 
 * 输入: s = "aa" p = "*" 输出: true 解释: '*' 可以匹配任意字符串。 示例 3:
 * 
 * 输入: s = "cb" p = "?a" 输出: false 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。 示例 4:
 * 
 * 输入: s = "adceb" p = "*a*b" 输出: true 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串
 * "dce". 示例 5:
 * 
 * 输入: s = "acdcb" p = "a*c?b" 输入: false
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class IsMatch {

	/**
	 * 我的思路很明确，跟着题意来。 普通字符和？直接匹配，遇到*，则是跳到下个字符去匹配，然后s串不断遍历直到找到合适的字符为止。
	 * 
	 * @return
	 */
	public static boolean isMatch(String s, String p) {
		if (p.equals("*"))
			return true;
		int sum = 0;
		char[] chars = s.toCharArray();
		char[] charp = p.toCharArray();
		boolean[][] isUse = new boolean[chars.length+1][chars.length+1];

		for (int i = 0; i < charp.length; i++)
			if (charp[i] == '*')
				sum++;

		return doHelper(0, 0, chars, charp, sum, isUse);

	}

	/**
	 * 
	 * 感觉递归不太好，修改为循环。
	 * 
	 * @param cursors
	 * @param cursorp
	 * @param chars
	 * @param charp
	 * @return
	 */
	public static boolean doHelper(int cursors, int cursorp, char[] chars, char[] charp, int sum, boolean[][] isUse) {
		if (isUse[cursors][cursors])
			return false;
		else
			isUse[cursors][cursors] = true;

		while (cursors < chars.length && cursorp < charp.length) {
			if (charp[cursorp] == chars[cursors] || charp[cursorp] == '?') {
				cursors++;
				cursorp++;
			} else if (charp[cursorp] == '*') {
				sum = sum - 1;
				while (cursorp < charp.length) {
					if (charp[cursorp] == '*')
						cursorp++;
					else
						break;
				}
				if (cursorp == charp.length)
					return true;
				while (cursors < chars.length) {
					if (charp[cursorp] == chars[cursors] || charp[cursorp] == '?') {
						if (cursors == chars.length - 1 && cursorp == charp.length - 1)
							return true;
						if (doHelper(cursors + 1, cursorp + 1, chars, charp, sum, isUse))
							return true;
					}
					if ((chars.length - cursors) < (charp.length - cursorp - sum))
						return false;
					cursors++;
				}
			} else {
				return false;
			}
		}
		while (cursorp < charp.length) {
			if (charp[cursorp] == '*') {
				cursorp++;
			} else {
				break;
			}
		}
		if (cursors == chars.length && cursorp == charp.length)
			return true;

		return false;
	}

	public static void main(String[] args) {

		Long l1 = System.currentTimeMillis();
		System.out.println(
				isMatch("bbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
						"*aa*ba*a*bb**aa*ab*a*aaaaaa*a*aaaa*bbabb*b*b**aaaaaaaaa*a*ba*bbb***a*ba*bb*bb**a*b*bb"));

		System.out.println(System.currentTimeMillis() - l1);
	}

}
