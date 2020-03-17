package com.dh.lettcode5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * just for test
 * 
 * @author Lenovo
 *
 */
public class Test {

	public static void main(String[] args) {
		// PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b -
		// a));
		// queue.add(1);
		// queue.add(5);
		// queue.add(9);
		// queue.add(3);
		// System.out.println(queue.poll());
		// System.out.println(queue.peek());
		// System.out.println(queue.peek());

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(5);
		list.add(4);

		list.remove(4);
		list.remove(3);
		list.remove(1);
		System.out.println("11");
	}

}
