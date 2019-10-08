package com.dh.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组
 * 
 *
 * 
 * @author Lenovo
 *
 */
public class ThreeSum2 {

	/**
	 * 网上的思路，排序加双指针。
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		/**
		 * 冒泡排序，可以优化，选择快排，或者归并
		 */
		sort(nums, nums.length - 1);
		Set<String> set = new HashSet<>();

		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == 0) {
					String key = getKey(nums[i], nums[left], nums[right]);
					if (!set.contains(key)) {
						List<Integer> intList = new ArrayList<>();
						intList.add(nums[i]);
						intList.add(nums[left]);
						intList.add(nums[right]);
						list.add(intList);
						set.add(key);
					}
					right--;
				} else if (sum < 0)
					left++;

				else
					right--;

			}

		}

		return list;

	}

	public String getKey(int i, int j, int k) {
		StringBuilder sb = new StringBuilder();
		sb.append(i);
		sb.append(j);
		sb.append(k);
		return sb.toString();

	}

	public void sort(int[] a, int n) {

		sort(a, 0, n);
	}

	public void sort(int[] a, int start, int end) {

		/*
		 * 限定条件，拆分为不可拆分就停止，换句话来说也就是拆分到一个元素为止，然后向树一样不断向上排序。
		 */
		if (start >= end)
			return;
		int middle = (start + end) / 2;
		sort(a, start, middle);
		sort(a, middle + 1, end);

		// 对排序好的2个子数组排序
		doSort(a, start, end, middle);

	}

	/**
	 * 有序数组的排序
	 * 方法如下：申请一个等于2个数组大小和的数组空间。定义2个游标分别指向各个数组头结点，比较2个数组的头元素，谁小就把值加进去，然后游标向后移动，
	 * 终止条件为任意一个数组放完了，然后再加一个判断，把其余数组元素全部加进去即可
	 * 
	 * @param a
	 * @param start
	 * @param end
	 * @param middle
	 */
	public void doSort(int[] a, int start, int end, int middle) {

		int[] temp = new int[end - start + 1];
		int i = start;
		int j = middle + 1;
		int cursor = 0;
		while (i <= middle && j <= end) {
			if (a[i] <= a[j]) {
				temp[cursor] = a[i];
				i++;
			} else {
				temp[cursor] = a[j];
				j++;
			}
			cursor++;
		}

		while (i <= middle) {// 将左边剩余元素填充进temp中
			temp[cursor++] = a[i++];
		}
		while (j <= end) {// 将右序列剩余元素填充进temp中
			temp[cursor++] = a[j++];
		}
		for (int k = 0; k < temp.length; k++) {
			a[start] = temp[k];
			start++;

		}

	}

}