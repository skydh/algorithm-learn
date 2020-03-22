package com.dh.lettcode5;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * 
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 * 
 * 示例 1:
 * 
 * 输入：[1,2,2] 输出：1 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。 示例 2:
 * 
 * 输入：[3,2,1,2,1,7] 输出：6 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。 可以看出 5 次或 5
 * 次以下的 move 操作是不能让数组的每个值唯一的。 提示：
 * 
 * 0 <= A.length <= 40000 0 <= A[i] < 40000
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class MinIncrementForUnique {
	public int minIncrementForUnique(int[] A) {
		if (A.length == 0)
			return 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < A.length; i++) {
			Integer temp = map.get(A[i]);
			if (temp == null) {
				queue.add(A[i]);
				temp = 0;
			}
			map.put(A[i], temp + 1);

		}
		int currentMin = queue.peek() - 1;
		int sum = 0;
		while (queue.size() != 0) {
			Integer temp = queue.poll();
			Integer times = map.remove(temp);
			if (temp > currentMin) {
				sum = sum + times * (times - 1) / 2;
				currentMin = times + temp-1;

			} else {
				sum = sum + times * (times - 1) / 2 + times * (currentMin + 1 - temp);
				currentMin = times + currentMin;
			}
			

		}

		return sum;

	}

	public static void main(String[] args) {
		MinIncrementForUnique mq = new MinIncrementForUnique();
		int[] data = { 4, 4, 5, 1, 4, 3 };
		System.out.println(mq.minIncrementForUnique(data));

	}
}
