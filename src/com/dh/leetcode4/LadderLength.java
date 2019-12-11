package com.dh.leetcode4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord
 * 的最短转换序列的长度。转换需遵循如下规则：
 * 
 * 每次转换只能改变一个字母。 转换过程中的中间单词必须是字典中的单词。 说明:
 * 
 * 如果不存在这样的转换序列，返回 0。 所有单词具有相同的长度。 所有单词只由小写字母组成。 字典中不存在重复的单词。 你可以假设 beginWord 和
 * endWord 是非空的，且二者不相同。 示例 1:
 * 
 * 输入: beginWord = "hit", endWord = "cog", wordList =
 * ["hot","dot","dog","lot","log","cog"]
 * 
 * 输出: 5
 * 
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。 示例 2:
 * 
 * 输入: beginWord = "hit" endWord = "cog" wordList =
 * ["hot","dot","dog","lot","log"]
 * 
 * 输出: 0
 * 
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class LadderLength {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (isMatch(beginWord, endWord)) {
			for (int i = 0; i < wordList.size(); i++)
				if (wordList.get(i).equals(endWord)) {
					return 2;
				}
		}
		Map<String, Integer> dic = new HashMap<>();

		for (int i = 0; i < wordList.size(); i++)
			dic.put(wordList.get(i), i);

		int min = Integer.MAX_VALUE;
		Set<String> contrain = new HashSet<>();
		List<String> route = new ArrayList<>();
		List<Map<String, Integer>> graph = createGraph(wordList);

		for (int i = 0; i < wordList.size(); i++) {
			if (isMatch(wordList.get(i), beginWord)) {

				route.add(wordList.get(i));
				contrain.contains(beginWord);
				contrain.add(wordList.get(i));
				int temp = doHelper(endWord, route, graph, contrain, dic, 2);
				if (min > temp)
					min = temp;
				route.clear();
				contrain.clear();
			}

		}

		if(min==Integer.MAX_VALUE)
			return 0;
		return min;

	}

	public int doHelper(String endWord, List<String> route, List<Map<String, Integer>> graph, Set<String> contrain,
			Map<String, Integer> dic, int cursor) {
		if (contrain.size() == graph.size())
			return 0;

		List<String> queue = new ArrayList<>();

		for (int i = 0; i < route.size(); i++) {
			String key = route.get(i);
			int newCursor = dic.get(key);
			Map<String, Integer> tempMap = graph.get(newCursor);

			for (Map.Entry<String, Integer> entry : tempMap.entrySet()) {
				String newKey = entry.getKey();

				if (newKey.equals(endWord)) {
					return cursor + 1;
				} else {
					if (!contrain.contains(newKey)) {
						queue.add(newKey);
						contrain.add(newKey);
					}
				}

			}

		}
		return doHelper(endWord, queue, graph, contrain, dic, cursor + 1);

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

		LadderLength fs = new LadderLength();
		List<String> list = new ArrayList<>();
		list.add("hot");
		list.add("dot");
		list.add("dog");
		list.add("lot");
		list.add("log");

		fs.ladderLength("hit", "cog", list);
		System.out.println((char) ('a' - 32));

	}

}
