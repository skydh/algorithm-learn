package com.dh.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c
 * + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 
 * 注意：
 * 
 * 答案中不可以包含重复的四元组。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class FourSum {

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Set<String> set = new HashSet<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++)
			for (int j = i + 1; j < nums.length - 2; j++) {
				int left = j + 1;
				int right = nums.length - 1;
				while (left < right) {
					if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
						String key = getKey(nums[i], nums[j], nums[left], nums[right]);
						if (!set.contains(key)) {
							List<Integer> intList = new ArrayList<>();
							intList.add(nums[i]);
							intList.add(nums[j]);
							intList.add(nums[left]);
							intList.add(nums[right]);
							list.add(intList);
							set.add(key);
						}
						left++;
					}
					else if (nums[i] + nums[j] + nums[left] + nums[right] - target > 0)
						right--;

					else if (nums[i] + nums[j] + nums[left] + nums[right] - target < 0)
						left++;
				}
			}

		
		return list;

	}

	public static String getKey(int i, int j, int k, int m) {
		StringBuilder sb = new StringBuilder();
		sb.append(i);
		sb.append(j);
		sb.append(k);
		sb.append(m);
		return sb.toString();

	}
	public static void main(String[] arg) {

		int[] data = { 1,0,-1,0,-2,2 };
		int target = 0;
		System.out.println(fourSum(data, target));
	}
}
