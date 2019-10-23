package com.dh.leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * 
 * @author Lenovo
 *
 */
public class Permute {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		doHelper(0, nums, list);
		return list;

	}

	public void doHelper(int cursor, int[] nums, List<List<Integer>> list) {
		if (cursor == nums.length) {
			List<Integer> newList = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				newList.add(nums[i]);
			}
			list.add(newList);
			return;
		}
		for (int i = cursor; i < nums.length; i++) {
			swap(nums, i, cursor);
			doHelper(cursor + 1, nums, list);
			swap(nums, cursor, i);

		}

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
