package com.dh.leetcode2;

/**
 * 25 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * 
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 
 * 示例 :
 * 
 * 给定这个链表：1->2->3->4->5
 * 
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 
 * 说明 :
 * 
 * 你的算法只能使用常数的额外空间。 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class ReverseKGroup {
	class ListNodeHelper {
		ListNode head;
		ListNode end;
		boolean isSwap;

		public ListNodeHelper(ListNode head, ListNode end, boolean isSwap) {
			this.head = head;
			this.end = end;
			this.isSwap = isSwap;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (k == 1)
			return head;
		ListNodeHelper helper = doHelper(head, k);
		ListNode newHead = helper.head;
		if (!helper.isSwap)
			return head;

		while (true) {
			ListNode end = helper.end;
			helper = doHelper(helper.end.next, k);
			if (!helper.isSwap)
				break;
			end.next = helper.head;

		}

		return newHead;

	}

	/**
	 * 单链表反转，方案为头结点不变，然后一次次遍历。当然先要判断长度是否够了k
	 * 
	 * @param node
	 * @param k
	 * @return
	 */
	public ListNodeHelper doHelper(ListNode node, int k) {
		int cursor = 1;
		ListNode temp = node;
		while (temp != null && cursor < k) {
			temp = temp.next;
			if (temp != null)
				cursor++;
		}
		if (cursor < k)
			return new ListNodeHelper(node, temp, false);
		ListNode newTemp = node;
		while (newTemp != temp) {
			ListNode nodeNew = newTemp;
			newTemp = newTemp.next;

			nodeNew.next = temp.next;
			temp.next = nodeNew;
		}
		return new ListNodeHelper(temp, node, true);

	}
}
