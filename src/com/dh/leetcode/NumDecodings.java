package com.dh.leetcode;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 
 * 示例 1:
 * 
 * 输入: "12" 输出: 2 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。 示例 2:
 * 
 * 输入: "226" 输出: 3 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6)
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/decode-ways
 * 
 * 
 * @author Lenovo
 *
 */
public class NumDecodings {

	/**
	 * 斐波拉契数列
	 * 
	 * 分析如下，字符串 123456789 我们从最后一位开始分隔，以及倒数第二位开始分隔 那么就是
	 * 1234567+89，和12345678+9=123456789 的策略 得到公式 f(n)=f(n-1)+f(n-2)
	 * 
	 * f(1)=1 f(2)看情况 是否为2或者1
	 * 
	 * @param s
	 * @return
	 */
	public int numDecodings(String s) {
		if (s.startsWith("0"))
			return 0;
		if (s.endsWith("00"))
			return 0;
		if (s.length() == 2 && (s.equals("10") || s.equals("20")))
			return 1;
		if (s.length() > 2 && (s.endsWith("10") || s.endsWith("20")))
			s = s.substring(0, s.length() - 2);
		if (s.length() < 2 && Integer.parseInt(s) > 0)
			return 1;
		if (s.length() < 2 && Integer.parseInt(s) == 0)
			return 0;
		if (s.endsWith("0") && Integer.parseInt(s.substring(s.length() - 2, s.length() - 1)) > 2)
			return 0;

		/**
		 * 不使用递归，直接dp
		 */
		char[] charS = s.toCharArray();

		int[] data = new int[charS.length];
		data[0] = 1;
		if ((Integer.parseInt(charS[0] + "") == 0 || Integer.parseInt(charS[0] + "") > 2)
				&& Integer.parseInt(charS[1] + "") == 0)
			return 0;
		if ((Integer.parseInt(charS[0] + "") == 1 && Integer.parseInt(charS[1] + "") > 0)
				|| (Integer.parseInt(charS[0] + "") == 2 && Integer.parseInt(charS[1] + "") < 7))
			data[1] = 2;
		else
			data[1] = 1;

		if (charS.length > 2 && Integer.parseInt(charS[2] + "") == 0)
			data[1] = 1;
		for (int i = 2; i < charS.length; i++) {
			if ((Integer.parseInt(charS[i - 1] + "") == 0 || Integer.parseInt(charS[i - 1] + "") > 2)
					&& Integer.parseInt(charS[i] + "") == 0)
				return 0;
			if(charS[i]=='0'){
				data[i] = data[i - 1];
				continue;
			}
			if ((Integer.parseInt(charS[i - 1] + "") == 1 && Integer.parseInt(charS[i] + "") > 0)
					|| (Integer.parseInt(charS[i - 1] + "") == 2 && Integer.parseInt(charS[i] + "") < 7)) {
				data[i] = data[i - 1] + data[i - 2];
			} else
				data[i] = data[i - 1];

		}
		return data[data.length - 1];

	}

	public static void main(String[] arg) {
		NumDecodings numDecodings = new NumDecodings();
		System.out.println(numDecodings.numDecodings("7206"));
	}

}
