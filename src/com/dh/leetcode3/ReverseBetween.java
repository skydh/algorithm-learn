package com.dh.leetcode3;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 
 * 说明: 1 ≤ m ≤ n ≤ 链表长度。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4 输出: 1->4->3->2->5->NULL
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class ReverseBetween {
	public ListNode reverseBetween(ListNode head, int m, int n) {

		if (m == 1) {
			ListNode node = head;
			ListNode node1 = head.next;
			if (node1 == null)
				return head;
			while (m < n) {
				ListNode temp = node1.next;
				node1.next = node;
				node = node1;
				node1 = temp;
				m++;
			}
			head.next = node1;
			return node;
		} else {
			ListNode newNode = head;
			int cursor = 1;
			while (cursor < m - 1) {
				newNode = newNode.next;
				cursor++;
			}
			

			ListNode node = newNode.next;
			ListNode node1 = newNode.next.next;
			if (node1 == null)
				return head;
			while (m < n) {
				ListNode temp = node1.next;
				node1.next = node;
				node = node1;
				node1 = temp;
				m++;
			}
			
			
			newNode.next.next = node1;
			
			newNode.next=node;
			return head;
		}

	}

}
