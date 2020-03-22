package com.dh.lettcode5;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * just for test
 * 
 * @author Lenovo
 *
 */
public class Test {

	public static void main(String[] args) {

		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.add(1);
		queue.add(1);
		queue.add(1);
		queue.add(2);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}

}
