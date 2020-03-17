package com.dh.lettcode5;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 
 * 示例:
 * 
 * 输入: [10,9,2,5,3,7,101,18] 输出: 4 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 说明:
 * 
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 你算法的时间复杂度应该为 O(n2) 。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class LengthOfLIS {
	/**
	 * dp算法
	 * 
	 * @param nums
	 * @return
	 */
	public int lengthOfLIS(int[] nums) {

		if(nums.length==0)
			return 0;
		int[] dp = new int[nums.length];
		dp[nums.length - 1] = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			int cursor = i + 1;
			while (cursor <= nums.length - 1) {
				if (nums[i] < nums[cursor] && dp[i] < dp[cursor] + 1) {
					dp[i] = dp[cursor] + 1;

				}
				cursor++;
			}
			if (dp[i] == 0)
				dp[i] = 1;

		}
		int max = dp[0];
		for (int i = 1; i < dp.length; i++)
			max = Math.max(max, dp[i]);
		return max;

	}

	public static void main(String[] args) {
		LengthOfLIS ls = new LengthOfLIS();
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(ls.lengthOfLIS(nums));
	}

}
