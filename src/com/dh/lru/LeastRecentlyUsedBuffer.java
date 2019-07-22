package com.dh.lru;

/**
 * 基于lru缓存淘汰算法 实现方案:根据传递的参数，设定链表大小，新加入的数据放到链表头部。被命中的数据也要加入到头部，链表满了，就删除尾部数据。
 * 基于思想： 如果数据最近被访问过，那么将来被访问的几率也更高”
 * 
 * 
 * ps:为了方便，数据全部都是正整数，因此-1作为首节点。
 * 
 * key重复的节点按照hashmap的思想，选择覆盖。
 * 
 * @author Lenovo
 *
 */
public class LeastRecentlyUsedBuffer {

	private int size;

	private int currentSize;

	private Node head;

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

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

	}

	public LeastRecentlyUsedBuffer(int size) {
		if (size < 1)
			throw new RuntimeException("容积不能小于0");
		this.size = size;
		head = new Node(-1, -1);
	}

	/**
	 * 查询缓存是否存在值，若存在则把值丢到头部
	 * 
	 * @param key
	 * @return
	 */
	public int getKey(int key) {
		Node temp = head;
		while (temp.next != null) {
			if (temp.next.key == key) {
				Node tempNode = temp.next;
				temp.next = temp.next.next;
				Node nextHead = head.next;
				head.next = tempNode;
				tempNode.next = nextHead;
				return tempNode.value;
			}
			temp = temp.next;
		}
		return -1;
	}

	/**
	 * 放值进去，若满了，则溢出最后一个元素。 放的这个值的key若是已存在，那么覆盖且放在头部（ps去掉了，每次都要遍历整个链表，效率低下）
	 * 
	 * @param key
	 * @param value
	 */
	public void put(int key, int value) {
		Node node = new Node(key, value);
		node.next = head.next;
		head.next = node;

		if (currentSize == size) {
			Node temp = head;
			/**
			 * 因为刚刚put过了值进去，因此temp.next一定不为null
			 */
			while (temp.next.next != null) {
				temp = temp.next;
			}
			temp.next = null;

		} else
			currentSize++;

	}

	/**
	 * 移除某个值
	 * 
	 * @param key
	 */
	public void remove(int key) {
		Node temp = head;
		/**
		 * 因为刚刚put过了值进去，因此temp.next一定不为null
		 */
		while (temp.next != null) {
			if (temp.next.key == key) {
				temp.next = temp.next.next;
				currentSize--;
			}
			temp = temp.next;
		}
	}

}
