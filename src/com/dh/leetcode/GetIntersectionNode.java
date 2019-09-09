package com.dh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 
 * 
 * 8 [4,1,8,4,5] [5,0,1,8,4,5] 2 3
 * 
 * @author Lenovo
 *
 */
public class GetIntersectionNode {

	

	/**
	 * 将2个单链表反转，然后开始遍历，时间复杂度为2*(n+m)+min(n,m)
	 * 
	 * 
	 * 不能修改数据就，，，mmp
	 * 
	 * 还是一个思想。
	 * 
	 * 注意细节，少了个=号，脑子模拟了好多次都没模拟出来，还是要debug，和细致点。
	 * 
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		List<ListNode> listA = getData(headA);
		List<ListNode> listB = getData(headB);
		if (listA == null || listB == null)
			return null;
		int cursorA = listA.size() - 1, cursorB = listB.size() - 1;
		boolean isUse = true;
		for (;  cursorA >= 0 && cursorB >= 0; cursorA--, cursorB--) {
			if (listA.get(cursorA) != listB.get(cursorB)) {
				isUse = false;
				break;
			}

		}
		if (cursorA == 0 && cursorB == 0 && isUse)
			return listA.get(0);
		if (cursorA == listA.size() - 1) {
			return null;
		}
		return listA.get(cursorA + 1);

	}

	/**
	 * 单链表反转
	 * 
	 * @param head
	 */
	public List<ListNode> getData(ListNode head) {
		if (head == null)
			return null;
		List<ListNode> list = new ArrayList<>();
		list.add(head);
		while (head.next != null) {
			head = head.next;
			list.add(head);
		}
		return list;
	}

	public static void main(String[] arg) {

		GetIntersectionNode getIntersectionNode = new GetIntersectionNode();

		ListNode headA = new ListNode(1);
	
		ListNode headB = new ListNode(2);

		System.out.println(getIntersectionNode.getIntersectionNode(headA, headB));
	}
}
