package com.dh.array;

/**
 * 本数组支持动态扩容 基本api new时，创建一个基本数组，达到3/4之后,扩大为之前的1.5倍。
 * 
 * @author Lenovo
 *
 */
public class ArrayDynamicExpansion<T> {

	private Object[] objArray;
	private int size;
	private int cursor;
	private int defaultSize = 8;

	public ArrayDynamicExpansion(int size) {
		this.size = size;
		cursor = 0;
		objArray = new Object[size];
	}

	public ArrayDynamicExpansion() {
		this.size = defaultSize;
		cursor = 0;
		objArray = new Object[defaultSize];
	}

	public void add(T a) {
		int newCursor = cursor + 1;
		check(newCursor);
		objArray[cursor] = a;
		cursor = newCursor;

	}

	@SuppressWarnings("unchecked")
	public T get(int index) {
		return (T) objArray[index];
	}

	/**
	 * 检查并且扩容
	 * 
	 * @param newCursor
	 */
	private void check(int newCursor) {
		if (newCursor * 1.5 > size) {
			size = size * 2;
			Object[] temp = new Object[size];
			for (int i = 0; i < size / 2; i++) {
				temp[i] = objArray[i];
			}
			objArray = temp;
		}
	}

}
