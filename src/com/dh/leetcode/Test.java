package com.dh.leetcode;

import java.util.PriorityQueue;

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
		PriorityQueue<String[]> pq = new PriorityQueue<>((a, b) -> (Integer.parseInt(b[1]) - Integer.parseInt(a[1])));
		String[] data1 = { "hello", "5" };
		String[] data2 = { "hello1", "6" };
		String[] data3 = { "hello12", "7" };
		String[] data4 = { "hello123", "8" };
		pq.add(data1);
		pq.add(data2);
		pq.add(data3);
		pq.add(data4);
		System.out.println(pq.remove()[0]);

		System.out.println(1056389759 > (1 << 31));

		System.out.println(123 % 10);
	}

}
