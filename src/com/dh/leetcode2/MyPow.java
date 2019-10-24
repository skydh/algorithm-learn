package com.dh.leetcode2;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 
 * 示例 1:
 * 
 * 输入: 2.00000, 10 输出: 1024.00000 示例 2:
 * 
 * 输入: 2.10000, 3 输出: 9.26100 示例 3:
 * 
 * 输入: 2.00000, -2 输出: 0.25000 解释: 2-2 = 1/22 = 1/4 = 0.25 说明:
 * 
 * -100.0 < x < 100.0 n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class MyPow {
	public static double myPow(double x, int n) {
		boolean isF = false;
		if (n == Integer.MIN_VALUE && Math.abs(x) > 1)
			return 0;
		if (n == Integer.MIN_VALUE && Math.abs(x) < 1)
			return Double.MAX_VALUE;
		if (n == Integer.MIN_VALUE && Math.abs(x) == 1)
			return 1;
		if (n == 0)
			return 1;
		if (n < 0) {
			isF = true;
			n = -n;
		}
		double mux = x;
		int cursor = 1;
		double temp = x;

		while (cursor <= n) {
			if (cursor <= n / 2) {
				if (mux == 0)
					return 0;
				mux = mux * temp;
				cursor = cursor * 2;
				temp = temp * temp;
			} else {
				n = n - cursor;
				cursor = 1;
				temp = x;
				/**
				 * 因为我是从1开始，所以，当n>0的时候，需要乘以下
				 */
				if (n > 0)
					mux = mux * temp;
			}

		}
		return getData(isF, mux);

	}

	public static double getData(boolean isF, double data) {
		if (isF)
			return 1 / data;
		else
			return data;
	}

	public static void main(String[] args) {

		System.out.println(myPow(2, -2147483647));

	}
}
