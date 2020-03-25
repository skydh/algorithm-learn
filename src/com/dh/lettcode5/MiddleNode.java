package com.dh.lettcode5;

/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 
 * 如果有两个中间结点，则返回第二个中间结点。
 * 
 * 
 * @author Lenovo
 *
 */
public class MiddleNode {
	public ListNode middleNode(ListNode head) {
		ListNode quick = head;
		ListNode slow = head;
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		while (quick != null) {
			if (quick.next == null)
				return slow;
			if (quick.next.next == null)
				return slow.next;
			quick = quick.next.next;
			slow = slow.next;

		}
		return slow;

	}

}
