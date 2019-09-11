package com.dh.leetcode;

/**
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数
 * 
 * @author Lenovo
 *
 */
public class SingleNonDuplicate {
	public int singleNonDuplicate(int[] nums) {
		if (nums == null)
			return 0;
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		int cursor1 = 0;
		int cursor2 = 1;
		for (; cursor1 < nums.length && cursor2 < nums.length; cursor1 = cursor1 + 2, cursor2 = cursor2 + 2) {
			if (nums[cursor1] != nums[cursor2])
				break;
		}
		return nums[cursor1];
	}

}
