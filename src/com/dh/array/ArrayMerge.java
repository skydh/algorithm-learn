package com.dh.array;

/**
 * 2个有序数组的合并
 * 
 * @author Lenovo
 *
 */
public class ArrayMerge {
	public int[] mergeArray(int[] m, int[] n) {
		int mLength = m.length;
		int nLength = n.length;
		int[] result = new int[mLength + nLength];
		int i = 0;
		int j = 0;
		int cursor = 0;
		while (i < mLength && j < nLength) {
			if (m[i] < n[j]) {
				result[cursor] = m[i];
				i++;
			} else {
				result[cursor] = n[j];
				j++;
			}
			cursor++;
		}
		while (i < mLength) {
			result[cursor] = m[i];
			i++;
			cursor++;
		}
		while (j < mLength) {
			result[cursor] = n[j];
			j++;
			cursor++;
		}
		return result;

	}

}
