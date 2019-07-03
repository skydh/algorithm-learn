package com.dh.array;

public class TestArray {

	public static void main(String[] args) {
		merge();

	}

	public static void merge() {
		int[] m = { 1, 5, 11, 45, 902, 3456 };
		int[] n = { 1, 2, 51, 121, 425, 901, 3416 };
		ArrayMerge test = new ArrayMerge();
		int[] result = test.mergeArray(m, n);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}

}
