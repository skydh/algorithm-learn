package com.dh.lettcode5;

public class PartitionDisjoint {
	public int partitionDisjoint(int[] A) {

		int leftMax = A[0];
		int rightMin = A[A.length - 1];
		int endLeft = 0;
		int cursor = A.length - 1;
		while (cursor > endLeft) {
			if (A[cursor] >= leftMax) {
				rightMin = Math.min(rightMin, A[cursor]);
				cursor--;
			} else {
				while (endLeft < cursor) {
					leftMax = Math.max(leftMax, A[endLeft]);
					endLeft++;
				}
				if (rightMin >= leftMax) {
					return endLeft+1;
				} else {
					cursor = A.length - 1;
					rightMin = A[A.length - 1];

				}
			}

		}

		return endLeft+1;

	}
}
