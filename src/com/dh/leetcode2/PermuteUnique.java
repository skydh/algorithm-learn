package com.dh.leetcode2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 唯一全排列
 * 
 * @author Lenovo
 *
 */
public class PermuteUnique {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Set<String> set = new HashSet<>();
		doHelper(0, nums, list, set);
		return list;
	}

	public void doHelper(int cursor, int[] nums, List<List<Integer>> list, Set<String> set) {
		if (cursor == nums.length) {
			String key = getKey(nums);
			if (!set.contains(key)) {
				List<Integer> newList = new ArrayList<>();
				for (int i = 0; i < nums.length; i++) {
					newList.add(nums[i]);
				}
				list.add(newList);
				set.add(key);
			}
			return;
		}
		for (int i = cursor; i < nums.length; i++) {
			swap(nums, i, cursor);
			doHelper(cursor + 1, nums, list, set);
			swap(nums, cursor, i);

		}

	}

	public String getKey(int[] nums) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			sb.append(nums[i]);
		}
		return sb.toString();
	}

	/**
	 * 交换
	 * 
	 * @param data
	 * @param i
	 * @param j
	 */
	public static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

}
