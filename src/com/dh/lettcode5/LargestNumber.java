package com.dh.lettcode5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * 
 * 示例 1:
 * 
 * 输入: [10,2] 输出: 210 示例 2:
 * 
 * 输入: [3,30,34,5,9] 输出: 9534330 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class LargestNumber {

	public String largestNumber(int[] nums) {

		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int data = nums[i];
			List<Integer> list = new ArrayList<>();
			while (data != 0) {
				list.add(0, data % 10);
				data = data / 10;

			}
			if (nums[i] == 0)
				list.add(0);
			map.put(nums[i], list);
		}
		List<Integer> result = new ArrayList<>();
		result.add(nums[0]);
		for (int i = 1; i < nums.length; i++) {

			List<Integer> list1 = map.get(nums[i]);
			boolean isSet = false;
			for (int j = 0; j < result.size(); j++) {
				if (doHelper(list1, map.get(result.get(j)))) {
					result.add(j, nums[i]);
					isSet = true;
					break;

				}

			}
			if (!isSet) {
				result.add(nums[i]);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i));

		}

		String res = sb.toString();
		if (res.startsWith("0"))
			return "0";
		return res;

	}

	public boolean doHelper(List<Integer> list3, List<Integer> list4) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		list1.addAll(list3);
		list1.addAll(list4);
		list2.addAll(list4);
		list2.addAll(list3);
		int cursor = 0;
		int size = list1.size();
		while (cursor < size) {
			if (list1.get(cursor) > list2.get(cursor)) {

				return true;
			} else if (list1.get(cursor) == list2.get(cursor)) {
				cursor++;
			} else {
				return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		LargestNumber ss = new LargestNumber();
		int[] data = { 121, 12 };
		System.out.println(ss.largestNumber(data));
	}
}
