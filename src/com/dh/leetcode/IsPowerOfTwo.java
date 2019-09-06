package com.dh.leetcode;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * 
 * 示例 1:
 * 
 * 输入: 1 输出: true 解释: 2^0 = 1 示例 2:
 * 
 * 输入: 16 输出: true 解释: 2^4 = 16 示例 3:
 * 
 * 输入: 218 输出: false
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class IsPowerOfTwo {
	/**
	 * 看了别人的题解，构思很巧妙，减1后和原本的做位与运算，
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfTwo(int n) {
		return n <= 0 ? false : ((n & (n - 1)) == 0 ? true : false);

	}

}
