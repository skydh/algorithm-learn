package com.dh.lettcode5;

import java.util.HashSet;
import java.util.Stack;

/**
 * 给你一个由 '('、')' 和小写字母组成的字符串 s。
 * 
 * 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
 * 
 * 请返回任意一个合法字符串。
 * 
 * 有效「括号字符串」应当符合以下 任意一条 要求：
 * 
 * 空字符串或只包含小写字母的字符串 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」 可以被写作 (A) 的字符串，其中
 * A 是一个有效的「括号字符串」
 * 
 * 
 * 示例 1：
 * 
 * 输入：s = "lee(t(c)o)de)" 输出："lee(t(c)o)de" 解释："lee(t(co)de)" , "lee(t(c)ode)"
 * 也是一个可行答案。
 * 
 * @author Lenovo
 *
 */
public class MinRemoveToMakeValid {

	/**
	 * 2个规则， 1，左括弧和you括弧数目一致，其次，必须先左括弧，再右括弧， 若是右括弧多，直接删除，
	 * 
	 * @param s
	 * @return
	 */
	public String minRemoveToMakeValid(String s) {
		Stack<Integer> leftStack = new Stack<>();
		HashSet<Integer> deleteSet = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				leftStack.add(i);
			} else if (s.charAt(i) == ')') {
				if (leftStack.size() == 0)
					deleteSet.add(i);
				else
					leftStack.pop();
			}
		}
		for (int i = 0; i < leftStack.size(); i++) {
			deleteSet.add(leftStack.get(i));
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (!deleteSet.contains(i)) {
				sb.append(s.charAt(i));
			}
		}

		return sb.toString();

	}

}
