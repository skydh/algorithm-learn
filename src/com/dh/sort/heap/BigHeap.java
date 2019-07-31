package com.dh.sort.heap;

/**
 * 大顶堆 必须是完全二叉树，父节点大于子节点。
 * 
 * 方案，由于是完全二叉树，因此，可以用数组来存储，目前为了开发方便，使用int类型（其实可以用对象数组来存储对象信息）
 * 为了满足的树节点的无线扩增，数组必须满足自动扩展的功能，由于删除可能导致数组变得很小，也要满足缩容效果。
 * 
 * 默认大小为16.
 * 
 * 扩容基数0.5 缩容基数0.1
 * 
 * 计算规则如下，当前节点为i,左子节点2i,右子节点2i+1.
 * 
 * 方法:增加节点（加到末尾，不断和父节点比较）。删除根节点（让末尾节点提换父节点，然后不断变换）。
 * 
 * 0序列不存数据 所有数据均为正整数
 * 
 * @author Lenovo
 *
 */
public class BigHeap {
	private int[] data;
	private int currentSize;
	private int length;

	public BigHeap() {
		data = new int[8];
		length = 8;
		currentSize = 1;
	}

	public BigHeap(int length) {
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
			if (data[tempIndex / 2] > data[tempIndex])
				break;
			if (data[tempIndex / 2] < data[tempIndex]) {
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
			int max = left > right ? left : right;
			int currentNode = data[tempIndex];
			if (currentNode >= max) {
				break;
			}
			if (max == left) {
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
