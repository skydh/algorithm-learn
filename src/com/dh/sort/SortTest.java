package com.dh.sort;

import com.dh.sort.bubble.BubbleSort;
import com.dh.sort.insertion.InsertSort;
import com.dh.sort.merge.MergeSort;
import com.dh.sort.quick.QuickSort;

/**
 * 排序测试，排序都是从小到大排序
 * 
 * @author Lenovo
 *
 */
public class SortTest {

	public static void main(String[] args) {
		int[] a = { 1, 11, 3, 5, 8, 9, 223423, 44, 534, 6 };
		quick(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static void bubble(int[] a) {
		BubbleSort sort = new BubbleSort();
		sort.sort(a);
	}

	public static void insert(int[] a) {
		InsertSort sort = new InsertSort();
		sort.sort(a);
	}

	public static void merge(int[] a) {
		MergeSort sort = new MergeSort();
		sort.mergeSort(a, 0, a.length - 1);
	}

	public static void quick(int[] a) {
		QuickSort sort = new QuickSort();

		sort.quickSort(a, 0, a.length - 1);
	}
}
