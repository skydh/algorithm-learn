package com.dh.leetcode4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindLadders {

	/**
	 * 我的思路，是先用这个wordList构造一个图
	 * 
	 * 
	 * 超时
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> result = new ArrayList<>();
		List<String> route = new ArrayList<>();
		Set<String> contrain = new HashSet<>();
		Set<String> newContrain = new HashSet<>();

		route.add(beginWord);
		contrain.add(beginWord);
		List<Map<String, Integer>> graph = createGraph(wordList);
		int[] newInt = { Integer.MAX_VALUE };
		for (int i = 0; i < wordList.size(); i++) {
			if (isMatch(wordList.get(i), beginWord)) {
				route.add(wordList.get(i));
				contrain.add(wordList.get(i));
				doHelper(result, route, endWord, i, wordList.get(i), graph, contrain, newInt, newContrain);
				route.remove(1);
				contrain.remove(wordList.get(i));
			}

		}

		return result;

	}

	public void doHelper(List<List<String>> result, List<String> route, String endWord, int i, String str,
			List<Map<String, Integer>> graph, Set<String> contrain, int[] limit, Set<String> newContrain) {
		if (route.size() > limit[0]) {
			return;
		}
		if (str.equals(endWord)) {

			String str1 = getString(route);
			if (newContrain.contains(str1)) {
				return;
			}
			
			if (route.size() < limit[0]) {
				result.clear();
				limit[0] = route.size();
				List<String> newList = new ArrayList<>(route);
				result.add(newList);
			} else if (route.size() == limit[0]) {
				List<String> newList = new ArrayList<>(route);
				result.add(newList);
				newContrain.add(str);
			}

			return;
		}

		Map<String, Integer> map = graph.get(i);
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (!contrain.contains(entry.getKey())) {
				route.add(entry.getKey());
				contrain.add(entry.getKey());
				doHelper(result, route, endWord, entry.getValue(), entry.getKey(), graph, contrain, limit, newContrain);
				route.remove(route.size() - 1);
				contrain.remove(entry.getKey());
			}

		}

	}

	public String getString(List<String> route) {

		StringBuilder sb = new StringBuilder();
		for (String str : route)
			sb.append(str);
		return sb.toString();
	}

	public List<Map<String, Integer>> createGraph(List<String> wordList) {
		List<Map<String, Integer>> list = new ArrayList<>();
		for (int i = 0; i < wordList.size(); i++) {
			Map<String, Integer> tempList = new HashMap<>();
			for (int j = 0; j < wordList.size(); j++)
				if (isMatch(wordList.get(i), wordList.get(j)))
					tempList.put(wordList.get(j), j);

			list.add(tempList);
		}
		return list;

	}

	public boolean isMatch(String s1, String s2) {
		int flag = 0;
		for (int i = 0; i < s1.length(); i++)
			if (s1.charAt(i) != s2.charAt(i)) {
				flag++;
				if (flag > 1)
					return false;
			}
		if (flag == 1)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {

		FindLadders fs = new FindLadders();
		List<String> list = new ArrayList<>();
		list.add("hot");
		list.add("dot");
		list.add("dog");
		list.add("lot");
		list.add("log");
		list.add("cog");

		fs.findLadders("hit", "cog", list);
		System.out.println((char) ('a' - 32));

	}

}
