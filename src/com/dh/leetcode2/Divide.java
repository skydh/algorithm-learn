package com.dh.leetcode2;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 
 * 示例 1:
 * 
 * 输入: dividend = 10, divisor = 3 输出: 3 示例 2:
 * 
 * 输入: dividend = 7, divisor = -3 输出: -2 说明:
 * 
 * 被除数和除数均为 32 位有符号整数。 除数不为 0。 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 −
 * 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class Divide {

	/**
	 * 思路吧，一开始就是想，一个个减，然后加一之类的，但是麻烦坑爹，算了，不采取这个方案了。 看了题解，有个很不错的方案，采用之。
	 * 
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public static int divide(int dividend, int divisor) {
		if (dividend == 0)
			return 0;
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		boolean isFu = (dividend > 0) ^ (divisor > 0);

		long ndividend = Math.abs((long) dividend);
		long ndivisor = Math.abs((long) divisor);

		int result = 0;
		for (int i = 31; i >= 0; i--) {
			if ((ndividend >> i) >= ndivisor) {
				result = result + (1 << i);
				ndividend = ndividend - (ndivisor << i);

			}

		}
		return isFu ? -result : result;
	}

	public static void main(String[] args) {

		System.out.println(divide(7, -3));

	}
}
