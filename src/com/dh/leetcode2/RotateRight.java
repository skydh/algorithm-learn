package com.dh.leetcode2;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 
 * 示例 1:
 * 
 * 输入: 1->2->3->4->5->NULL, k = 2 输出: 4->5->1->2->3->NULL 解释: 向右旋转 1 步:
 * 5->1->2->3->4->NULL 向右旋转 2 步: 4->5->1->2->3->NULL 示例 2:
 * 
 * 输入: 0->1->2->NULL, k = 4 输出: 2->0->1->NULL 解释: 向右旋转 1 步: 2->0->1->NULL 向右旋转 2
 * 步: 1->2->0->NULL 向右旋转 3 步: 0->1->2->NULL 向右旋转 4 步: 2->0->1->NULL
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class RotateRight {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null)
			return head;
		int sum = 1;
		ListNode tempNode = head;
		/**
		 * 找到最后一个节点，同时计算出链表长度
		 */
		while (tempNode.next != null) {
			tempNode = tempNode.next;
			sum++;
		}
		/**
		 * 构成一个环形链表
		 */
		tempNode.next = head;

		/**
		 * 右转i个，等于左转n-i个，那么直接左移就好了
		 */
		int cursor = sum - (k % sum);

		while (cursor > 1) {
			head = head.next;
			cursor--;
		}
		tempNode = head.next;
		head.next = null;
		return tempNode;

	}

}
