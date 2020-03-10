package com.dh.lettcode5;

/**
 * 给定一个正整数 n，你可以做如下操作：
 * 
 * 1. 如果 n 是偶数，则用 n / 2替换 n。 2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。 n 变为 1
 * 所需的最小替换次数是多少？
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/integer-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class IntegerReplacement {

	public int integerReplacement(int n) {
		return doHelper(n, 0);

	}

	public int doHelper(long n, int times) {
		if (n == 1)
			return times;
		if (n % 2 == 0) {
			return doHelper(n / 2, times + 1);
		} else {
			return Math.min(doHelper(n - 1, times + 1), doHelper(n + 1, times + 1));
		}

	}

}
