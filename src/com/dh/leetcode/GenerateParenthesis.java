package com.dh.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class GenerateParenthesis {
	/**
	 * 我是这么构思的，首先回溯出所有的括号组合，在判断这些括号是否满足条件,。 1.第一个括号必须是（。
	 * 
	 * 
	 * @param n
	 * @return
	 */
	public static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<>();
		if (n == 0)
			return list;

		char[] chars = new char[n * 2];

		helper(chars, 0, 0, 0, list, n);
		return list;

	}

	public static void helper(char[] chars, int cursor, int left, int right, List<String> list, int n) {
		if (cursor >= chars.length) {
			String temp = new String(chars);
			if (isValid(temp))
				list.add(temp);
			return;
		}

		if (left < n) {
			chars[cursor] = '(';
			helper(chars, ++cursor, ++left, right, list, n);
			cursor--;
			left--;
		}
		if (right < left) {
			chars[cursor] = ')';
			helper(chars, ++cursor, left, ++right, list, n);

		}
	}

	public static boolean isValid(String s) {

		Stack<Character> stack = new Stack<>();
		char[] chars = s.toCharArray();
		if (chars.length % 2 != 0)
			return false;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
				stack.add(chars[i]);
			} else {
				if (stack.size() <= 0)
					return false;
				char temp = stack.pop();
				if (chars[i] == ')') {
					if (temp != '(')
						return false;
				} else if (chars[i] == '}') {
					if (temp != '{')
						return false;
				} else if (chars[i] == ']') {
					if (temp != '[')
						return false;
				}
			}

		}
		if (stack.size() > 0)
			return false;

		return true;

	}

	public static void main(String[] arg) {

		System.out.println(generateParenthesis(3));
	}

}
