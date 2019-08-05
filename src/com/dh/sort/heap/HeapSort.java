package com.dh.sort.heap;

/**
 * 这个下午开会时再写，中午要补觉
 * 
 * 堆排序就是先将数据堆化，然后，一个个取出数据
 * 
 * 如何堆化呢，从数组的一半那个位置，开始堆化，类似插入的过程
 * 
 * @author Lenovo
 *
 */
public class HeapSort {

	public void sort(int[] data) {
		int[] newData = new int[data.length + 1];
		for (int i = 0; i < data.length; i++) {
			newData[i + 1] = data[i];
		}
		/**
		 * 开始堆化
		 */
		for (int i = newData.length / 2; i > 0; i--) {
			heap(newData, i,0);
		}

		/**
		 * 排序，删除元素，然后把大的放后面
		 */
		for (int i = newData.length-1,j=1; i > 0; i--,j++) {
			swap(newData, 1, i);
			heap(newData, 1,j);
		}

		System.out.println("");
	}

	public void heap(int[] data, int index,int offset) {
		int length=data.length-offset;
		while (index <length ) {
			int left = 0;
			int right = 0;
			if (index * 2 < length)
				left = data[index * 2];
			if (index * 2 + 1 < length)
				right = data[index * 2 + 1];
			int max = left > right ? left : right;
			if (data[index] > max)
				break;
			if (max == data[index * 2]) {
				swap(data, index, index * 2);
				index = index * 2;
			} else {
				swap(data, index, index * 2 + 1);
				index = index * 2 + 1;
			}

		}

	}

	public void doSort(int[] data) {

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
}
