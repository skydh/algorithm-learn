package com.dh.leetcode2;

/**
 * 定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 示例:
 * 
 * 输入: [-2,1,-3,4,-1,2,1,-5,4], 输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 进阶:
 * 
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class MaxSubArray {

	/**
	 * 2个变量，一个是最大值，一个是当前子序列和，搞清楚逻辑，这种题目就很明确了。
	 * 
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > max)
				max = nums[i];
		}

		int sum = nums[0];

		for (int i = 1; i < nums.length; i++) {
			if (sum > max)
				max = sum;
			if (sum < 0)
				sum = nums[i];
			else
				sum = sum + nums[i];

			/**
			 * 原本是根据当前是否大于小于0来判断，但是写着写着，发现，里面逻辑一样，于是缩减了，但是缩减了就不好理解了，为了以后方便理解，
			 * 这里阐述下，
			 */

			// if (nums[i] < 0) {
			//
			// if (sum <= 0) {
			// /**
			// * 当前值小于0，没有增益，其当前序列也小于0，加上去无疑更加小了，于是，直接让当前值作为当前序列值。重新开始
			// */
			// sum = nums[i];
			// } else {
			// /**
			// * 当前序列值大于0，前面已经比较过了，把可能的最大值放到max里面去了，虽然当前值小于0，但是可能加上他，
			// * 再加后面的值，使得当前值更加大，所以加。
			// */
			// sum = sum + nums[i];
			// }
			// } else {
			//
			// if (sum <= 0) {
			// /**
			// * 当前值大于0，当前序列小于0，因此最大的当前序列值，就是当前值！
			// */
			// sum = nums[i];
			// } else {
			// /**
			// * 这个很好理解，不解释！
			// */
			// sum = sum + nums[i];
			// }
			// }

		}
		if (sum > max)
			max = sum;
		return max;

	}

}
