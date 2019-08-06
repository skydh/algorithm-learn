package com.dh.sort.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 绑定一个list，动态获取其top k数据 后续若有需求，可以新增新的api接口,目前仅仅支持插入和获取全部数据
 * 
 * @author Lenovo
 *
 */
public class TopKDynamic {
	private List<Integer> list;
	private int[] data;
	private int length;
	private int currentSize;
	private int topK;

	/**
	 * 初始化对象的时候就建立稳定的队列
	 * 
	 * @param list
	 * @param topK
	 */
	public TopKDynamic(int topK) {
		currentSize = 1;
		this.list = new ArrayList<>();
		this.length = topK + 2;
		this.topK = topK;
		data = new int[topK + 2];
	}

	public void insertHeap(int node) {
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

	/**
	 * 删除root节点
	 */
	public void deleteRoot() {

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

			int flag = 0;
			int left = 0;
			int right = 0;
			int min = 0;
			if (tempIndex * 2 < currentSize)
				left = data[tempIndex * 2];
			if (tempIndex * 2 + 1 < currentSize)
				right = data[tempIndex * 2 + 1];

			if (left > 0 && right > 0) {
				min = left < right ? left : right;
				if (left < right) {
					min = left;
					flag = 1;
				} else {
					min = right;
					flag = 2;
				}
			} else if (left <= 0 && right > 0) {
				min = right;
				flag = 2;

			} else if (left > 0 && right <= 0) {
				min = left;
				flag = 1;
			}

			int currentNode = data[tempIndex];
			if (currentNode < min) {
				break;
			}

			switch (flag) {

			case 1:
				swap(data, tempIndex, tempIndex * 2);
				tempIndex = tempIndex * 2;
				break;
			case 2:
				swap(data, tempIndex, tempIndex * 2 + 1);
				tempIndex = tempIndex * 2 + 1;
				break;
			default:
				return;

			}

		}

	}

	public void add(int node) {
		list.add(node);
		if (currentSize > topK) {
			if (data[1] < node) {
				deleteRoot();
				insertHeap(node);
			}
		} else
			insertHeap(node);

	}

	public List<Integer> getList() {
		return list;
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

	public int getLength() {
		return length;
	}

	public int[] getTopK() {
		return data;
	}
}
