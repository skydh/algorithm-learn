package com.dh.lettcode5;

import java.util.HashSet;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 * 
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到
 * 1。如果可以变为 1，那么这个数就是快乐数。
 * 
 * 示例: 
 * 
 * 输入: 19 输出: true 解释: 12 + 92 = 82 82 + 22 = 68 62 + 82 = 100 12 + 02 + 02 = 1
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class IsHappy {
	public boolean isHappy(int n) {

		HashSet<Integer> set = new HashSet<>();
		while (set.contains(n) == false) {
			n = doHelper(n);
			if (n == 1)
				return true;

		}

		return false;

	}

	public int doHelper(int num) {
		int sum = 0;
		while (num != 0) {
			sum = sum + (num % 10) * (num % 10);
			num = num / 10;
		}
		return sum;

	}

	public static void main(String[] args) {

		IsHappy is = new IsHappy();

		System.out.println(is.isHappy(19));
	}

}
