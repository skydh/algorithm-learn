package com.dh.leetcode2;

/**
 * 24 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 *  
 * 
 * 示例:
 * 
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class SwapPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		/**
		 * 首先交换前面2个
		 */
		ListNode next = head.next;
		head.next = next.next;
		next.next = head;

		ListNode left = next;
		ListNode right = next.next;
		while (right != null) {
			ListNode newLeft = left.next.next;
			if (newLeft == null) {
				break;
			}
			ListNode newRight = right.next.next;
			if (newRight == null) {
				break;
			}
			swap(right, newLeft, newRight);
			left = newRight;
			right = newLeft;

		}

		return next;

	}

	public void swap(ListNode right, ListNode newLeft, ListNode newRight) {
		newLeft.next = newRight.next;
		newRight.next = newLeft;
		right.next = newRight;

	}
}
