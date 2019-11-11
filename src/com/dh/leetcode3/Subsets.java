package com.dh.leetcode3;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: nums = [1,2,3] 输出: [ [3],   [1],   [2],   [1,2,3],   [1,3],   [2,3],  
 * [1,2],   [] ]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class Subsets {

	public static List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> list = new ArrayList<>();

		List<Integer> tempData = new ArrayList<>();
		List<Integer> tempData1 = new ArrayList<>();
		for (int i = 0; i < nums.length; i++)
			tempData1.add(nums[i]);

		list.add(tempData);
		list.add(tempData1);
		for (int i = 1; i < nums.length; i++) {
			combine(nums, i, list);
		}

		return list;

	}

	public static List<List<Integer>> combine(int[] nums, int k, List<List<Integer>> list) {

		List<Integer> tempData = new ArrayList<>();
		doHelper(0, k, nums, list, tempData, 0);
		return list;
	}

	public static void doHelper(int cursor, int k, int[] nums, List<List<Integer>> list, List<Integer> tempData,
			int num) {
		if (num == k) {
			list.add(new ArrayList<>(tempData));
		} else {
			for (int i = cursor; i <= nums.length - k + num; i++) {
				tempData.add(nums[i]);
				doHelper(i + 1, k, nums, list, tempData, num + 1);
				tempData.remove(tempData.size() - 1);
			}
		}

	}

}
