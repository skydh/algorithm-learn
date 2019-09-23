package com.dh.leetcode;

public class Test {
	public static int SQR1(int b) {
		if (b <= 0)
			return -1;
		if (b == 1)
			return 1;
		int i = 1;
		while (true) {
			if (i * i <= b)
				i++;
			else
				break;
		}
		return i - 1;
	}

	public static void main(String[] arg) {
		System.out.println(SQR1(4));

	}

}
