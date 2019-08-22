package com.dh.leetcode;

/**
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积
 * 
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 * 
 * @author Lenovo
 * 
 *
 */
public class MaximumProduct {

	public int maximumProduct(int[] nums) {
		/**
		 * 首先对这个数组排序，从大到小
		 */
		quickSort(nums, 0, nums.length - 1);
		/**
		 * 判断最大的3个数是否为正整数
		 */
		if (nums[2] > 0) {
			return getMax(nums[0] * nums[1] * nums[2], nums[0] * nums[nums.length - 1] * nums[nums.length - 2]);
		} else {
			if (nums.length >= 5)
				if (nums[0] > 0 || nums[1] > 0) {
					return nums[0] * nums[nums.length - 1] * nums[nums.length - 2];
				} else {
					return nums[0] * nums[1] * nums[2];
				}

			else if (nums.length == 4)
				return getMax(nums[0] * nums[1] * nums[2], nums[3] * nums[1] * nums[2]);
			else
				return nums[0] * nums[1] * nums[2];
		}

	}

	public void quickSort(int[] nums, int start, int end) {
		if (start >= end)
			return;
		int partPoint = getPoint(nums, start, end);
		quickSort(nums, start, partPoint - 1);
		quickSort(nums, partPoint + 1, end);

	}

	/**
	 * 这样的，我们在这段数组里面，以最后一个数据作为分隔节点，使得前面的数据均小于这个节点，后面的数据均大于这个节点。 那么如何处理呢
	 * 
	 * @param nums
	 * @param srart
	 * @param end
	 * @return
	 */
	public int getPoint(int[] nums, int start, int end) {

		int partPoint = nums[end];

		int cursor = start;
		for (int i = start; i <= end; i++) {
			if (nums[i] > partPoint) {
				swap(nums, i, cursor);
				cursor++;
			}
		}
		swap(nums, end, cursor);
		return cursor;

	}

	/**
	 * 交换数据
	 * 
	 * @param a
	 * @param i
	 * @param j
	 */
	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public int getMax(int x, int y, int z) {
		int max = x;
		if (max < y)
			max = y;
		if (max < z)
			max = z;
		return max;
	}

	public int getMax(int x, int y) {
		int max = x;
		if (max < y)
			max = y;
		return max;
	}

	public static void main(String[] arg) {

		MaximumProduct maximumProduct = new MaximumProduct();
		int[] data = { 1, 2, 3, 4 };

		System.out.println(maximumProduct.maximumProduct(data));
	}
}
