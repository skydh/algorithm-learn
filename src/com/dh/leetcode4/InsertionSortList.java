package com.dh.leetcode4;

/**
 * 对链表进行插入排序。
 * 
 * 
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * 
 *  
 * 
 * 插入排序算法：
 * 
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。 重复直到所有输入数据插入完为止。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class InsertionSortList {

	public ListNode insertionSortList(ListNode head) {
		if(head==null)
			return null;
		ListNode newHead = new ListNode(1);
		newHead.next = head;
		ListNode node = head;
		while (node.next != null) {
			ListNode tempNode = node.next;
			node.next = node.next.next;

			ListNode temp = newHead;
			boolean isRight = false;
			while (temp.next != node.next) {
				if (temp.next.val > tempNode.val) {
					isRight = true;
					ListNode temp1 = temp.next;
					tempNode.next = temp1;
					temp.next = tempNode;
					break;

				}
				temp=temp.next;

			}
			if (!isRight) {
				node.next = tempNode;
				node = tempNode;

			}

		}

		return newHead.next;

	}

	public static void main(String[] args) {
		InsertionSortList la = new InsertionSortList();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node4.next = node2;
		node2.next = node1;
		node1.next = node3;
		la.insertionSortList(node4);
	}

}
