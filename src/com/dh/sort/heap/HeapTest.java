package com.dh.sort.heap;

public class HeapTest {

	public static void main(String[] args) {

		// MergeArrayHeap merge = new MergeArrayHeap();
		// int[][] data = { { 21, 17, 11, 6, 1 }, { 22, 18, 12, 7, 2 }, { 23,
		// 19, 13, 8, 3 }, { 10, 9, 5, 4 } };
		// List<Integer> list = merge.merge(data);
		// for (int i : list) {
		// System.out.println(i);
		// }
		// System.out.println();

		TopKDynamic topk = new TopKDynamic(4);
		topk.add(1);
		topk.add(2);
		topk.add(3);
		topk.add(4);

		topk.add(5);
		topk.add(51);
		topk.add(52);
		topk.add(533);
		topk.add(53);
		int[] temp = topk.getTopK();
		for (int i : temp) {
			System.out.println(i);
		}

	}

}
