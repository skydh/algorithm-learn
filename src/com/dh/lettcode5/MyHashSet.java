package com.dh.lettcode5;

/**
 * 不使用任何内建的哈希表库设计一个哈希集合
 * 
 * 具体地说，你的设计应该包含以下的功能
 * 
 * add(value)：向哈希集合中插入一个值。 contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 * 
 * 示例:
 * 
 * MyHashSet hashSet = new MyHashSet(); hashSet.add(1);         hashSet.add(2);
 *         hashSet.contains(1);    // 返回 true hashSet.contains(3);    // 返回
 * false (未找到) hashSet.add(2);           hashSet.contains(2);    // 返回 true
 * hashSet.remove(2);           hashSet.contains(2);    // 返回 false (已经被删除)
 * 
 * 注意：
 * 
 * 所有的值都在 [0, 1000000]的范围内。 操作的总数目在[1, 10000]范围内。 不要使用内建的哈希集合库。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/design-hashset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class MyHashSet {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	ListNode[] table;
	int length;
	int size;

	/**
	 * 定义大于0.75，扩容2倍，小于0.1缩容2倍
	 */

	/** Initialize your data structure here. */
	public MyHashSet() {
		table = new ListNode[8];
		length = 8;
		size = 0;
	}

	public void add(int key) {
		int hash = key % length;
		if (table[hash] == null) {
			table[hash] = new ListNode(key);
			size++;
		} else {
			ListNode node = table[hash];

			boolean isSame = false;
			if (node.val == key) {
				isSame = true;
			} else {
				while (node.next != null) {
					if (node.next.val == key) {
						isSame = true;
						break;
					}
					node = node.next;
				}
			}
			if (!isSame) {
				node.next = new ListNode(key);
				size++;
			}
		}
		resize();
	}

	public void resize() {
		double rate = Double.valueOf(size) / Double.valueOf(length);
		ListNode[] newTable = null;
		if (rate > 0.75) {
			newTable = new ListNode[length * 2];
			length = length * 2;
		}
		if (rate < 0.1) {
			newTable = new ListNode[length / 2];
			length = length / 2;
		}

		if (rate > 0.75 || rate < 0.1) {
			for (int i = 0; i < table.length; i++) {
				ListNode node = table[i];
				while (node != null) {
					int hash = node.val % length;
					if (newTable[hash] == null) {
						newTable[hash] = new ListNode(node.val);
					} else {
						ListNode temp = newTable[hash];
						while (temp.next != null) {
							temp = temp.next;
						}
						temp.next = new ListNode(node.val);

					}
					node = node.next;
				}
			}
			table = newTable;
		}

	}

	public void remove(int key) {
		int hash = key % length;
		if (table[hash] == null) {
			return;
		} else {
			ListNode node = table[hash];

			if (node.val == key) {
				table[hash] = table[hash].next;
				size--;
			} else {
				while (node.next != null) {
					if (node.next.val == key) {
						node.next = node.next.next;
						size--;
						return;
					}
					node = node.next;
				}
			}

		}
		resize();

	}

	/** Returns true if this set contains the specified element */
	public boolean contains(int key) {
		int hash = key % length;
		if (table[hash] == null) {
			return false;
		} else {
			ListNode node = table[hash];

			while (node != null) {
				if (node.val == key) {
					return true;
				}
				node = node.next;
			}

		}

		return false;

	}

	public static void main(String[] args) {

		MyHashSet set = new MyHashSet();
		set.add(1);
		set.add(2);
		System.out.println(set.contains(1));
		System.out.println(set.contains(3));
		set.add(2);
		System.out.println(set.contains(2));
		set.remove(2);
		System.out.println(set.contains(2));
	}
}
