package com.dh.leetcode4;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 
 * 说明：不允许修改给定的链表。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入：head = [3,2,0,-4], pos = 1 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 
 * 
 * 示例 2：
 * 
 * 输入：head = [1,2], pos = 0 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 
 * 
 * 示例 3：
 * 
 * 输入：head = [1], pos = -1 输出：no cycle 解释：链表中没有环。
 * 
 * 
 *  
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class DetectCycle {

	/**
	 * 这个问题很经典，2个指针一个走一步，一个走2步，然后相交后，快的在从头慢点开始走。
	 * 
	 * 数学分析开始
	 * 
	 * 设定环长度 r,入环点到相交点长度为a,其实点到入环点长度为l
	 * 
	 * s=n1r+l+a 2s=n2r+l+a 2 个公式相减 得到 s=n3r=n1r+l+a 然后求出a的长度 a=n4r-l
	 * 
	 * 我们在让快节点从起始位置出发，按照一步一步走，走到入环点 走了 s1=l; 然后从a出发也走了l 从a走了l,那么就是到了相交点了 因为
	 * a=n4r-l a+l=n4r-l+l=n4r
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {
		if (head == null)
			return null;
		ListNode quick = head.next;
		ListNode slow = head;
		while (quick != null) {
			if (quick == slow)
				break;
			quick = quick.next;
			if (quick == null)
				return null;
			quick = quick.next;
			slow = slow.next;
		}
		if (quick == null)
			return null;
		quick = head;
		slow=slow.next;
		while (true) {
			if (quick == slow)
				return quick;
			quick = quick.next;
			slow = slow.next;

		}

	}

}
