package com.dh.sort.quick;

import com.dh.sort.Sort;

/**
 * 快速排序：从数组中选举一个元素然后以其作为划分点，将数组划分为大约他的部分，和小于他的部分，然后再划分，在选举，直到都是一个个的元素即可
 * 平均时间复杂度是o(nlogn),最坏是o(n2).不稳定，原地排序
 * 
 * 
 * 
 * 个人觉得快速排序的难点在于分隔点的寻找。
 * 
 * @author Lenovo
 *
 */

public class QuickSort implements Sort {

	@Override
	public void sort(int[] a, int n) {
		sort(a, 0, n - 1);

	}

	public void sort(int[] a, int start, int end) {
		if (start >= end)
			return;
		int part = parttion(a, start, end);

		sort(a, start, part - 1);
		sort(a, part + 1, end);

	}

	/**
	 * 这个方法时原地排序的策略。我们将这个数组最后一个元素作为判断基点。然后将数组分为了大于他的部分，和小于他的部分
	 * 
	 * @param a
	 * @param start
	 * @param end
	 * @return
	 */
	public int parttion(int[] a, int start, int end) {
		/**
		 * 取最后一个元素作为节点
		 */
		int partpoint = a[end];
		/**
		 * 小于节点的数组游标
		 */
		int i = start;
		/**
		 * 遍历数组，当发现存在比节点小的数据，就交换游标节点数据，游标+1；
		 */
		for (int j = start; j < end; j++) {
			if (a[j] < partpoint) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
			}
		}

		/**
		 * 将节点元素和游标当前元素交换数据 因为这个操作，所以不稳定，元素一样也交换
		 */
		a[end] = a[i];
		a[i] = partpoint;

		return i;

	}

	/**
	 * 第二次写，快速排序 思想，和归并不一样，归并是不断中分，分成一个个元素后，在向上合并。
	 * 快排则是先根据一个元素作为节点来区分，一部分是大于这个节点的部分元素，一部分则是小于这个节点的部分元素。然后不断划分，知道都是一个个元素为止、
	 * 
	 * 这里我采用最后一个元素作为分割点。
	 * 
	 * 先
	 * 
	 * 
	 * @param a
	 * @param start
	 * @param end
	 */
	public void quickSort(int[] a, int start, int end) {
		if (start >= end) {
			return;
		}
		int index = getIndex(a, start, end);
		quickSort(a, start, index - 1);
		quickSort(a, index + 1, end);

	}

	/**
	 * 在这个区间，以最后一个元素作为分隔点，将元素划分为大于分割点的和小于分割点的。
	 * 
	 * @param a
	 * @param start
	 * @param end
	 * @return
	 */
	public int getIndex(int[] a, int start, int end) {
		int temp = a[end];

		// 设定一个游标，我们要让这个游标之前的元素一定小于temp值.
		int cursor = start;
		for (int i = start; i < end; i++) {
			if (a[i] < temp) {
				swap(a, cursor, i);
				cursor++;
			}

		}
		a[end] = a[cursor];
		a[cursor] = temp;
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

	/**
	 * 返回这个数组低k大的元素
	 * 
	 * @param a
	 * @param cursor
	 * @return
	 */
	public int getNumber(int[] a, int cursor, int start, int end) {

		int temp = getIndex(a, start, end);
		if (cursor < temp) {
			return getNumber(a, cursor, start, temp - 1);
		} else if (cursor == temp) {
			return a[temp];
		} else {
			return getNumber(a, cursor, temp + 1, end);
		}

	}
}
