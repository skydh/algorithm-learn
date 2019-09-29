package com.dh.leetcode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 * 示例 1:
 * 
 * 输入: 123 输出: 321
 * 
 * @author Lenovo
 *
 */
public class IntReverse {
	public static int reverse(int x) {
		int max = (1 << 31) - 1;
		int min = -(1 << 31);
		Long temp = 0L;
		while (x != 0) {
			temp = temp * 10 + x % 10;
			if (temp > max || temp < min)
				return 0;
			x = x / 10;
		}

		return temp.intValue();

	}

	public static void main(String[] arg) {

		System.out.println(reverse(1534236469));

	}

}
