package com.dh.linklist;

public class LinkListTest {

	public static void main(String[] args) {
		testDouble();
	}

	/**
	 * 单链表测试完毕
	 */
	public static void testSingle() {
		// TODO Auto-generated method stub
		SingleLinkList single = new SingleLinkList();
		single.add(2);
		single.add(21);
		single.add(3, 31);

		single.add(211);
		single.add(2111);
		single.add(21111);
		single.add(211111);
		single.print();

	}

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

	public static void testDouble() {
		DoubleLinkList list = new DoubleLinkList();
		
		list.add(1);
		list.add(1);
		
		list.delete(1);

		list.print();
	}
}
