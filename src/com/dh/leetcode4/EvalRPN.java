package com.dh.leetcode4;

import java.util.LinkedList;
import java.util.List;

public class EvalRPN {

	public int evalRPN(String[] tokens) {

		List<String> list = new LinkedList<>();
		for (String str : tokens)
			list.add(str);

		int cursor = 0;
		while (list.size() > 1) {

			if (list.get(cursor).equals("+")) {
				list.remove(cursor);
				int num1 = Integer.parseInt(list.remove(cursor - 1));
				int num2 = Integer.parseInt(list.remove(cursor - 2));

				list.add(cursor - 2, String.valueOf(num1 + num2));
				cursor--;

			} else if (list.get(cursor).equals("-")) {
				list.remove(cursor);
				int num1 = Integer.parseInt(list.remove(cursor - 1));
				int num2 = Integer.parseInt(list.remove(cursor - 2));

				list.add(cursor - 2, String.valueOf(num2 - num1));
				cursor--;

			} else if (list.get(cursor).equals("*")) {
				list.remove(cursor);
				int num1 = Integer.parseInt(list.remove(cursor - 1));
				int num2 = Integer.parseInt(list.remove(cursor - 2));

				list.add(cursor - 2, String.valueOf(num1 * num2));
				cursor--;
			} else if (list.get(cursor).equals("/")) {
				list.remove(cursor);
				int num1 = Integer.parseInt(list.remove(cursor - 1));
				int num2 = Integer.parseInt(list.remove(cursor - 2));

				list.add(cursor - 2, String.valueOf(num2 / num1));
				cursor--;
			} else {
				cursor++;
			}

		}
		return Integer.parseInt(list.get(0));

	}

}
