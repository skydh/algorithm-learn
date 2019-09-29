package com.dh.leetcode;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * 
 * L C I R E T O E S I I G E D H N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 
 * 
 * @author Lenovo
 *
 */
public class StringZConvert {
	/**
	 * 正常思维创建一个二维数组，按照当前逻辑输入进去，然后在按照顺序读取出来，，，太浪费空间。
	 * 
	 * 找规律，第一行 (2*numRows-2)，最后一行，(2*numRows-2)+numRows-1 中间的则是
	 * 奇数行(2*numRows−2)+x 以及偶数行 (2⋅numRows−2)−x
	 * 
	 * @param s
	 * @param numRows
	 * @return
	 */
	public String convert(String s, int numRows) {
		if (numRows <= 1)
			return s;
		StringBuilder sb = new StringBuilder();

		int base = 2 * numRows - 2;
		char[] chars = s.toCharArray();

		for (int i = 0; i < numRows; i++)
			for (int j = 0; j * base + i < chars.length; j++) {
				sb.append(chars[j * base + i]);
				if (i != 0 && i != numRows - 1) {
					if ((j + 1) * base - i < chars.length)
						sb.append(chars[(j + 1) * base - i]);
				}
			}
		return sb.toString();

	}

}
