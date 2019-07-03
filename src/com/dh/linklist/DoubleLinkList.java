package com.dh.linklist;

/**
 * 双向链表
 * 
 * @author Lenovo
 *
 */
public class DoubleLinkList {
	/**
	 * 哨兵节点
	 */
	private LinkListNode head;

	/**
	 * 末尾节点
	 */
	private LinkListNode end;
	/**
	 * 当前链表大小
	 */
	private int size;

	class LinkListNode {
		/**
		 * 值
		 */
		int value;
		/**
		 * 下个节点
		 */
		LinkListNode next;
		/**
		 * 前个节点
		 */
		LinkListNode before;

		public LinkListNode(int value) {
			this.value = value;
		}

	}

	public DoubleLinkList() {
		head = end = new LinkListNode(0);
		end.before = head;
		size = 0;
	}

	/**
	 * 默认添加到尾部
	 */
	public void add(int value) {
		LinkListNode node = new LinkListNode(value);
		end.next = node;
		node.before = end;
		end = node;
		size++;
	}

	/**
	 * 某个位置添加元素
	 * 
	 * @param index
	 * @param value
	 */
	public void add(int index, int value) {
		if (index == size + 1) {
			add(value);
			return;
		}
		if (size + 1 < index)
			throw new RuntimeException("兄弟，你越界了");

		LinkListNode node = head;
		int i = 1;
		while (i < index) {
			node = node.next;
			i++;
		}
		LinkListNode nextNode = node.next;
		LinkListNode nowNode = new LinkListNode(value);
		node.next = nowNode;
		nowNode.before = node;
		nowNode.next = nextNode;
		nextNode.before = node;
		size++;

	}

	/**
	 * 返回尾部数据
	 * 
	 * @return
	 */
	public int get() {
		if (size <= 0)
			throw new RuntimeException("没数据，兄弟");
		return end.value;
	}

	/**
	 * 返回某个元素的数据
	 * 
	 * @param index
	 * @return
	 */
	public int get(int index) {
		if (size <= 0)
			throw new RuntimeException("没数据，兄弟");
		int i = 1;
		LinkListNode node = head;
		while (i < index) {
			node = node.next;
			i++;
		}
		LinkListNode nextNode = node.next;
		return nextNode.value;

	}

	/**
	 * 删除尾部元素
	 */
	public void delete() {
		if (size == 0)
			throw new RuntimeException("没数据，兄弟");
		LinkListNode beforNode = end.before;
		beforNode.next = null;
		end.before = null;
		end = beforNode;
		size--;
	}

	/**
	 * 删除某个元素
	 * 
	 * @param index
	 */
	public void delete(int index) {
		if (index == size) {
			delete();
			return;
		}
		if (index > size)
			throw new RuntimeException("该节点没数据，兄弟");
		LinkListNode node = head;
		int i = 1;
		while (i < index) {
			node = node.next;
			i++;
		}
		LinkListNode nextNode = node.next.next;
		LinkListNode deleteNode = node.next;
		deleteNode.before = null;
		deleteNode.next = null;
		node.next = nextNode;

		nextNode.before = node;
		size--;

	}

	/**
	 * 打印全部元素
	 */
	public void print() {
		LinkListNode node = head.next;
		while (node != null) {
			System.out.println(node.value);
			node = node.next;
		}

	}

}
