package com.dh.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给定一个机票的字符串二维数组 [from,
 * to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从JFK（肯尼迪国际机场）出发的先生，
 * 所以该行程必须从 JFK 出发。
 * 
 * 说明:
 * 
 * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"]
 * 相比就更小，排序更靠前 所有的机场都用三个大写字母表示（机场代码）。 假定所有机票至少存在一种合理的行程。 示例 1:
 * 
 * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]] 输出:
 * ["JFK", "MUC", "LHR", "SFO", "SJC"] 示例 2:
 * 
 * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"] 解释:
 * 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 * 
 * 来源：（LeetCode） 。
 * 
 * @author Lenovo 刷算法，我们要刷有意义的算法，不是玩脑筋急转弯，刷这些和业务强相关的算法，能大大增强技术的敏感度。
 *
 *
 *
 */
public class FindItinerary {

	/**
	 * 目的：遍历所有的数据，且必须从JFK开始 这个方法是找出最小的路劲而已。
	 * 
	 * @param tickets
	 * @return
	 */
	public List<String> findItinerary001(List<List<String>> tickets) {
		List<String> list = new ArrayList<>();
		list.add("JFK");
		StringBuilder tempKey = new StringBuilder();
		tempKey.append("JFK");
		StringBuilder minKey = new StringBuilder();
		while (true) {
			boolean isChange = false;
			int cursor = -1;
			for (int i = 0; i < tickets.size(); i++) {
				List<String> tempList = tickets.get(i);
				if (tempList.get(0).equals(tempKey.toString())) {
					if (minKey.length() == 0 || minKey.toString().compareTo(tempList.get(1)) > 0) {
						isChange = true;
						cursor = i;
						minKey.delete(0, minKey.length());
						minKey.append(tempList.get(1));
					}
				}
			}
			if (cursor >= 0)
				tickets.remove(cursor);
			if (!isChange)
				return list;
			list.add(minKey.toString());
			tempKey.delete(0, tempKey.length());
			tempKey.append(minKey.toString());
			minKey.delete(0, minKey.length());

		}
	}

	/**
	 * 上面的时间复杂度太高
	 * 
	 * @param tickets
	 * @return
	 */
	public List<String> findItinerary(List<List<String>> tickets) {
		Map<String, LinkedList<String>> graph = new HashMap<>();
		for (List<String> tempList : tickets) {
			List<String> list = graph.computeIfAbsent(tempList.get(0), k -> new LinkedList<>());

			list.add(tempList.get(1));
		}
		int length = tickets.size() + 1;
		graph.values().forEach(x -> x.sort(String::compareTo));
		List<String> list = new ArrayList<>();
		list.add("JFK");
		helper(graph, "JFK", list, length);
		return list;
	}

	/**
	 * 贪心算法，一定是可以走通的，条件已满足,每次走最小的路径，即可。走过的要删除。
	 * 
	 * @param graph
	 * @param key
	 */
	public boolean helper(Map<String, LinkedList<String>> graph, String key, List<String> list, int length) {
		LinkedList<String> listLink = graph.get(key);
		if (listLink == null)
			if (list.size() == length)
				return true;
			else
				return false;
		if (listLink.size() == 0)
			if (list.size() == length)
				return true;
			else
				return false;

		for (int i = 0; i < listLink.size(); i++) {
			String temp = listLink.remove();
			list.add(temp);
			if (helper(graph, temp, list, length))
				return true;
			list.remove(list.size() - 1);
			listLink.addLast(temp);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]

		FindItinerary findItinerary = new FindItinerary();
		List<String> list1 = new ArrayList<>();
		list1.add("JFK");
		list1.add("KUL");
		List<String> list2 = new ArrayList<>();
		list2.add("JFK");
		list2.add("NRT");
		List<String> list3 = new ArrayList<>();
		list3.add("NRT");
		list3.add("JFK");
		List<String> list4 = new ArrayList<>();
		list4.add("ATL");
		list4.add("JFK");
		List<String> list5 = new ArrayList<>();
		list5.add("ATL");
		list5.add("SFO");

		List<List<String>> tickets = new ArrayList<List<String>>();
		tickets.add(list1);
		tickets.add(list2);
		tickets.add(list3);
		// tickets.add(list4);
		// tickets.add(list5);
		List<String> litt = findItinerary.findItinerary(tickets);
		for (String str : litt)
			System.out.println(str);
	}

}
