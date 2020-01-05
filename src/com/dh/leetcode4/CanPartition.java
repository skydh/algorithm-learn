package com.dh.leetcode4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 
 * 注意:
 * 
 * 每个数组中的元素不会超过 100 数组的大小不会超过 200 示例 1:
 * 
 * 输入: [1, 5, 11, 5]
 * 
 * 输出: true
 * 
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class CanPartition {
	public boolean canPartition(int[] nums) {
		if (nums.length == 0)
			return true;
		if (nums.length == 1 && nums[0] != 0)
			return false;
		if (nums.length == 1 && nums[0] == 0)
			return true;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
		}
		int temp = sum / 2;
		if (temp * 2 != sum)
			return false;
		else {

			/**
			 * 转为为从数组中挑出一些值，使得和为temp了 每一个值只有选或者不选，2个情况。只要达到temp了，立即返回true.
			 */
			Arrays.sort(nums);
			List<Set<Integer>> listSet = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				listSet.add(new HashSet<>());
			}
			return isSuit(nums, 0, temp, 0, listSet);
		}
	}

	public boolean isSuit(int[] nums, int cursor, int target, int sum, List<Set<Integer>> listSet) {

		if (cursor == nums.length)
			return false;
		int newSum = sum + nums[cursor];
		if (newSum > target)
			return false;
		if (newSum == target)
			return true;
		Set<Integer> set = listSet.get(cursor);
		if (set.contains(newSum))
			return false;

		if (isSuit(nums, cursor + 1, target, newSum, listSet)) {
			return true;
		} else {
			set.add(newSum);
		}

		
		if (isSuit(nums, cursor + 1, target, sum, listSet)) {
			return true;
		} 

		return false;

	}

}
