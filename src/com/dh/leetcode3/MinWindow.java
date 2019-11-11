package com.dh.leetcode3;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * 
 * 示例：
 * 
 * 输入: S = "ADOBECODEBANC", T = "ABC" 输出: "BANC" 说明：
 * 
 * 如果 S 中不存这样的子串，则返回空字符串 ""。 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class MinWindow {

	/**
	 * 按照题解的思路解决，自己的思路，没有左裁剪。
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public static String minWindow(String s, String t) {
		if (s.equals("") || t.equals("")) {
			return "";
		}
		int[] newInt = new int[256];
		for (int i = 0; i < t.length(); i++)
			newInt[t.charAt(i)]++;
		int start = 0;
		int end = 0;
		int count = 0;
		int minInt = Integer.MAX_VALUE;
		int[] data = new int[2];
		boolean isManzu = false;
		while (end < s.length()) {
			newInt[s.charAt(end)]--;
			/**
			 * 表明是满足的字符。
			 */
			if (newInt[s.charAt(end)] >= 0)
				count++;
			/**
			 * 满足条件了，左移
			 */
			if (count == t.length()) {
				isManzu = true;
				while (start <= end) {
					if (++newInt[s.charAt(start)] > 0) {
						int sub = end - start;
						if (sub < minInt) {
							data[0] = start;
							data[1] = end;
							minInt = sub;
						}
						start++;
						break;
					}
					start++;
				}
				count--;
			}
			end++;
		}
		if (!isManzu)
			return "";
		StringBuilder sb = new StringBuilder();
		int newStart = data[0];
		int newEnd = data[1];
		while (newStart <= newEnd) {
			sb.append(s.charAt(newStart));
			newStart++;
		}
		return sb.toString();

	}

	public static void main(String[] args) {
		System.out.println(minWindow("ab", "b"));

	}

}
