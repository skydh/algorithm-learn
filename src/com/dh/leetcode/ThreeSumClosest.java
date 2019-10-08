package com.dh.leetcode;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和
 * 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class ThreeSumClosest {
	public static int threeSumClosest(int[] nums, int target) {

		/**
		 * 冒泡排序，可以优化，选择快排，或者归并
		 */
		Arrays.sort(nums);
		int closest = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == target)
					return sum;
				if (sum - target < 0)

					left++;
				if (sum - target > 0)
					right--;

				if (Math.abs(target - sum) < Math.abs(target - closest)) {
					closest = sum;
				}
			}
		}
		return closest;
	}

	public static void main(String[] arg) {

		int[] data = { 1, 1, 1, 0 };
		int target = -100;
		System.out.println(threeSumClosest(data, target));
	}

}
