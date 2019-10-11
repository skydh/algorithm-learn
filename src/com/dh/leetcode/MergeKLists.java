package com.dh.leetcode;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 
 * 示例:
 * 
 * 输入: [   1->4->5,   1->3->4,   2->6 ] 输出: 1->1->2->3->4->4->5->6
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeKLists {
	/**
	 * 分而治之，然后2个，2个合并。
	 * 
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;

		return merge(0, lists.length - 1, lists);
	}

	public ListNode merge(int start, int end, ListNode[] lists) {
		if (end - start == 1)
			return mergeTwoLists(lists[start], lists[end]);
		if (end - start == 0)
			return lists[end];
		int mid = (start + end) / 2;
		return mergeTwoLists(merge(start, mid, lists), merge(mid + 1, end, lists));

	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode head = null;
		if (l1.val < l2.val) {
			head = l1;
			l1 = l1.next;
		} else {
			head = l2;
			l2 = l2.next;
		}

		ListNode temp = head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				temp.next = l1;
				l1 = l1.next;

			} else {
				temp.next = l2;
				l2 = l2.next;

			}
			temp = temp.next;
		}
		while (l1 != null) {
			temp.next = l1;
			l1 = l1.next;
			temp = temp.next;

		}
		while (l2 != null) {
			temp.next = l2;
			l2 = l2.next;
			temp = temp.next;
		}

		return head;

	}

}
