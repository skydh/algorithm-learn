package com.dh.lettcode5;

import java.util.HashMap;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 
 * 请找出在 t 中被添加的字母。
 * 
 * 
 * @author Lenovo
 *
 */
public class FindTheDifference {

	public char findTheDifference(String s, String t) {

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			Integer temp = map.get(s.charAt(i));
			if (temp == null)
				temp = 0;
			map.put(s.charAt(i), temp + 1);
		}
		for (int i = 0; i < t.length(); i++) {
			Integer temp = map.get(t.charAt(i));
			if (temp == null) {
				return t.charAt(i);
			}
			temp--;
			if (temp < 0)
				return t.charAt(i);

			map.put(t.charAt(i), temp);

		}
		return 0;
	}

	public static void main(String[] args) {

		FindTheDifference fd = new FindTheDifference();

		System.out.println(fd.findTheDifference("a", "aa"));
	}
}
