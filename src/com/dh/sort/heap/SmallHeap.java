package com.dh.sort.heap;

/**
 * 小顶堆
 * 
 * @author Lenovo
 *
 */
public class SmallHeap {
	private int[] data;
	private int currentSize;
	private int length;

	public SmallHeap() {
		data = new int[8];
		length = 8;
		currentSize = 1;
	}

	public SmallHeap(int length) {
		data = new int[length];
		this.length = length;
		currentSize = 1;
	}

	/**
	 * 长度
	 * 
	 * @return
	 */
	public int getLength() {
		return length;
	}

	/**
	 * 容积
	 * 
	 * @return
	 */
	public int getSize() {
		return currentSize;
	}

	/**
	 * 插入数据
	 * 
	 * @param node
	 */
	public void insert(int node) {
		resize();
		data[currentSize] = node;
		int tempIndex = currentSize;
		while (tempIndex > 0) {
			if (tempIndex / 2 <= 0)
				break;
			if (data[tempIndex / 2] < data[tempIndex])
				break;
			if (data[tempIndex / 2] > data[tempIndex]) {
				swap(data, tempIndex / 2, tempIndex);
				tempIndex = tempIndex / 2;
			}
		}
		currentSize++;

	}

	public void resize() {
		boolean flag = true;
		int[] newData = null;
		if (length < currentSize * 2) {
			flag = false;
			newData = new int[length * 2];
			length = length * 2;
		} else if (length / 10 > currentSize) {
			flag = false;
			newData = new int[length / 2];
			length = length / 2;
		}
		if (flag)
			return;
		int cursor = data.length > length ? length : data.length;
		for (int i = 1; i < cursor; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

	/**
	 * 删除root节点
	 */
	public void deleteRoot() {
		resize();
		if (currentSize == 1) {
			return;
		}
		if (currentSize == 2) {
			data[1] = 0;
			currentSize--;
			return;
		}
		data[1] = data[currentSize - 1];
		data[currentSize - 1] = 0;
		currentSize--;
		int tempIndex = 1;
		while (tempIndex < currentSize) {
			int left = data[2 * tempIndex];
			int right = data[2 * tempIndex + 1];
			int min = left < right ? left : right;
			int currentNode = data[tempIndex];
			if (currentNode < min) {
				break;
			}
			if (min == left) {
				swap(data, tempIndex, tempIndex * 2);
				tempIndex = tempIndex * 2;
			} else {
				swap(data, tempIndex, tempIndex * 2 + 1);
				tempIndex = tempIndex * 2 + 1;
			}
		}

	}

	/**
	 * 交换数据
	 * 
	 * @param a
	 * @param i
	 * @param j
	 */
	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}


}
