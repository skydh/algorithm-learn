package com.dh.lettcode5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。
 * 如果可以，请返回 True；否则，返回 False。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入：nums = [1,2,3,3,4,4,5,6], k = 4 输出：true 解释：数组可以分成 [1,2,3,4] 和 [3,4,5,6]。
 * 示例 2：
 * 
 * 输入：nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3 输出：true 解释：数组可以分成 [1,2,3] ,
 * [2,3,4] , [3,4,5] 和 [9,10,11]。 示例 3：
 * 
 * 输入：nums = [3,3,2,2,1,1], k = 3 输出：true 示例 4：
 * 
 * 输入：nums = [1,2,3,4], k = 3 输出：false 解释：数组不能分成几个大小为 3 的子数组。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-
 * numbers 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class IsPossibleDivide {

	public boolean isPossibleDivide(int[] nums, int k) {

		if (k == 0 || nums.length % k != 0)
			return false;
		Arrays.sort(nums);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
			map.put(nums[i], map.get(nums[i]) == null ? 1 : map.get(nums[i]) + 1);
		int cursor = 0;
		while (cursor < nums.length && map.size() > 0) {
			Integer temp = map.get(nums[cursor]) == null ? -1 : map.get(nums[cursor]) - 1;
			if (temp < 0) {
				cursor++;
				continue;
			} else if (temp == 0)
				map.remove(nums[cursor]);
			else
				map.put(nums[cursor], temp);

			int i = 1;
			while (i < k) {
				Integer sum = map.get(nums[cursor] + i) == null ? -1 : map.get(nums[cursor] + i) - 1;
				if (sum < 0)
					return false;
				else if (sum == 0)
					map.remove(nums[cursor] + i);
				else
					map.put(nums[cursor] + i, sum);
				i++;

			}
			cursor++;
		}

		return true;

	}

	public static void main(String[] args) {

		IsPossibleDivide isPossibleDivide = new IsPossibleDivide();
		int[] data = { 1, 2, 3, 3, 4, 4, 5, 6 };
		System.out.println(isPossibleDivide.isPossibleDivide(data, 4));
	}
}
