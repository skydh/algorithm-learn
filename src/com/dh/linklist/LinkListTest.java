package com.dh.linklist;

public class LinkListTest {

	public static void main(String[] args) {
		merge();

	}

	/**
	 * 单链表测试完毕
	 */
	public static SingleLinkList testSingle() {
		// TODO Auto-generated method stub
		SingleLinkList single = new SingleLinkList();
		single.add(2);
		single.add(21);
		single.add(3, 31);
		single.add(211);
		single.add(2111);
		single.add(21111);
		single.add(211111);
		return single;
	}

	/**
	 * 获取单链表中间节点
	 */
	public static void middleNode() {

	}

	/**
	 * 链表合并
	 */
	public static void merge() {
		SingleLinkList list = testSingle();

		SingleLinkList single = new SingleLinkList();
		single.add(1);
		single.add(34);
		single.add(134);
		single.add(2323223);

		SingleLinkList result = SingleLinkList.merge(list, single);
		result.print();
		
		
		System.out.println(result.getMiddleNode());

	}

	/**
	 * 单链表反转
	 */
	public static void Reversal() {
		SingleLinkList single = testSingle();
		single.Reversal();
		single.print();
	}

	/**
	 * 循环链表测试完毕
	 */
	public static void testCycle() {
		CycleLinkList cycle = new CycleLinkList();
		cycle.addHead(0);
		cycle.deleteHead();
		cycle.addEnd(1);
		cycle.addEnd(112);
		cycle.addEnd(1121);
		cycle.addEnd(11233);
		cycle.addHead(10);
		cycle.deleteHead();
		cycle.deleteEnd();
		cycle.print();
	}

	/**
	 * 双向；链表测试完毕
	 */
	public static void testDouble() {
		DoubleLinkList list = new DoubleLinkList();
		list.add(1);
		list.add(1);
		list.delete(1);
		list.print();
	}
}
