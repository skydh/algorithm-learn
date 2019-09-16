package com.dh.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 * 
 * 返回重复了 N 次的那个元素。
 * 
 * @author Lenovo
 *
 */
public class RepeatedNTimes {
	public int repeatedNTimes(int[] A) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < A.length; i++) {
			if (!set.add(A[i]))
				return A[i];
		}
		return -1;

	}

}
