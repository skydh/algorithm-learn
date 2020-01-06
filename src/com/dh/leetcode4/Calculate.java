package com.dh.leetcode4;

import java.util.Stack;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 * 
 * 示例 1:
 * 
 * 输入: "1 + 1" 输出: 2 示例 2:
 * 
 * 输入: " 2-1 + 2 " 输出: 3 示例 3:
 * 
 * 输入: "(1+(4+5+2)-3)+(6+8)" 输出: 23 说明：
 * 
 * 你可以假设所给定的表达式都是有效的。 请不要使用内置的库函数 eval。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class Calculate {
	public int calculate(String s) {

		Stack<String> stack = new Stack<>();
		int cursor = 0;

		while (cursor < s.length()) {
			char temp = s.charAt(cursor);
			if (temp == '+' || temp == '-' || temp == '(') {

				stack.push(String.valueOf(temp));

				cursor++;

			} else if (temp == ')') {
				String temp1 = stack.pop();
				stack.pop();
				if (stack.size() > 0) {
					String temp3 = stack.pop();
					int temp2 = Integer.parseInt(stack.pop());
					int tempCount = Integer.parseInt(temp1);
					if (temp3.equals("+")) {
						stack.push(String.valueOf(temp2 + tempCount));
					} else {
						stack.push(String.valueOf(temp2 - tempCount));
					}

				} else {
					stack.push(temp1);
				}
				cursor++;

			} else if (temp == ' ') {
				cursor++;
			} else {
				int tempCount = temp - 48;
				cursor++;
				while (cursor < s.length() && s.charAt(cursor) > 47 && s.charAt(cursor) < 58) {
					tempCount = tempCount * 10 + (s.charAt(cursor) - 48);
					cursor++;
				}
				if (stack.size() == 0) {
					stack.push(String.valueOf(tempCount));
					continue;
				}
				String temp1 = stack.pop();
				if (temp1.equals("+")) {
					int temp2 = Integer.parseInt(stack.pop());
					stack.push(String.valueOf(temp2 + tempCount));
				} else if (temp1.equals("-")) {
					int temp2 = Integer.parseInt(stack.pop());
					stack.push(String.valueOf(temp2 - tempCount));
				} else {
					stack.push(temp1);
					stack.push(String.valueOf(tempCount));
				}
			}

		}
		return Integer.parseInt(stack.peek());

	}

	public static void main(String[] args) {

		Calculate calculate = new Calculate();

		System.out.println(calculate.calculate("1+(5+2)"));

	}
}
