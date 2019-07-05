package com.dh.stack;

/**
 * 定义一个顺序栈 可动态扩容的那种哦
 * 
 * 定义当当前大小达到其3/4时。扩容一倍
 * 
 * 
 * @author Lenovo
 *
 */
public class OrderStack {
	/**
	 * 存放栈数据的
	 */
	private int[] dataStack;
	/**
	 * 最大容量
	 */
	private int size;
	/**
	 * 当前大小
	 */
	private int currentSize;

	public OrderStack() {
		dataStack = new int[8];
		size = 8;
		currentSize = 0;
	}

	public OrderStack(int size) {
		dataStack = new int[size];
		currentSize = 0;
		this.size = size;
	}

	/**
	 * put数据进去
	 */
	public void push(int value) {
		if (currentSize * 1.5 > size)
			resize();
		dataStack[currentSize] = value;
		currentSize++;
	}

	/**
	 * 扩容
	 */
	public void resize() {
		int[] dataNewStack = new int[size * 2];
		for (int i = 0; i < dataStack.length; i++) {
			dataNewStack[i] = dataStack[i];
		}
		this.dataStack = dataNewStack;
		size=size*2;

	}

	/**
	 * 
	 * @return
	 */
	public int get() {
		if (currentSize <= 0)
			throw new RuntimeException("兄弟，没有数据啊");
		currentSize--;
		return dataStack[currentSize];
	}

}
