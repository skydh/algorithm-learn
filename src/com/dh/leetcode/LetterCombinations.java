package com.dh.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入："23" 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class LetterCombinations {
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if (digits.equals(""))
			return result;
		Map<Character, List<Character>> map = new HashMap<>();
		List<Character> list2 = new ArrayList<>();
		list2.add('a');
		list2.add('b');
		list2.add('c');
		map.put('2', list2);
		List<Character> list3 = new ArrayList<>();
		list3.add('d');
		list3.add('e');
		list3.add('f');
		map.put('3', list3);
		List<Character> list4 = new ArrayList<>();
		list4.add('g');
		list4.add('h');
		list4.add('i');
		map.put('4', list4);
		List<Character> list5 = new ArrayList<>();
		list5.add('j');
		list5.add('k');
		list5.add('l');
		map.put('5', list5);
		List<Character> list6 = new ArrayList<>();
		list6.add('m');
		list6.add('n');
		list6.add('o');
		map.put('6', list6);
		List<Character> list7 = new ArrayList<>();
		list7.add('p');
		list7.add('q');
		list7.add('r');
		list7.add('s');
		map.put('7', list7);
		List<Character> list8 = new ArrayList<>();
		list8.add('t');
		list8.add('u');
		list8.add('v');
		map.put('8', list8);
		List<Character> list9 = new ArrayList<>();
		list9.add('w');
		list9.add('x');
		list9.add('y');
		list9.add('z');
		map.put('9', list9);

		StringBuilder sb = new StringBuilder();

		char[] chars = digits.toCharArray();
		helper(chars, 0, result, sb, map);

		return result;

	}

	public void helper(char[] chars, int cursor, List<String> result, StringBuilder sb,
			Map<Character, List<Character>> map) {

		if (cursor == chars.length) {
			result.add(sb.toString());
			return;
		}
		List<Character> list = map.get(chars[cursor]);
		for (Character temp : list) {
			sb.append(temp);
			helper(chars, cursor + 1, result, sb, map);
			sb.deleteCharAt(cursor);

		}

	}
}
