package com.dh.lru;

/**
 * 
 * @author Lenovo
 *
 */
public class LRUTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LeastRecentlyUsedBuffer temp = new LeastRecentlyUsedBuffer(4);
		temp.put(1, 21);
		temp.put(2, 22);
		temp.put(3, 23);
		temp.put(4, 24);
		temp.put(5, 25);
		temp.remove(5);
		System.out.println(temp.getKey(5));

		System.out.println(temp.getKey(4));

		System.out.println("end");
	}

}
