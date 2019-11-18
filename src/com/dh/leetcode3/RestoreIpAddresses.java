package com.dh.leetcode3;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 
 * 示例:
 * 
 * 输入: "25525511135" 输出: ["255.255.11.135", "255.255.111.35"]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class RestoreIpAddresses {

	/**
	 * 分析题意，
	 * 
	 * @param s
	 * @return
	 */
	public static List<String> restoreIpAddresses(String s) {
		List<String> list = new ArrayList<>();
		char[] chars = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		doHelper(list, sb, chars, 0, 0);
		return list;

	}

	public static void doHelper(List<String> list, StringBuilder sb, char[] chars, int cursor, int nums) {
		int lastLength = chars.length - cursor;
		int lastNum = 3 - nums;
		if (nums == 3) {
			if (lastLength > 3)
				return;
			if ((lastLength > 0 && lastLength <= 2) || (lastLength == 3 && isSuit(chars, cursor))) {

				if (lastLength == 1 && chars[cursor] == '0') {
					return;
				}
				sb.append(appendChar(chars, cursor, lastLength - 1));
				list.add(sb.toString());
				sb.delete(sb.length() - lastLength, sb.length());
			}

			return;

		}

		for (int i = 0; i < 3; i++) {

			if (lastLength - i - 1 < lastNum || lastLength - i - 1 > 3 * lastNum) {
				continue;
			}
			if (i < 2) {

				if (i == 1 && chars[cursor + 1] == '0') {
					continue;
				}
				sb.append(appendChar(chars, cursor, i));
				sb.append('.');
				doHelper(list, sb, chars, cursor + i + 1, nums + 1);
				sb.delete(sb.length() - 2 - i, sb.length());
			} else {
				if (isSuit(chars, cursor)) {
					sb.append(appendChar(chars, cursor, i));
					sb.append('.');
					doHelper(list, sb, chars, cursor + i + 1, nums + 1);
					sb.delete(sb.length() - 2 - i, sb.length());
				}

			}

		}

	}

	public static boolean isSuit(char[] chars, int cursor) {
		if (chars[cursor] == '0')
			return false;
		return (chars[cursor] - '0') * 100 + (chars[cursor + 1] - '0') * 10 + chars[cursor + 2] - '0' <= 255 ? true
				: false;

	}

	public static String appendChar(char[] chars, int cursor, int i) {
		StringBuilder sb = new StringBuilder();
		for (int j = cursor; j <= cursor + i; j++) {
			sb.append(chars[j]);
		}
		return sb.toString();

	}

	public static void main(String[] args) {

		System.out.println(restoreIpAddresses("172162541"));

	}
}
