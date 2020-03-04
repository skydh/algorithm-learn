package com.dh.lettcode5;

/**
 * 
 * 请判断一个链表是否为回文链表。
 * 
 * 示例 1:
 * 
 * 输入: 1->2 输出: false 示例 2:
 * 
 * 输入: 1->2->2->1 输出: true 进阶： 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * 
 * @author Lenovo
 *
 */
public class IsPalindrome {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		if (head.next.next == null) {
			if (head.val == head.next.val) {
				return true;
			} else {
				return false;
			}
		}
		ListNode slow = head;
		ListNode quick = head.next;
		ListNode lastHead = null;
		/**
		 * 找到中间节点，思路如下： 快慢节点走，规则如下
		 * 当快节点的next为null时，那么这个链表是偶数个，后半部分的起始节点为，slow.next
		 * 当快节点的next.next为null时，后半分的起始节点为slow.next.next
		 */
		while (quick != null) {
			if (quick.next == null) {
				lastHead = slow.next;
				slow.next = null;
				break;
			}
			if (quick.next.next == null) {
				lastHead = slow.next.next;
				slow.next = null;
				break;
			}

			quick = quick.next.next;
			slow = slow.next;
		}

		/**
		 * 后半部分链表反转
		 */
		ListNode node = lastHead;
		ListNode newHead = lastHead;
		while (node.next != null) {
			ListNode temp = node.next;
			ListNode temp1 = node.next.next;
			temp.next = newHead;
			newHead = temp;
			node.next = temp1;
		}
		while (newHead != null) {
			if (head.val != newHead.val)
				return false;
			head = head.next;
			newHead = newHead.next;
		}
		return true;

	}

}
