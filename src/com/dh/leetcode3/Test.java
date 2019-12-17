package com.dh.leetcode3;

public class Test {

	public static void main(String[] args) {

		String a="abcdefg";
		System.out.println(a.hashCode());
		System.out.println(a.hashCode()>>>16);
		System.out.println(hash(a));
		

	}
	 static final int hash(Object key) {
	        int h;
	        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	    }
}
