package com.dh.leetcode4;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * 
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 
 * 例如，给定三角形：
 * 
 * [ [2], [3,4], [6,5,7], [4,1,8,3] ] 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 
 * 说明：
 * 
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class MinimumTotal {

	/**
	 * 贪心算法
	 * 
	 * @param triangle
	 * @return
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0)
			return 0;
		List<Integer> list = new ArrayList<>(triangle.get(0));
		List<Integer> newList = doHelper(triangle, list, 1);
		int min = newList.get(0);
		for (int i = 1; i < newList.size(); i++)

			if (min > newList.get(i))
				min = newList.get(i);

		return min;

	}

	public List<Integer> doHelper(List<List<Integer>> triangle, List<Integer> list, int cursor) {
		if (cursor >= triangle.size())
			return list;

		List<Integer> tempList = triangle.get(cursor);
		List<Integer> newList = new ArrayList<>();
		for (int i = 0; i < tempList.size(); i++) {
			int min = Integer.MAX_VALUE;
			if (i - 1 >= 0)
				min = Math.min(min, tempList.get(i) + list.get(i - 1));
			if (i < list.size())
				min = Math.min(min, tempList.get(i) + list.get(i));
			
			newList.add(min);
		}
		list = null;
		System.out.println(newList);
		return doHelper(triangle, newList, cursor + 1);

	}

}
