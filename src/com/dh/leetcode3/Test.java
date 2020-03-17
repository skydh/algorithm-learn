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
		System.out.println(Integer.MAX_VALUE);
		
		System.out.println("abcde".substring(0,2));

	}

	static final int hash(Object key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}
}
