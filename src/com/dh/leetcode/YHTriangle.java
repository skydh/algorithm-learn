package com.dh.leetcode;

import java.util.ArrayList;
import java.util.List;

public class YHTriangle {
	public List<List<Integer>> generate(int numRows) {

		List<List<Integer>> list = new ArrayList<>();
		if (numRows <= 0)
			return list;
		List<Integer> newList = new ArrayList<>();
		newList.add(1);
		list.add(newList);
		for (int i = 1; i < numRows; i++) {
			List<Integer> lastList = list.get(i - 1);
			List<Integer> temp = new ArrayList<>();
			temp.add(1);
			for (int j = 1; j < i; j++) {
				temp.add(lastList.get(j - 1) + lastList.get(j));

			}
			temp.add(1);
			list.add(temp);
		}

		return list;

	}
}
