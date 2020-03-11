package com.dh.lettcode5;

/**
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * 
 * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... +
 * A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-array-into-three-parts-with-
 * equal-sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class CanThreePartsEqualSum {
	/**
	 * 3 <= A.length <= 50000 -10^4 <= A[i] <= 10^4
	 * 
	 * @param A
	 * @return
	 */
	public boolean canThreePartsEqualSum(int[] A) {
		long sum = 0;
		for (int i = 0; i < A.length; i++)
			sum = sum + A[i];
		long average = sum / 3;
		if (average * 3 != sum)
			return false;

		int startCurrent = 0;
		int i = 0;
		for (; i < A.length; i++) {
			startCurrent = startCurrent + A[i];
			if (startCurrent == average) {
				break;
			}

		}
		if (startCurrent != average)
			return false;
		int endCurrent = 0;
		int j = A.length - 1;
		for (; j > i; j--) {
			endCurrent = endCurrent + A[j];
			if (endCurrent == average) {
				break;
			}

		}

		if (endCurrent != average)
			return false;

		if(j-i<2)
			return false;
		int midCurrent = 0;
		for (int k = i + 1; k < j; k++)

			midCurrent = midCurrent + A[k];

		if (midCurrent != average)
			return false;

		return true;

	}

}
