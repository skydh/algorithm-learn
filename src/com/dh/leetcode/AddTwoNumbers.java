package com.dh.leetcode;

/**
 * #2
 * 
 * @author Lenovo
 *
 */
public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode head = null;
		boolean isJin = false;
		int temp = l1.val + l2.val;
		if (temp >= 10) {
			head = new ListNode(temp % 10);
			isJin = true;
		} else {
			head = new ListNode(temp);
			isJin = false;
		}
		l1 = l1.next;
		l2 = l2.next;
		ListNode node = head;

		while (l1 != null && l2 != null) {
			int newTemp = l1.val + l2.val;
			ListNode newNode = null;
			if (isJin)
				newTemp = newTemp + 1;
			if (newTemp >= 10) {
				newNode = new ListNode(newTemp % 10);
				isJin = true;
			} else {
				newNode = new ListNode(newTemp);
				isJin = false;
			}
			node.next = newNode;
			node = node.next;
			l1 = l1.next;
			l2 = l2.next;

		}
		while (l1 != null) {

			if (isJin)
				l1.val = l1.val + 1;
			if (l1.val >= 10) {
				l1.val = l1.val % 10;
				isJin = true;
			} else {
				l1.val = l1.val;
				isJin = false;
			}
			node.next = l1;
			node = node.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			if (isJin)
				l2.val = l2.val + 1;
			if (l2.val >= 10) {
				l2.val = l2.val % 10;
				isJin = true;
			} else {
				l2.val = l2.val;
				isJin = false;
			}
			node.next = l2;
			node = node.next;
			l2 = l2.next;
		}

		if (isJin) {
			ListNode newNode = new ListNode(1);
			node.next = newNode;
			node = node.next;
		}
		return head;

	}

	public static void main(String[] arg) {
		AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

		ListNode newNode1 = new ListNode(1);

		ListNode newNode2 = new ListNode(8);
		// ListNode newNode3 = new ListNode(3);

		newNode1.next = newNode2;
		// newNode2.next = newNode3;
		ListNode newNode4 = new ListNode(0);
		// ListNode newNode5 = new ListNode(6);
		// ListNode newNode6 = new ListNode(4);
		// newNode4.next = newNode5;
		// newNode5.next = newNode6;

		addTwoNumbers.addTwoNumbers(newNode1, newNode4);

	}
}
