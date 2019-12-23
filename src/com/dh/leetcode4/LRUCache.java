package com.dh.leetcode4;

import java.util.HashMap;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 写入数据 put(key, value)
 * - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * 
 * 进阶:
 * 
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class LRUCache {

	private HashMap<Integer, Node> map = new HashMap<>();

	private Node head;
	private Node end;

	private int size;

	private int currentSize = 0;

	public class Node {
		/**
		 * 节点值
		 */
		public int value;
		public int key;
		/**
		 * 下个节点
		 */
		public Node next;

		/**
		 * 上个节点
		 */
		public Node pre;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

	}

	public LRUCache(int capacity) {
		head = new Node(-1, -1);
		end = new Node(-1, -1);
		head.next = end;
		end.pre = head;
		size = capacity;
	}

	public int get(int key) {
		Node node = map.get(key);
		if (node == null)
			return -1;

		Node pre = node.pre;
		Node next = node.next;
		pre.next = next;
		next.pre = pre;

		Node newNext = head.next;
		head.next = node;
		node.pre = head;
		node.next = newNext;
		newNext.pre = node;

		return node.value;

	}

	public void put(int key, int value) {
		Node temp = map.get(key);
		if (temp != null) {
			temp.value = value;
			get(key);

			return;
		}

		Node node = new Node(key, value);
		Node newNext = head.next;
		head.next = node;
		node.pre = head;
		node.next = newNext;
		newNext.pre = node;
		map.put(key, node);

		if (currentSize < size)

		{
			currentSize++;
		} else {

			Node pre = end.pre;
			Node newPre = pre.pre;
			newPre.next = end;
			end.pre = newPre;
			map.remove(pre.key);
		}

	}

	public static void main(String[] args) {
		LRUCache la = new LRUCache(2);
		la.put(2, 1);
		la.put(1, 1);
		la.put(2, 3);
		la.put(4, 1);
		System.out.println(la.get(1));
		System.out.println(la.get(2));

	}

}
