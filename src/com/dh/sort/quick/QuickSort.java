package com.dh.sort.quick;

import com.dh.sort.Sort;

/**
 * 快速排序：从数组中选举一个元素然后以其作为划分点，将数组划分为大约他的部分，和小于他的部分，然后再划分，在选举，直到都是一个个的元素即可
 * 平均时间复杂度是o(nlogn),最坏是o(n2).不稳定，原地排序
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

}
