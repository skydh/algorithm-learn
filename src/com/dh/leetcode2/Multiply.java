package com.dh.leetcode2;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 
 * 示例 1:
 * 
 * 输入: num1 = "2", num2 = "3" 输出: "6" 示例 2:
 * 
 * 输入: num1 = "123", num2 = "456" 输出: "56088" 说明：
 * 
 * num1 和 num2 的长度小于110。 num1 和 num2 只包含数字 0-9。 num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class Multiply {
	public static String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0"))
			return "0";
		char[] chars1 = num1.toCharArray();
		char[] chars2 = num2.toCharArray();
		int[] num = new int[chars1.length + chars2.length];

		for (int i = chars1.length - 1; i >= 0; i--) {
			for (int j = chars2.length - 1; j >= 0; j--) {
				int cursor = i+j+1;
				int newNum = (chars1[i] - '0') * (chars2[j] - '0');
				num[cursor] = num[cursor] + newNum;
				for (int k = cursor; k >= 0; k--) {
					if (num[k] > 10) {
						num[k - 1] = num[k - 1] + num[k] / 10;
						num[k] = num[k] % 10;
					} else
						break;
				}
			}
		}

		return arrayToString(num);

	}

	public static String arrayToString(int[] num) {
		StringBuilder sb = new StringBuilder();
		if (num[0] != 0) {
			sb.append(num[0]);
		}
		for (int i = 1; i < num.length; i++) {
			sb.append(num[i]);
		}
		return sb.toString();

	}
	
	public static void main(String[] args) {
		
		System.out.println(multiply("123","456"));

	}

}
