package com.dh.recursive;

/**
 * 阶乘
 * 
 * @author Lenovo
 *
 */
public class Factorial {

	public static void main(String[] args) {
		System.out.println(getData(4));
		;

	}

	public static int getData(int n) {
		if (n <= 0)
			throw new RuntimeException("越界检查");
		if (n == 1)
			return 1;
		else
			return n * getData(n - 1);
	}

}
