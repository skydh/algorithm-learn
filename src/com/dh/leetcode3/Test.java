package com.dh.leetcode3;

import java.util.PriorityQueue;

public class Test {

	public static void main(String[] args) {

		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> (b - a));

		priorityQueue.add(1);
		priorityQueue.add(2);
		priorityQueue.add(3);
		priorityQueue.add(4);
		System.out.println(priorityQueue.size());
		System.out.println(priorityQueue.peek());
		System.out.println(priorityQueue.size());

	}

	static final int hash(Object key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}
}
