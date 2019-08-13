package com.dh.sort.heap;

/**
 * 优先级队列 和大顶堆的原理几乎一模一样。 优先队列是，优先级高的先出列，因此2个口子，进入队列，和出队列，时间复杂度为logn
 * 
 * 数值越大，优先级越高，优先级一样，先来的出去
 * 
 * 
 * 如果要是小顶堆，那么，将值加个负号
 * 
 * @author Lenovo
 *
 */
public class PriorityQueue {

	/**
	 * 队列节点
	 * 
	 * @author Lenovo
	 *
	 */
	public class Node {
		public int sequence;
		public String value;

		public Node(int sequence, String value) {
			this.sequence = sequence;
			this.value = value;
		}
	}

	private Node[] data;
	private int length;
	private int currentSize;

	public int getSize() {
		return currentSize - 1;
	}

	public PriorityQueue() {
		this(8);
	}

	public PriorityQueue(int length) {
		data = new Node[length];
		this.length = length;
		currentSize = 1;

	}

	/**
	 * 直接丢一个node节点进去
	 * 
	 * @param node
	 */
	public void push(Node node) {
		push(node.value, node.sequence);
	}

	/**
	 * 更新这个节点
	 * 
	 * @param node
	 */
	public void update(Node node) {
		while (true) {

		}

	}

	public void push(String value, int seq) {
		resize();
		Node node = new Node(seq, value);
		data[currentSize] = node;
		int cursor = currentSize;
		while (cursor > 0) {
			if (cursor / 2 == 0)
				break;
			if (data[cursor / 2].sequence >= seq)
				break;
			else {
				swap(data, cursor / 2, cursor);
				cursor = cursor / 2;
			}
		}
		currentSize++;
	}

	public Node get() {
		resize();
		Node temp = data[1];
		if (currentSize == 1) {
			return null;
		}
		data[1] = data[currentSize - 1];
		data[currentSize - 1] = null;
		int cursor = 1;
		while (cursor < currentSize - 1) {
			int left = data[cursor * 2] != null ? data[cursor * 2].sequence : 0;
			int right = data[cursor * 2 + 1] != null ? data[cursor * 2 + 1].sequence : 0;
			int max = left > right ? left : right;

			if (max < data[cursor].sequence)
				break;
			if (left == right || max == left) {
				swap(data, cursor * 2, cursor);
				cursor = cursor * 2;
			} else {
				swap(data, cursor * 2 + 1, cursor);
				cursor = cursor * 2 + 1;
			}

		}
		currentSize--;
		return temp;
	}

	public void resize() {
		boolean flag = true;
		Node[] newData = null;
		if (length < currentSize * 2) {
			flag = false;
			newData = new Node[length * 2];
			length = length * 2;
		} else if (length / 10 > currentSize) {
			flag = false;
			newData = new Node[length / 2];
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
	 * 交换数据
	 * 
	 * @param a
	 * @param i
	 * @param j
	 */
	public void swap(Node[] a, int i, int j) {
		Node temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
