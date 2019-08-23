package com.dh.leetcode;

/**
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * 
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 * 
 * 0 <= A.length <= 40000 0 <= A[i] < 40000
 * 
 * 
 * 输入：[1,2,2] 输出：1 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。 示例 2:
 * 
 * 输入：[3,2,1,2,1,7] 输出：6 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。 可以看出 5 次或 5
 * 次以下的 move 操作是不能让数组的每个值唯一的。
 *
 * 静下心来，分析，可知，重复数据，只能通过加一的方式来，那就很简单了，统计重复度，然后从空缺点来补充
 * 
 * @author Lenovo
 *
 */
public class MinIncrementForUnique {
	public int minIncrementForUnique(int[] A) {
		int[] temp = new int[100000];

		for (int x : A) {
			temp[x]++;
		}

		int num = 0;
		int move = 0;

		for (int i = 0; i < 100000; i++) {
			if (temp[i] > 1) {
				num = num + temp[i] - 1;
				move = move - i * (temp[i] - 1);
			} else if (num > 0 && temp[i] == 0) {
				num--;
				move = i + move;
			}
		}

		return move;

	}

	public static void main(String[] arg) {

		MinIncrementForUnique maximumProduct = new MinIncrementForUnique();

		int[] data = {};
		System.out.println(maximumProduct.minIncrementForUnique(data));
	}

}
