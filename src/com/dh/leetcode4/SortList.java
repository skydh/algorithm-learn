package com.dh.leetcode4;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * 
 * 示例 1:
 * 
 * 输入: 4->2->1->3 输出: 1->2->3->4 示例 2:
 * 
 * 输入: -1->5->3->4->0 输出: -1->0->3->4->5
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class SortList {

	public ListNode sortList(ListNode head) {
		if (head == null)
			return null;
		return doHelper(head);

	}

	public ListNode doHelper(ListNode node) {
		if (node.next == null)
			return node;
		ListNode quick = node.next;
		ListNode slow = node;
		while (quick != null) {
			if (quick.next != null)
				quick = quick.next.next;
			else
				break;
			slow = slow.next;
		}
		ListNode temp = slow.next;
		slow.next = null;
		ListNode node1 = doHelper(node);
		ListNode node2 = doHelper(temp);

		return merge(node1, node2);

	}

	public ListNode merge(ListNode node1, ListNode node2) {
		ListNode head = null;
		if (node1.val < node2.val) {
			head = node1;
			node1 = node1.next;
		} else {
			head = node2;
			node2 = node2.next;
		}
		ListNode node = head;
		while (node1 != null && node2 != null) {
			if (node1.val < node2.val) {
				node.next = node1;
				node1 = node1.next;

			} else {
				node.next = node2;
				node2 = node2.next;
			}
			node = node.next;
		}
		while (node1 != null) {
			node.next = node1;
			node1 = node1.next;
			node = node.next;

		}
		while (node2 != null) {
			node.next = node2;
			node2 = node2.next;
			node = node.next;
		}

		return head;

	}

	public static void main(String[] args) {
		SortList la = new SortList();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node4.next = node2;
		node2.next = node1;
		node1.next = node3;
		la.sortList(node4);
	}
}
