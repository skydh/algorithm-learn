package com.dh.stack;

/**
 * 链式栈
 * 
 * @author Lenovo
 *
 */
public class LinkStack {

	/**
	 * 哨兵结点
	 */
	private LinkStackNode head;

	/**
	 * 末尾结点
	 */
	private LinkStackNode end;

	/**
	 * 栈大小
	 */
	private int size;

	/**
	 * 定义一个单节点
	 * 
	 * @author Lenovo
	 *
	 */
	class LinkStackNode {
		/**
		 * 值
		 */
		int value;
		/**
		 * 下个节点
		 */
		LinkStackNode next;

		/**
		 * 前个节点
		 */
		LinkStackNode before;

		public LinkStackNode(int value) {
			this.value = value;
		}

	}

	public LinkStack() {

		this.head = this.end = new LinkStackNode(0);
		this.size = 0;

	}

	/**
	 * 返回哨兵节点
	 * 
	 * @return
	 */
	public LinkStackNode getHead() {
		return head;

	}

	/**
	 * put数据进去
	 */
	public void push(int value) {
		LinkStackNode node = new LinkStackNode(value);
		end.next = node;
		node.before = end;
		end = node;
		size++;

	}

	/**
	 * 返回数据
	 * 
	 * @return
	 */
	public int get() {
		if (size <= 0)
			throw new RuntimeException("没数据，兄弟");
		end = end.before;
		return end.next.value;
	}

}
