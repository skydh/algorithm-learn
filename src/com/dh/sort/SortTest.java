package com.dh.sort;

import com.dh.sort.radix.RadixSort;

public class SortTest {

	public static void main(String[] args) {
		int[] a = { 1, 11, 3, 5, 8, 9, 223423, 44, 534, 6 };
		// Sort sort = new BubbleSort();

		Sort sort1 = new RadixSort();

		sort1.sort(a, a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

	}

}
