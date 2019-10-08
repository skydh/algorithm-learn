package com.dh.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组
 * 
 *
 * 
 * @author Lenovo
 *
 */
public class ThreeSum {
	/**
	 * 超时。。。
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Set<String> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++)
			for (int j = i + 1; j < nums.length; j++)
				for (int k = j + 1; k < nums.length; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {

						String key = getKey(nums[i], nums[j], nums[k]);
						if (!set.contains(key)) {
							List<Integer> intList = new ArrayList<>();
							intList.add(nums[i]);
							intList.add(nums[j]);
							intList.add(nums[k]);
							list.add(intList);
							set.add(key);
						}

					}
				}

		return list;

	}

	public String getKey(int i, int j, int k) {
		StringBuilder sb = new StringBuilder();
		/**
		 * 排序
		 */
		int temp;
		if (i < j) {
			temp = j;
			j = i;
			i = temp;
		}
		if (i < k) {
			temp = k;
			k = i;
			i = temp;
		}
		if (j < k) {
			temp = k;
			k = j;
			j = temp;
		}
		sb.append(i);
		sb.append(j);
		sb.append(k);
		return sb.toString();

	}

}