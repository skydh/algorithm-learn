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
	 * 返回哨兵节点
	 * 
	 * @return
	 */
	public LinkListNode getHead() {
		return head;
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

	/**
	 * 返回size
	 * 
	 * @return
	 */
	public int getSize() {
		return size;
	}

	/**
	 * 单链表反转 很简单的思路，从头开始，一个个转向，记得让第一个元素指向null,以及head节点指向最后一个节点
	 */
	public void Reversal() {
		if (size < 2)
			return;

		LinkListNode frontNode = head.next;
		LinkListNode behindNode = frontNode.next;
		frontNode.next = null;
		while (behindNode != null) {
			LinkListNode temp = behindNode.next;
			behindNode.next = frontNode;
			frontNode = behindNode;
			behindNode = temp;
		}
		head.next = frontNode;

	}

	/**
	 * 2个有序链表的合并,本来想写第一个链表合并第二个链表，但是想了下，为了可扩展性，还是创建一个新的链表
	 */
	public static SingleLinkList merge(SingleLinkList listM, SingleLinkList listN) {
		SingleLinkList result = new SingleLinkList();
		LinkListNode nodeM = listM.getHead().next;
		LinkListNode nodeN = listN.getHead().next;
		while (nodeM != null && nodeN != null) {
			if (nodeM.value < nodeN.value) {
				result.add(nodeM.value);
				nodeM = nodeM.next;
			} else {
				result.add(nodeN.value);
				nodeN = nodeN.next;

			}
		}
		while (nodeM != null) {
			result.add(nodeM.value);
			nodeM = nodeM.next;
		}
		while (nodeN != null) {
			result.add(nodeN.value);
			nodeN = nodeN.next;
		}

		return result;

	}

	/**
	 * 获取中间节点，很纠结 我 定义的链表有个参数就是size.哈哈哈哈 但是不考虑这个点。思索下。 如果是偶数个，比如，2,4,6,8
	 * 那么中间节点分别是1,2,3,4。如果是奇数，那么更好算了。5 则是3,7则是4，3则是2。
	 * 
	 * 我们设置快慢2个节点
	 */
	public int getMiddleNode() {
		LinkListNode slowNode = head.next;
		LinkListNode quickNode = head.next.next;
		while (quickNode != null) {
			if (quickNode.next == null)
				break;
			slowNode = slowNode.next;
			quickNode = quickNode.next.next;
		}
		return slowNode.value;
	}

	/**
	 * 打印
	 */
	public void print() {
		LinkListNode current = head;
		while (current.next != null) {
			System.out.println(current.next.value);
			current = current.next;
		}

	}

}
