package com.dh.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"] 输出: "fl" 示例 2:
 * 
 * 输入: ["dog","racecar","car"] 输出: "" 解释: 输入不存在公共前缀。 说明:
 * 
 * 所有输入只包含小写字母 a-z 。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";

		char[] chars = strs[0].toCharArray();
		int right = chars.length - 1;
		for (int i = 1; i < strs.length; i++) {
			char[] temp = strs[i].toCharArray();
			if (right > temp.length - 1) {
				right = temp.length - 1;
				chars[temp.length] = ' ';
			}
			for (int j = 0; j < temp.length; j++) {
				if (j > right)
					break;
				if (chars[j] != temp[j]) {
					chars[j] = ' ';
					right = j;
					break;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {

			if (chars[i] == ' ')
				break;
			sb.append(chars[i]);

		}
		return sb.toString();

	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
