package com.dh.leetcode3;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 
 * 示例 1:
 * 
 * 输入: 1->1->2 输出: 1->2 示例 2:
 * 
 * 输入: 1->1->2->3->3 输出: 1->2->3
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class DeleteDuplicatesEasy {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		ListNode node = head;
		while (node.next != null) {
			ListNode temp = node.next;
			if (node.val == temp.val)
				node.next = temp.next;
			else
				node = node.next;

		}
		return head;

	}

}
