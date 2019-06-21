package com.dh.linkListfan;

/**
 * 判断链表是否有环
 * 
 * @author Lenovo
 *
 */
public class LinkListHuan {

	public static boolean hasCycle(ListNode head) {

		if (head == null || head.next==null || head.next.next==null) {
			return false;
		}

		ListNode slow = head;
		ListNode fast = head;
		while (slow != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}

		return false;

	}

	public static void main(String[] args) {
		ListNode ListNode1 = new ListNode(1);
		ListNode ListNode2 = new ListNode(2);
		ListNode ListNode3 = new ListNode(3);
		ListNode ListNode4 = new ListNode(4);
		ListNode ListNode5 = new ListNode(5);

		ListNode1.next = ListNode2;
		ListNode2.next = ListNode3;
		ListNode3.next = ListNode4;
		ListNode4.next = ListNode5;
		ListNode5.next = ListNode2;
		System.out.println(hasCycle(ListNode1));

	}

}
