package com.dh.leetcode4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord
 * 的最短转换序列。转换需遵循如下规则：
 * 
 * 每次转换只能改变一个字母。 转换过程中的中间单词必须是字典中的单词。 说明:
 * 
 * 如果不存在这样的转换序列，返回一个空列表。 所有单词具有相同的长度。 所有单词只由小写字母组成。 字典中不存在重复的单词。 你可以假设 beginWord
 * 和 endWord 是非空的，且二者不相同。 示例 1:
 * 
 * 输入: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log","cog"]
 * 
 * 输出: [ ["hit","hot","dot","dog","cog"],   ["hit","hot","lot","log","cog"] ] 示例
 * 2:
 * 
 * 输入: beginWord = "hit" endWord = "cog" wordList =
 * ["hot","dot","dog","lot","log"]
 * 
 * 输出: []
 * 
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/word-ladder-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class FindLadders {

	/**
	 * 我的思路，是先用这个wordList构造一个图
	 * 
	 * 
	 * 深度优先 超时
	 * 
	 * 我们要广度优先
	 * 
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

		List<List<String>> result = new ArrayList<>();
		if (isMatch(beginWord, endWord)) {
			for (int i = 0; i < wordList.size(); i++)
				if (wordList.get(i).equals(endWord)) {
					List<String> list = new ArrayList<>();
					list.add(beginWord);
					list.add(endWord);
					result.add(list);
					return result;
				}
		}
		Map<String, Integer> dic = new HashMap<>();
		for (int i = 0; i < wordList.size(); i++)
			dic.put(wordList.get(i), i);
		List<Map<String, List<String>>> route = new ArrayList<>();
		Set<String> contrain = new HashSet<>();
		List<Map<String, Integer>> graph = createGraph(wordList);
		for (int i = 0; i < wordList.size(); i++) {
			if (isMatch(wordList.get(i), beginWord)) {
				Map<String, List<String>> map = new HashMap<>();
				List<String> list1 = new ArrayList<>();

				list1.add(beginWord);
				map.put(wordList.get(i), list1);
				route.add(map);
				contrain.contains(beginWord);
				contrain.add(wordList.get(i));
				doHelper(result, endWord, beginWord, route, graph, contrain, dic);
				route.clear();
				contrain.clear();
			}

		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < result.size(); i++) {
			if (min > result.get(i).size()) {
				min = result.get(i).size();
			}

		}

		List<List<String>> reaResult = new ArrayList<>();

		for (int i = 0; i < result.size(); i++) {
			if (result.get(i).size() == min) {
				reaResult.add(result.get(i));
			}

		}
		return reaResult;

	}

	public void doHelper(List<List<String>> result, String endWord, String beginWord,
			List<Map<String, List<String>>> route, List<Map<String, Integer>> graph, Set<String> contrain,
			Map<String, Integer> dic) {
		if (contrain.size() == graph.size())
			return;
		Map<String, List<String>> map = new HashMap<>();
		Map<String, List<String>> lastMap = route.get(route.size() - 1);
		boolean isSuit = false;
		List<String> temp = new ArrayList<>();
		for (Map.Entry<String, List<String>> entry : lastMap.entrySet()) {
			String key = entry.getKey();
			int cursor = dic.get(key);
			Map<String, Integer> tempMap = graph.get(cursor);
			for (Map.Entry<String, Integer> entry1 : tempMap.entrySet()) {
				String newKey = entry1.getKey();

				if (newKey.equals(endWord)) {
					isSuit = true;
					List<String> tempList = new ArrayList<>();
					tempList.add(endWord);
					tempList.add(0, key);
					help(route, result, tempList, key, route.size() - 1);
				} else {

					if (!isSuit && !contrain.contains(newKey)) {
						List<String> list001 = map.get(newKey);
						if (list001 == null)
							list001 = new ArrayList<>();

						list001.add(key);
						map.put(newKey, list001);

						temp.add(newKey);

					}
				}

			}

		}
		contrain.addAll(temp);
		if (isSuit) {
			return;
		} else {
			route.add(map);
			doHelper(result, endWord, beginWord, route, graph, contrain, dic);
		}

	}

	public void help(List<Map<String, List<String>>> route, List<List<String>> result, List<String> tempList,
			String key, int cursor) {
		if (cursor < 0) {
			List<String> list=new ArrayList<>(tempList);
			result.add(list);
			return;
		}

		Map<String, List<String>> map = route.get(cursor);
		List<String> list = map.get(key);
		for (int i = 0; i < list.size(); i++) {
			tempList.add(0, list.get(i));
			help(route, result, tempList, list.get(i), cursor - 1);
			tempList.remove(0);
		}

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
