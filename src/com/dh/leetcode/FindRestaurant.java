package com.dh.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * 
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists
 * 
 * 
 * @author Lenovo
 *
 */
public class FindRestaurant {

	public String[] findRestaurant(String[] list1, String[] list2) {

		List<String> list = new ArrayList<>();

		int sumKey = 0;
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < list1.length; i++) {
			map.put(list1[i], i);
		}
		for (int i = 0; i < list2.length; i++) {
			if (map.containsKey(list2[i])) {
				if (list.size() == 0) {
					list.add(list2[i]);
					sumKey = i + map.get(list2[i]);
				} else {
					if (sumKey > i + map.get(list2[i])) {
						list.clear();
						list.add(list2[i]);
						sumKey = i + map.get(list2[i]);
					} else if (sumKey == i + map.get(list2[i])) {
						list.add(list2[i]);
					}
				}
			}
		}

		String[] list3 = new String[list.size()];
		int cursor = 0;
		for (String str : list) {
			list3[cursor] = str;
			cursor++;
		}
		return list3;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
