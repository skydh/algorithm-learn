package com.dh.divideconquer;

/**
 * 采用分而治之的算法，求取逆序度
 * 
 * 2个有序数组之间的逆序度 =A数组的逆序度+B数组的逆序度+2数组之间的逆序度 2数组之间的逆序度，可以采用先将其排序合并，然后统计逆序度
 * 
 * 
 * @author Lenovo
 *
 */
public class ReverseOrder {

	public int countOrder;

	public int ReverseNum(int[] data) {
		countOrder = 0;
		doHelper(0, data.length - 1, data);
		return countOrder;
	}

	public void doHelper(int start, int end, int[] data) {
		if (start >= end)
			return;
		int mid = (start + end) / 2;
		doHelper(start, mid, data);
		doHelper(mid + 1, end, data);
		merge(start, end, mid, data);
	}

	/**
	 * 这里是核心，我们来计算逆序度的 从一个元素开始合并，在合并时，我们计算逆序度。
	 * 
	 * @param start
	 * @param end
	 * @param mid
	 * @param data
	 */
	public void merge(int start, int end, int mid, int[] data) {
		int[] newData = new int[end - start + 1];
		int i = start;
		int j = mid + 1;
		int cursor = 0;
		while (i <= mid && j <= end) {
			if (data[i] <= data[j]) {
				newData[cursor] = data[i];
				i++;
			} else {
				newData[cursor] = data[j];
				countOrder = countOrder + (mid - i + 1);
				j++;
			}
			cursor++;
		}

		for (; i <= mid; i++, cursor++) {
			newData[cursor] = data[i];
		}

		for (; j <= end; j++, cursor++) {
			newData[cursor] = data[j];
		}
		for (int k = 0, h = start; k < newData.length; k++, h++) {
			data[h] = newData[k];
		}

	}

}
