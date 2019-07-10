package com.dh.recursive;

/**
 * 斐波拉契队列
 * 
 * 那个公式，记住了，就是那样写
 * 
 * @author Lenovo
 *
 */
public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(getData(9));

	}

	public static int getData(int n) {
		if (n <= 0)
			throw new RuntimeException("越界检查");
		if (n == 1)
			return 1;
		else if (n == 2)
			return 1;
		else
			return getData(n - 1) + getData(n - 2);

	}

}
