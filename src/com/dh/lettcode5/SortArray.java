package com.dh.lettcode5;

/***
 * 给你一个整数数组 nums，请你将该数组升序排列。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入：nums = [5,2,3,1] 输出：[1,2,3,5] 示例 2：
 * 
 * 输入：nums = [5,1,1,2,0,0] 输出：[0,0,1,1,2,5]  
 * 
 * 提示：
 * 
 * 1 <= nums.length <= 50000 -50000 <= nums[i] <= 50000
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sort-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class SortArray {
	public int[] sortArray(int[] nums) {
		// mergeSort(nums, 0, nums.length - 1);
		quickSort(nums, 0, nums.length - 1);
		return nums;

	}

	/**
	 * 归并排序
	 */
	public void mergeSort(int[] nums, int start, int end) {
		int mid = (start + end) / 2;
		if (mid > start) {
			mergeSort(nums, start, mid);
		}
		if (end > mid + 1) {
			mergeSort(nums, mid + 1, end);
		}

		merge(nums, start, mid, end);
	}

	public void merge(int[] nums, int start, int mid, int end) {
		int[] temp = new int[end - start + 1];
		int cursor1 = start;
		int cursor2 = mid + 1;
		int cursor = 0;
		while (cursor1 <= mid && cursor2 <= end) {
			if (nums[cursor1] < nums[cursor2]) {
				temp[cursor] = nums[cursor1];
				cursor1++;
			} else {
				temp[cursor] = nums[cursor2];
				cursor2++;
			}
			cursor++;
		}
		while (cursor1 <= mid) {
			temp[cursor] = nums[cursor1];
			cursor1++;
			cursor++;
		}
		while (cursor2 <= end) {
			temp[cursor] = nums[cursor2];
			cursor2++;
			cursor++;
		}
		cursor1 = start;
		cursor = 0;
		while (cursor1 <= end) {
			nums[cursor1] = temp[cursor];
			cursor1++;
			cursor++;
		}

	}

	/***
	 * 快速排序
	 */
	public void quickSort(int[] nums, int start, int end) {
		int part = quick(nums, start, end);
		if (part - 1 > start) {
			quickSort(nums, start, part-1);
		}
		if (end > part + 1) {
			quickSort(nums, part+1, end);
		}
	}

	/**
	 * 选中最后一个节点为分隔节点。
	 * 
	 * @param nums
	 * @param start
	 * @param end
	 * @return
	 */
	public int quick(int[] nums, int start, int end) {
		int part = nums[end];
		int cursor = start;
		for (int i = start; i < end; i++) {
			if (nums[i] <= part) {
				int temp = nums[i];
				nums[i] = nums[cursor];
				nums[cursor] = temp;
				cursor++;

			}

		}

		nums[end] = nums[cursor];
		nums[cursor] = part;
		return cursor;

	}

}
