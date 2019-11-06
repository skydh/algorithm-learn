package com.dh.leetcode3;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 
 * 输入为非空字符串且只包含数字 1 和 0。
 * 
 * 示例 1:
 * 
 * 输入: a = "11", b = "1" 输出: "100" 示例 2:
 * 
 * 输入: a = "1010", b = "1011" 输出: "10101"
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class AddBinary {
	public static String addBinary(String a, String b) {
		int length = a.length() > b.length() ? a.length() + 1 : b.length() + 1;
		StringBuilder sb = new StringBuilder(length);
		int cursorA = a.length() - 1;
		int cursorB = b.length() - 1;
		boolean isJin = false;
		while (cursorA >= 0 || cursorB >= 0) {
			int data = 0;
			if (cursorA >= 0 && cursorB >= 0) {
				data = a.charAt(cursorA) + b.charAt(cursorB) - 96;
			} else if (cursorB < 0) {
				data = a.charAt(cursorA) - 48;
			} else if (cursorA < 0) {
				data = b.charAt(cursorB) - 48;
			}

			if (isJin) {
				if (data == 1) {
					sb.setCharAt(0, '0');
					sb.insert(0, '1');
					isJin = true;
				} else if (data == 2) {
					sb.insert(0, '1');
					isJin = true;
				} else {
					isJin = false;
				}

			} else {
				if (data == 0) {
					sb.insert(0, '0');
					isJin = false;
				} else if (data == 1) {
					sb.insert(0, '1');
					isJin = false;
				} else if (data == 2) {
					sb.insert(0, '0');
					sb.insert(0, '1');
					isJin = true;
				}
			}

			cursorB--;
			cursorA--;

		}

		return sb.toString();

	}
	
	public static void main(String[] args) {
		
		System.out.println(addBinary("1","111"));
	}

}
