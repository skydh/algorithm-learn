package com.dh.linklist;

/**
 * 循环链表，头尾相连接
 * 
 * api，打印，头尾节点的删除和新增
 * 
 * @author Lenovo
 *
 */
public class CycleLinkList {
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

	public CycleLinkList() {
		head = end = new LinkListNode(0);
		size = 0;
		head.next = end;
		end.next = head;
	}

	/**
	 * 添加到末尾
	 * 
	 * @param value
	 */
	public void addEnd(int value) {
		LinkListNode node = new LinkListNode(value);
		end.next = node;
		node.next = head;
		end = node;
		size++;
	}

	/**
	 * 添加到头部
	 * 
	 * @param value
	 */
	public void addHead(int value) {
		LinkListNode node = new LinkListNode(value);
		LinkListNode nextNode = head.next;
		head.next = node;
		node.next = nextNode;
		if (size == 0)
			end = node;
		size++;
	}

	/**
	 * 删除末尾节点数据
	 * 
	 * @param value
	 */
	public void deleteEnd() {
		if (size == 0)
			throw new RuntimeException("兄弟数据不够啊");
		LinkListNode node = head.next;
		while (node.next != end) {
			node = node.next;
		}
		node.next = head;
		end = node;
		size--;
	}

	/**
	 * 删除头部节点数据
	 * 
	 * @param value
	 */
	public void deleteHead() {
		if (size == 0)
			throw new RuntimeException("兄弟数据不够啊");
		LinkListNode deleteNode = head.next;
		LinkListNode nextNode = deleteNode.next;
		head.next = nextNode;
		size--;
		if (size == 0)
			end = head;
	}

	/**
	 * 获取当前大小
	 * 
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * 打印节点
	 */
	public void print() {
		LinkListNode node = head.next;
		while (node != head) {
			System.out.println(node.value);
			node = node.next;

		}
	}
}
