package com.dh.leetcode2;

/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,0] 输出: 3 示例 2:
 * 
 * 输入: [3,4,-1,1] 输出: 2 示例 3:
 * 
 * 输入: [7,8,9,11,12] 输出: 1 说明:
 * 
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class FirstMissingPositive {
	/**
	 * 基于bitmap 解决常量级空间(Integer.Max,手动滑稽)+O(n)的时间复杂度。
	 * 
	 * @param nums
	 * @return
	 */
	public static int firstMissingPositive(int[] nums) {
		int length = (nums.length >> 3) + 1;
		byte[] bytes = new byte[length];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				int cursor = nums[i] >> 3;
				if (cursor < length) {
					int newCursor = nums[i] % 8;
					newCursor = newCursor == 0 ? 8 : newCursor;
					cursor = newCursor == 8 ? cursor - 1 : cursor;
					bytes[cursor] = (byte) (bytes[cursor] | (1 << (newCursor - 1)));
				}
			}
		}
		for (int i = 0; i < bytes.length; i++) {
			byte temp = bytes[i];
			for (int j = 0; j < 8; j++) {
				if ((temp & (1 << j)) == 0) {

					return (i << 3) + j + 1;

				}

			}
		}
		return -1;
	}

	/**
	 * 基于bitmap 解决常量级空间+O(n)的时间复杂度。
	 * 
	 * @param nums
	 * @return
	 */
	public static int firstMissingPositive1(int[] nums) {
		boolean is1 = false;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				is1 = true;
				break;
			}
		}
		if (is1) {
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] <= 0) {
					nums[i] = 1;
				}
			}
			for (int i = 0; i < nums.length; i++) {
				if (Math.abs(nums[i]) - 1 < nums.length) {
					nums[Math.abs(nums[i]) - 1] = nums[Math.abs(nums[i]) - 1] < 0 ? nums[Math.abs(nums[i]) - 1]
							: -nums[Math.abs(nums[i]) - 1];
				}
			}
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] > 0) {
					return i + 1;
				}
			}
			return nums.length + 1;

		} else {
			return 1;
		}

	}

	public static void main(String[] args) {

		int[] data = { 0, 2, 2, 1, 1 };
		System.out.println(firstMissingPositive1(data));

	}
}
