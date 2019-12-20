package com.dh.leetcode4;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 示例 1:
 * 
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 示例 2:
 * 
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class ReorderList {

	/**
	 * 还有一个办法找到中间节点，然后翻转，在按照顺序添加进去。我只写写翻转。
	 * 
	 * @param head
	 */
	public void reorderList(ListNode head) {
		if (head == null)
			return;
		doHelper1(head);
	}

	public ListNode reverseList(ListNode head) {
		if (head == null)
			return null;
		ListNode node = head.next;
		head.next = null;
		while (node != null) {
			ListNode temp = node;
			ListNode tempNext = node.next;
			temp.next = head;
			head = temp;
			node = tempNext;

		}

		return head;

	}

	/**
	 * 最简单的方法，存起来，然后遍历
	 */
	public void doHelper1(ListNode head) {
		ListNode node = head.next;
		List<ListNode> list = new LinkedList<>();
		while (node != null) {
			ListNode temp = node;
			node = node.next;
			list.add(temp);
			temp.next = null;

		}
		node = head;
		while (list.size() > 0) {
			node.next = list.remove(list.size() - 1);
			node = node.next;
			if (list.size() > 0)
				node.next = list.remove(0);
		}

	}

}
