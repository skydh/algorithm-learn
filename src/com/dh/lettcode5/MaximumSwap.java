package com.dh.lettcode5;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * 
 * 示例 1 :
 * 
 * 输入: 2736 输出: 7236 解释: 交换数字2和数字7。 示例 2 :
 * 
 * 输入: 9973 输出: 9973 解释: 不需要交换。 注意:
 * 
 * 给定数字的范围是 [0, 108]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximum-swap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class MaximumSwap {
	public int maximumSwap(int num) {
		List<Integer> list = new ArrayList<>();
		while (num != 0) {
			list.add(num % 10);
			num = num / 10;
		}
		int length = list.size();
		/**
		 * 交换一次即可，那么就是遍历，从最后一位到第一位，直到发生交换,或者位移为0，然后生成新的数字返回
		 */
		boolean isSwap = false;
		int cursor = length - 1;
		while (!isSwap && cursor > 0) {
			int newCursor = cursor - 1;
			int maxCursor = newCursor;
			int max = list.get(newCursor);
			newCursor--;
			while (newCursor >= 0) {
				if (list.get(newCursor) >=max) {
					maxCursor = newCursor;
					max = list.get(newCursor);
				}
				newCursor--;
			}
			if (max > list.get(cursor)) {
				isSwap = true;

				list.set(maxCursor, list.get(cursor));
				list.set(cursor, max);
			}
			cursor--;

		}

		int result = 0;
		for (int i = length - 1; i >= 0; i--) {
			result = result * 10 + list.get(i);
		}
		return result;

	}

	public static void main(String[] args) {
		MaximumSwap maximumSwap = new MaximumSwap();
		System.out.println(maximumSwap.maximumSwap(9193));

	}

}
