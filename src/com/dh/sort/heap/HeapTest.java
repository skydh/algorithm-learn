package com.dh.sort.heap;

public class HeapTest {

	public static void main(String[] args) {
		PriorityQueue queue = new PriorityQueue();
		queue.push("1", 1);
		queue.push("2", 2);

		queue.push("3", 3);

		queue.push("4", 4);

		queue.push("5", 5);

		queue.push("6", 6);
		queue.push("51", 5);

		System.out.println(queue.get());
		System.out.println(queue.get());
		System.out.println(queue.get());
		System.out.println(queue.get());
		System.out.println(queue.get());
		System.out.println(queue.get());

	}

}
