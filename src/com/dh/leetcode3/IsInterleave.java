package com.dh.leetcode3;

/**
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * 
 * 示例 1:
 * 
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac" 输出: true 示例 2:
 * 
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc" 输出: false
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/interleaving-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class IsInterleave {

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;
		boolean[][] isGet = new boolean[s1.length()+1][s2.length()+1];

		return doHelper1(s1, s2, s3, 0, 0, 0, isGet);

		// return doHelper(s1, s2, s3, 0, 0, 0);
	}

	/**
	 * 直接回溯
	 * 
	 * @param s1
	 * @param s2
	 * @param s3
	 * @param cursor1
	 * @param cursor2
	 * @param cursor3
	 * @return
	 */
	public boolean doHelper(String s1, String s2, String s3, int cursor1, int cursor2, int cursor3) {
		if (cursor3 == s3.length())
			return true;

		if (cursor1 < s1.length() && s1.charAt(cursor1) == s3.charAt(cursor3))
			if (doHelper(s1, s2, s3, cursor1 + 1, cursor2, cursor3 + 1))
				return true;

		if (cursor2 < s2.length() && s2.charAt(cursor2) == s3.charAt(cursor3))
			if (doHelper(s1, s2, s3, cursor1, cursor2 + 1, cursor3 + 1))
				return true;

		return false;
	}

	/**
	 * 回溯+剪
	 * 
	 * @param s1
	 * @param s2
	 * @param s3
	 * @param cursor1
	 * @param cursor2
	 * @param cursor3
	 * @return
	 */
	public boolean doHelper1(String s1, String s2, String s3, int cursor1, int cursor2, int cursor3,
			boolean[][] isGet) {
		if (cursor3 == s3.length())
			return true;
		if (isGet[cursor1][cursor2])
			return false;
		isGet[cursor1][cursor2] = true;

		if (cursor1 < s1.length() && s1.charAt(cursor1) == s3.charAt(cursor3))
			if (doHelper1(s1, s2, s3, cursor1 + 1, cursor2, cursor3 + 1, isGet))
				return true;

		if (cursor2 < s2.length() && s2.charAt(cursor2) == s3.charAt(cursor3))
			if (doHelper1(s1, s2, s3, cursor1, cursor2 + 1, cursor3 + 1, isGet))
				return true;

		return false;
	}

}
