package com.dh.leetcode3;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：给定 n 是一个正整数。
 * 
 * 示例 1：
 * 
 * 输入： 2 输出： 2 解释： 有两种方法可以爬到楼顶。 1. 1 阶 + 1 阶 2. 2 阶 示例 2：
 * 
 * 输入： 3 输出： 3 解释： 有三种方法可以爬到楼顶。 1. 1 阶 + 1 阶 + 1 阶 2. 1 阶 + 2 阶 3. 2 阶 + 1 阶
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class ClimbStairs {

	/**
	 * 标准的dp算法 f(n)=f(n-1)+f(n-2)
	 * 
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		int temp1 = 1;
		int temp2 = 2;
		int temp3 = 3;
		for (int i = 3; i <= n; i++) {
			temp3 = temp1 + temp2;
			temp1 = temp2;
			temp2 = temp3;
		}
		return temp3;
	}

}
