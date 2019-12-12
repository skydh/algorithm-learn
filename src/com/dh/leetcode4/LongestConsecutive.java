package com.dh.leetcode4;

import java.util.HashSet;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 
 * 要求算法的时间复杂度为 O(n)。
 * 
 * 示例:
 * 
 * 输入: [100, 4, 200, 1, 3, 2] 输出: 4 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class LongestConsecutive {

	/**
	 * 说起来，本质上也是排序，将数据放到hashset里面，然后在一个个取，时间复杂度o(1),和基数排序很类似。但是优化了一下吧。
	 * 
	 * @param nums
	 * @return
	 */
	public int longestConsecutive(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int num : nums)
			set.add(num);
		int max = 0;
		for (int num : nums) {
			int tempMax = 0;
			if (set.remove(num)) {
				tempMax++;
				int tempNum = num;
				while (set.remove(--tempNum))
					tempMax++;
				while (set.remove(++num))
					tempMax++;
				max = Math.max(tempMax, max);
			}
		}
		return max;

	}

}
