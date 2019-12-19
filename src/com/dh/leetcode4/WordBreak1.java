package com.dh.leetcode4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreak1 {

	public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> result = new ArrayList<>();
		HashMap<Character, List<String>> map = new HashMap<>();
		HashMap<String, Integer> map1 = new HashMap<>();
		int cursor = 0;
		for (String str : wordDict) {
			map1.put(str, cursor);
			List<String> list = map.get(str.charAt(0));
			if (list != null)
				list.add(str);
			else {
				list = new ArrayList<>();
				list.add(str);
				map.put(str.charAt(0), list);
			}
			cursor++;
		}
		boolean[][] isSuit = new boolean[s.length()][wordDict.size()];
	
		List<String> temp = new ArrayList<>();
		doHelper(result, temp, map, s, 0, map1, isSuit);

		return result;

	}

	public boolean doHelper(List<String> result, List<String> temp, HashMap<Character, List<String>> map, String s,
			int cursor, HashMap<String, Integer> map1, boolean[][] isSuit) {
		if (cursor >= s.length()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < temp.size(); i++) {
				sb.append(temp.get(i));
				if (i != temp.size() - 1)
					sb.append(" ");
			}
			result.add(sb.toString());
			return true;
		}

		boolean isRight = false;
		List<String> list = map.get(s.charAt(cursor));
		if (list == null)
			return false;
		for (String str : list) {
			if (str.length() > s.length() - cursor)
				continue;
			if (isSuit[cursor][map1.get(str)])
				continue;
			if (str.equals(s.substring(cursor, cursor + str.length()))) {
				temp.add(str);
				boolean isOk = doHelper(result, temp, map, s, cursor + str.length(), map1, isSuit);
				if (!isOk)
					isSuit[cursor][map1.get(str)] = true;
				else
					isRight = true;
				temp.remove(temp.size() - 1);
			}

		}

		return isRight;

	}

	public static void main(String[] args) {

		WordBreak1 wb = new WordBreak1();
		List<String> list = new ArrayList<>();
		list.add("apple");
		list.add("pen");
		list.add("applepen");
		list.add("pine");
		list.add("pineapple");
		String a = "pineapplepenapple";
		System.out.println(wb.wordBreak(a, list));

	}

}
