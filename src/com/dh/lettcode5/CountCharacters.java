package com.dh.lettcode5;

import java.util.HashMap;

/**
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * 
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * 
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * 
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-
 * characters 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class CountCharacters {
	public int countCharacters(String[] words, String chars) {
		HashMap<Character, Integer> baseMap = new HashMap<>();
		HashMap<Character, Integer> currentMap = new HashMap<>();
		for (int i = 0; i < chars.length(); i++) {
			Integer temp = baseMap.get(chars.charAt(i));
			if (temp == null)
				temp = 0;
			baseMap.put(chars.charAt(i), temp + 1);

		}
		int result = 0;
		for (int i = 0; i < words.length; i++) {
			currentMap.putAll(baseMap);
			boolean isUse = true;
			for (int j = 0; j < words[i].length(); j++) {
				Integer temp = currentMap.get(words[i].charAt(j));
				if (temp == null || temp<=0) {
					isUse = false;
					break;
				} else {
					currentMap.put(words[i].charAt(j), temp-1);
				}
			}
			if(isUse)
				result=result+words[i].length();

		}

		return result;

	}

}
