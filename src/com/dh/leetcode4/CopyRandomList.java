package com.dh.leetcode4;

import java.util.HashMap;

/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 
 * 要求返回这个链表的深拷贝。 
 * 
 *  
 * 
 * 示例：
 * 
 * 
 * 
 * 输入： {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},
 * "random":{"$ref":"2"},"val":1}
 * 
 * 解释： 节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。 节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。  
 * 
 * 提示：
 * 
 * 你必须返回给定头的拷贝作为对克隆列表的引用。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class CopyRandomList {
	class Node {
		public int val;
		public Node next;
		public Node random;

		public Node() {
		}

		public Node(int _val, Node _next, Node _random) {
			val = _val;
			next = _next;
			random = _random;
		}
	};

	public Node copyRandomList(Node head) {
		HashMap<Node, Node> map = new HashMap<>();
		if (head == null)
			return null;

		Node newNode = new Node();
		newNode.val = head.val;

		map.put(head, newNode);

		Node tempNode = newNode;
		Node node = head.next;

		while (node != null) {
			Node nextNode = new Node();
			nextNode.val = node.val;
			tempNode.next = nextNode;
			map.put(node, nextNode);
			tempNode = nextNode;
			node = node.next;
		}

		tempNode = newNode;
		node = head;
		while (node != null) {
			tempNode.random = map.get(node.random);
			tempNode = tempNode.next;
			node = node.next;

		}

		return newNode;

	}

}
