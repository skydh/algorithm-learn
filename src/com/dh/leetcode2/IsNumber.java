package com.dh.leetcode2;

/**
 * 验证给定的字符串是否可以解释为十进制数字。
 * 
 * 例如:
 * 
 * "0" => true " 0.1 " => true "abc" => false "1 a" => false "2e10" => true
 * " -90e3   " => true " 1e" => false "e3" => false " 6e-1" => true " 99e2.5 "
 *  => false "53.5e93" => true " --6 " => false "-+3" => false
 * "95a54e53" => false
 * 
 * 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
 * 
 * 数字 0-9 指数 - "e" 正/负号 - "+"/"-" 小数点 - "." 当然，在输入中，这些字符的上下文也很重要。
 * 
 * 更新于 2015-02-10: C++函数的形式已经更新了。如果你仍然看见你的函数接收 const char * 类型的参数，请点击重载按钮重置你的代码。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class IsNumber {

	/**
	 * 直接法，分析题意解析出来，情况可能很多，感觉直接写，没有啥收获，看了题解，dfa，有限状态机。不错，学到了。
	 * 
	 * 先画状态表，再画状态图。
	 * 
	 * @param s
	 * @return
	 */
	public boolean isNumber(String s) {
		/**
		 * 去掉首尾空格
		 */
		String newS = s.trim();
		int state = 0;
		for (int i = 0; i < newS.length(); i++) {
			state = getState(state, newS.charAt(i));
			if (state == -1)
				return false;

		}
		if (state == 3 || state == 6 || state == 4 || state == 8) {
			return true;
		}

		return false;

	}

	/**
	 * 定义了下面的状态转移方程
	 * 
	 * @param state
	 * @param chars
	 * @return
	 */
	public int getState(int state, char chars) {
		if (state == 0) {
			if (chars == '+' || chars == '-')
				return 1;
			else if (chars >= '0' && chars <= '9') {
				return 3;
			} else if (chars == '.') {
				return 2;
			} else {
				return -1;
			}

		} else if (state == 1) {
			if (chars >= '0' && chars <= '9') {
				return 3;
			} else if (chars == '.') {
				return 2;
			} else {
				return -1;
			}
		} else if (state == 2) {
			if (chars >= '0' && chars <= '9') {
				return 4;
			} else {
				return -1;
			}
		} else if (state == 3) {
			if (chars >= '0' && chars <= '9') {
				return 3;
			} else if (chars == '.') {
				return 8;
			} else if (chars == 'e') {
				return 5;
			} else {
				return -1;
			}

		} else if (state == 4) {

			if (chars >= '0' && chars <= '9') {
				return 4;
			} else if (chars == 'e') {
				return 5;
			} else {
				return -1;
			}
		} else if (state == 5) {
			if (chars >= '0' && chars <= '9') {
				return 6;
			} else if (chars == '+' || chars == '-') {
				return 7;
			} else {
				return -1;
			}
		} else if (state == 6) {
			if (chars >= '0' && chars <= '9') {
				return 6;
			} else {
				return -1;
			}
		} else if (state == 7) {
			if (chars >= '0' && chars <= '9') {
				return 6;
			} else {
				return -1;
			}
		} else if (state == 8) {
			if (chars >= '0' && chars <= '9') {
				return 4;
			} else if (chars == 'e') {
				return 5;
			} else {
				return -1;
			}
		} else {
			return -1;
		}

	}

}
