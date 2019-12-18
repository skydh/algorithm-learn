package com.dh.leetcode3;

public class Test {

	public static void main(String[] args) {

		String a="abcdefg";
		System.out.println(a.substring(2, 10));
		

	}
	 static final int hash(Object key) {
	        int h;
	        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	    }
}
