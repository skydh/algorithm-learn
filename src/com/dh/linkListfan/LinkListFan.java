package com.dh.linkListfan;

import java.util.ArrayList;
import java.util.List;

/**
 * 单链表反装
 */
public class LinkListFan {
	public static ListNode reverseList(ListNode head) {
		ListNode temp = head;
		if(temp==null)
		{
			return null;
		}
		
		List<ListNode> list = new ArrayList<ListNode>();

		list.add(head);

		while (temp.next != null) {

			temp = temp.next;
			list.add(temp);

		}
		for (int i = 0; i < list.size(); i++) {
			list.get(i).next = null;

		}
		int index = list.size() - 2;

		ListNode newHead = temp;
		ListNode nodeTemp = temp;
		while (index >= 0) {
			nodeTemp.next = list.get(index);
			nodeTemp = list.get(index);
			index--;

		}

		return newHead;

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
		ListNode5.next = null;
		ListNode sss = reverseList(ListNode1);
		do {
			System.out.println(sss.val);
			sss = sss.next;
		} while (sss != null);

	}
}