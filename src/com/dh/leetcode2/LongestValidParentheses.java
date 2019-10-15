package com.dh.leetcode2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 
 * 示例 1:
 * 
 * 输入: "(()" 输出: 2 解释: 最长有效括号子串为 "()" 示例 2:
 * 
 * 输入: ")()())" 输出: 4 解释: 最长有效括号子串为 "()()"
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class LongestValidParentheses {

	/**
	 * 方案1，暴力破解 方案2，dp
	 * 
	 * @param s
	 * @return
	 */
	public static int longestValidParentheses(String s) {
		if(s.equals(""))
			return 0;
		List<Integer> list = new ArrayList<>();
		char[] chars = s.toCharArray();
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ')') {
				if (stack.size() > 0) {
					list.add(i);
					list.add(stack.pop());
				}
			} else {
				stack.push(i);
			}
		}
		list.sort(null);
		int min = 0;
		int temp = 1;
		for (int i = 1; i < list.size(); i = i + 1) {

			if (list.get(i) - list.get(i - 1) == 1) {
				temp = temp + 1;
			} else {
				if (temp%2==0 && temp > min)
					min = temp;
				temp = 1;
			}

		}

		if (temp%2==0 && temp > min)
			min = temp;
		return min;

	}

	public static void main(String[] args) {
		System.out.println(longestValidParentheses("("));

	}
}
