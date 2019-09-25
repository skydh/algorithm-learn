package com.dh.leetcode;

/**
 * #4
 * 
 * @author Lenovo
 *
 */
public class FindMedianSortedArrays {
	/**
	 * 时间复杂度是m+n,log的话，太巧妙，算了
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		/**
		 * 合并
		 */
		int[] newData = new int[nums1.length + nums2.length];
		int cursor = 0, cursor1 = 0, cursor2 = 0;

		while (cursor1 < nums1.length && cursor2 < nums2.length) {
			if (nums1[cursor1] < nums2[cursor2])

				newData[cursor] = nums1[cursor1++];
			else
				newData[cursor] = nums2[cursor2++];

			cursor++;
		}
		while (cursor1 < nums1.length)

			newData[cursor++] = nums1[cursor1++];
		while (cursor2 < nums2.length)

			newData[cursor++] = nums2[cursor2++];
		if (newData.length == 1)
			return newData[0];

		if (newData.length % 2 == 0)
			return (double) (newData[newData.length / 2] + newData[newData.length / 2 -1]) / 2;
		else
			return (double) newData[newData.length / 2 ];

	}

	public static void main(String[] arg) {
		int[] data1 = { 1, 3 };
		int[] data2 = { 2 };
		System.out.println(findMedianSortedArrays(data1, data2));

	}
}
