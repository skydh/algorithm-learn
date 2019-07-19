package com.dh.hash;

public class HashTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHashMap hash = new MyHashMap();
		hash.put(32, 23);
		hash.put(3, 23);
		hash.put(4, 23);
		hash.put(12, 23);
		hash.put(20, 23);
		hash.put(5, 23);
		hash.put(34, 23);
		hash.put(67, 23);
		hash.remove(12);
		System.out.println(hash.get(32));
	}

}
