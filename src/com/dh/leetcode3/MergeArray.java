package com.dh.leetcode3;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 
 * 说明:
 * 
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存
 * nums2 中的元素。 示例:
 * 
 * 输入: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3
 * 
 * 输出: [1,2,2,3,5,6]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class MergeArray {
	/**
	 * 还真是简单
	 * 
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {

		for (int i = m-1; i >=0; i--) {
			nums1[nums1.length - m + i] = nums1[i];
		}
		int cursor1 = nums1.length - m;
		int cursor2 = 0;
		int cursor = 0;
		while (cursor2 < nums2.length && cursor1 < nums1.length) {
			if (nums1[cursor1] >= nums2[cursor2]) {
				nums1[cursor] = nums2[cursor2];
				cursor2++;
			} else {
				nums1[cursor] = nums1[cursor1];
				cursor1++;
			}
			cursor++;
		}
		while (cursor2 < nums2.length) {
			nums1[cursor] = nums2[cursor2];
			cursor2++;
			cursor++;
		}
		while (cursor1 < nums1.length) {
			nums1[cursor] = nums1[cursor1];
			cursor1++;
			cursor++;
		}

	}
}
