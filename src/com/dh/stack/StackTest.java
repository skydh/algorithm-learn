package com.dh.stack;

/**
 * 栈测试
 * 
 * @author Lenovo
 *
 */
public class StackTest {
	public static void main(String[] args) {
		testLinkStack();
	}

	public static void testOrderStack() {

		OrderStack stack = new OrderStack(4);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		System.out.println(stack.get());

	}

	public static void testLinkStack() {

		LinkStack stack = new LinkStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		System.out.println(stack.get());

	}

}
