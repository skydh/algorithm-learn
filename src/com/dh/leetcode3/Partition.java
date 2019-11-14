package com.dh.leetcode3;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 
 * 示例:
 * 
 * 输入: head = 1->4->3->2->5->2, x = 3 输出: 1->2->2->4->3->5
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class Partition {

	/**
	 * 这个题目简单的，我看了好几遍，怀疑我是否没看懂题目
	 * 
	 * @param head
	 * @param x
	 * @return
	 */
	public ListNode partition(ListNode head, int x) {
		ListNode befor = new ListNode(0);
		ListNode after = new ListNode(0);

		ListNode beforNode = befor;
		ListNode afterNode = after;

		ListNode node = head;
		while (node != null) {
			if (node.val < x) {
				beforNode.next = node;
				beforNode = node;

			} else {
				afterNode.next = node;
				afterNode = node;

			}
			node=node.next;

		}
		beforNode.next = after.next;
		afterNode.next=null;

		return befor.next;

	}

}
