package com.dh.linklist;

/**
 * 单链表
 * 
 * 
 * 
 * @author Lenovo
 *
 */
public class SingleLinkList {

	/**
	 * 哨兵结点
	 */
	private LinkListNode head;

	/**
	 * 末尾结点
	 */
	private LinkListNode end;

	/**
	 * 链表大小
	 */
	private int size;

	/**
	 * 定义一个单节点
	 * 
	 * @author Lenovo
	 *
	 */
	class LinkListNode {
		/**
		 * 值
		 */
		int value;
		/**
		 * 下个节点
		 */
		LinkListNode next;

		public LinkListNode(int value) {
			this.value = value;
		}

	}

	public SingleLinkList() {

		this.head = this.end = new LinkListNode(0);
		this.size = 0;

	}

	/**
	 * 添加元素，默认加到末尾
	 * 
	 * @param value
	 */
	public void add(int value) {
		LinkListNode node = new LinkListNode(value);
		end.next = node;
		end = node;
		size++;

	}

	/**
	 * 添加元素，添加到这个index.
	 * 
	 * @param value
	 */
	public void add(int index, int value) {
		if (size + 1 < index) {
			throw new RuntimeException("越界了，兄弟");
		}
		int i = 1;
		LinkListNode current = head;
		while (i < index) {
			current = current.next;
			i++;
		}
		LinkListNode nextNode = current.next;
		LinkListNode node = new LinkListNode(value);
		current.next = node;
		size++;
		if (size == index)
			end = node;
		else
			node.next = nextNode;

	}

	/**
	 * 添加元素，添加到这个index.
	 * 
	 * @param value
	 */
	public void delete(int index) {
		if (size < index) {
			throw new RuntimeException("越界了，兄弟");
		}
		int i = 1;
		LinkListNode current = head;
		while (i < index) {
			current = current.next;
			i++;
		}
		LinkListNode deleteNode = current.next;
		LinkListNode nextNode = deleteNode.next;

		if (index == size)
			end = current;
		else
			current.next = nextNode;

		size--;
	}

	/**
	 * 获取元素
	 * 
	 * @return
	 */
	public int get(int index) {
		if (size < index) {
			throw new RuntimeException("越界了，兄弟");
		}
		int i = 1;
		LinkListNode current = head;
		while (i < index) {
			current = current.next;
			i++;
		}
		return current.next.value;
	}

	public void print() {
		LinkListNode current = head;
		while (current.next != null) {
			System.out.println(current.next.value);
			current = current.next;
		}

	}

}
