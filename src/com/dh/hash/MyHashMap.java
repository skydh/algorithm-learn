package com.dh.hash;

/**
 * 自定义的基于链表法的散列表，有着扩容和缩容机智 默认大小是8 0.8扩容，0.1缩容倍数均是一倍
 * 
 * 这里是基于(int ,int)键值对的方式,且均为正整数
 * 
 * @author Lenovo
 *
 */
public class MyHashMap {

	/**
	 * 这里定义散列表节点
	 * 
	 * @author Lenovo
	 */
	class Node {
		public int k;
		public int v;

		public Node next;

		public Node(int k, int v) {
			this.k = k;
			this.v = v;
		}
	}

	public Node[] arrayNode;

	private int size;

	private int length;

	public MyHashMap() {
		size = 0;
		length = 8;
		arrayNode = new Node[8];

	}

	public MyHashMap(int length) {
		size = 0;
		this.length = length;
		arrayNode = new Node[length];
	}

	/**
	 * 对值进去
	 * 
	 * @param key
	 * @param value
	 */
	public void put(int key, int value) {
		expansion();
		put(key, value, arrayNode);
		size++;
	}

	/**
	 * 对值进去
	 * 
	 * @param key
	 * @param value
	 */
	public void put(int key, int value, Node[] arrayNode) {
		int index = key % length;

		Node indexNode = arrayNode[index];
		if (indexNode == null) {
			arrayNode[index] = new Node(key, value);

			return;
		}
		while (indexNode.next != null) {
			if (key == indexNode.k) {
				indexNode.v = value;
				return;
			}
			indexNode = indexNode.next;
		}

		indexNode.next = new Node(key, value);

	}

	/**
	 * 扩容
	 */
	public void expansion() {
		if ((length / 4) * 3 < size) {
			length = length * 2;
			Node[] arrayNodeTemp = new Node[length];
			for (int i = 0; i < length / 2; i++) {
				Node indexNode = arrayNode[i];
				while (indexNode != null) {
					put(indexNode.k, indexNode.v, arrayNodeTemp);
					indexNode = indexNode.next;
				}

			}
			arrayNode = arrayNodeTemp;
		}

	}

	/**
	 * 根据key取值
	 * 
	 * @param key
	 * @return
	 */
	public int get(int key) {
		int index = key % length;
		Node indexNode = arrayNode[index];

		while (indexNode != null) {
			if (indexNode.k == key) {
				return indexNode.v;
			}
			indexNode = indexNode.next;
		}
		return -1;
	}

	/**
	 * 根据key删除值
	 * 
	 * @param key
	 * @return
	 */
	public int remove(int key) {
		int index = key % length;

		Node indexNode = arrayNode[index];
		if (indexNode.k == key) {
			arrayNode[index] = indexNode.next;
			size--;
			return indexNode.v;
		}
		while (indexNode.next != null) {
			if (indexNode.next.k == key) {
				Node temp = indexNode.next.next;
				indexNode.next = temp;
				size--;
				return indexNode.v;
			}
			indexNode = indexNode.next;
		}
		return -1;
	}

	/**
	 * 获取当前大小
	 * 
	 * @return
	 */
	public int getSize() {
		return size;
	}
}
