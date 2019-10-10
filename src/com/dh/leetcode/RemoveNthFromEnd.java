package com.dh.leetcode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 
 * 示例：
 * 
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5. 说明：
 * 
 * 给定的 n 保证是有效的。
 * 
 * 进阶：
 * 
 * 你能尝试使用一趟扫描实现吗？
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class RemoveNthFromEnd {
	/**
	 * 先遍历一遍，算出链表多长，然后，在遍历一次。
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head.next == null)
			return null;
		int sum = 0;
		ListNode temp = head;
		while (temp != null) {
			sum++;
			temp = temp.next;
		}

		if (sum == n) {
			return head.next;
		}
		int target = sum - n;
		int cursor = 1;
		temp = head;
		while (cursor < target) {
			temp = temp.next;
			cursor++;
		}

		ListNode newTemp = temp.next.next;
		temp.next = newTemp;
		return head;

	}

	/**
	 * 遍历一次。很有意思，看了题解。再写一次
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd1(ListNode head, int n) {
		if (head.next == null)
			return null;

		ListNode end = head;
		ListNode start = head;
		int cursor = 0;
		while (end.next != null) {
			if (cursor >= n) {
				start = start.next;
			}
			end = end.next;
			cursor++;
		}
		if (cursor < n)
			return head.next;
		start.next = start.next.next;
		return head;

	}
}
