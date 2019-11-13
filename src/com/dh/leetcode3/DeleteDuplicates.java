package com.dh.leetcode3;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 
 * 示例 1:
 * 
 * 输入: 1->2->3->3->4->4->5 输出: 1->2->5 示例 2:
 * 
 * 输入: 1->1->1->2->3 输出: 2->3
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class DeleteDuplicates {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;

		/**
		 * 先获取到头结点
		 */
		ListNode node = head;
		ListNode nodeTemp = head;
		boolean isGet = false;
		ListNode newHead = head;
		while (node != null) {
			ListNode temp = node.next;
			if (temp == null) {
				if (!isGet) {
					if (nodeTemp == node) {
						isGet = true;
						newHead = nodeTemp;
					}

				} else {
					if (nodeTemp.next != node) {
						nodeTemp.next = null;
					}
				}
				break;
			}
			if (temp.val == node.val) {
				node = temp;
			} else {
				if (!isGet) {
					/**
					 * 没确定头结点
					 */
					if (nodeTemp == node) {
						isGet = true;
						nodeTemp = node;
						node = temp;
						newHead = nodeTemp;
					} else {
						nodeTemp = temp;
						node = temp;
					}

				} else {
					if (nodeTemp.next == node) {
						nodeTemp = node;
						node = temp;
					} else {
						nodeTemp.next = temp;
						node = temp;

					}

				}
			}

		}
		if (!isGet)
			return null;

		return newHead;

	}

}
