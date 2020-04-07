package com.dh.lettcode5;

import java.util.Scanner;

/**
 * 华为笔试题
 * 
 * @author Lenovo
 *
 */
public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] data = null;
		int cursor = -1;
		while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例

			String num = in.nextLine();
			if (cursor == -1) {
				int iNum = Integer.parseInt(num);
				data = new int[iNum][101];
			} else {
				int cursori = 0;
				for (int i = num.length() - 1; i >= 0; i--) {
					data[cursor][cursori] = num.charAt(i) - 48;
					cursori++;

				}

			}

			if (cursor == data.length - 1)
				break;
			cursor++;

		}
		StringBuilder sb = new StringBuilder();
		int jin = 0;
		for (int i = 0; i < 101; i++) {
			int temp = jin;
			for (int j = 0; j < data.length; j++) {
				temp = temp + data[j][i];

			}
			jin = temp / 10;
			sb.append(temp % 10);
		}
		StringBuilder result = new StringBuilder();
		boolean isStart = false;
		for (int i = sb.length() - 1; i >= 0; i--) {
			if (!isStart) {
				if (sb.charAt(i) != '0') {
					result.append(sb.charAt(i));
					isStart = true;
				}
			} else {
				result.append(sb.charAt(i));
			}

		}

		System.out.println(result.toString());

	}

}
