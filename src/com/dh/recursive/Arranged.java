package com.dh.recursive;

/**
 * 全排列
 * 
 * 要求使用递归的算法。 分析算法，把第一个数确定之后
 * 
 * @author Lenovo
 *
 */
public class Arranged {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		// 本来想用自己定义的list，但是可能看的人还要看我定义的list代码，这里直接用ArrayList
		int[] data = { 1, 2, 3, 4 };
		doData(data);
	}

	public static void doData(int[] data) {
		doDataHelp(data, data.length, 0);
	}

	public static void doDataHelp(int[] data, int length, int cursor) {
		if (length == cursor) {
			printData(data);
			return;
		}
		for (int i = cursor; i < length; i++) {
			swap(data, i, cursor);
			doDataHelp(data, length, cursor + 1);
			swap(data, cursor, i);

		}

	}

	/**
	 * 交换
	 * 
	 * @param data
	 * @param i
	 * @param j
	 */
	public static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	/**
	 * 打印
	 * 
	 * @param data
	 */
	public static void printData(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
		}
		System.out.println("////");
	}
}
