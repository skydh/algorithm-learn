package com.dh.lettcode3;

import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.add("aa");
		stack.add("aa11");
		stack.add("aa22");
		System.out.println(stack.firstElement());
		System.out.println(stack.get(1));
	}

}
