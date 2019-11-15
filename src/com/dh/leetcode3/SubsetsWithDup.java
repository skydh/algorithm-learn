package com.dh.leetcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: [1,2,2] 输出: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class SubsetsWithDup {
	public static List<List<Integer>> subsetsWithDup(int[] nums) {

		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<>();

		List<Integer> tempData = new ArrayList<>();
		List<Integer> tempData1 = new ArrayList<>();
		for (int i = 0; i < nums.length; i++)
			tempData1.add(nums[i]);

		list.add(tempData);
		list.add(tempData1);
		Set<String> set = new HashSet<>();
		for (int i = 1; i < nums.length; i++) {
			combine(nums, i, list, set);
		}

		return list;

	}

	public static List<List<Integer>> combine(int[] nums, int k, List<List<Integer>> list, Set<String> set) {

		List<Integer> tempData = new ArrayList<>();
		doHelper(0, k, nums, list, tempData, 0, set);
		return list;
	}

	public static void doHelper(int cursor, int k, int[] nums, List<List<Integer>> list, List<Integer> tempData,
			int num, Set<String> set) {
		if (num == k) {
			String str = getKey(tempData);
			if (!set.contains(str)) {
				list.add(new ArrayList<>(tempData));
				set.add(str);
			}
		} else {
			for (int i = cursor; i <= nums.length - k + num; i++) {
				tempData.add(nums[i]);
				doHelper(i + 1, k, nums, list, tempData, num + 1, set);
				tempData.remove(tempData.size() - 1);
			}
		}

	}

	public static String getKey(List<Integer> tempData) {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tempData.size(); i++) {
			sb.append(tempData.get(i));
		}
		return sb.toString();
	}

	public static void main(String[] args) {

		int[] data = { 4, 1, 0 };
		System.out.println(subsetsWithDup(data));

	}
}
