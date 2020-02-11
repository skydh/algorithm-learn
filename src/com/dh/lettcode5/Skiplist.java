package com.dh.lettcode5;

/**
 * 不使用任何库函数，设计一个跳表。
 * 
 * 跳表是在 O(log(n))
 * 时间内完成增加、删除、搜索操作的数据结构。跳表相比于树堆与红黑树，其功能与性能相当，并且跳表的代码长度相较下更短，其设计思想与链表相似。
 * 
 * 例如，一个跳表包含 [30, 40, 50, 60, 70, 90]，然后增加 80、45 到跳表中，以下图的方式操作：
 * 
 * 
 * Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons
 * 
 * 跳表中有很多层，每一层是一个短的链表。在第一层的作用下，增加、删除和搜索操作的时间复杂度不超过 O(n)。跳表的每一个操作的平均时间复杂度是
 * O(log(n))，空间复杂度是 O(n)。
 * 
 * 在本题中，你的设计应该要包含这些函数：
 * 
 * bool search(int target) : 返回target是否存在于跳表中。 void add(int num): 插入一个元素到跳表。
 * bool erase(int num): 在跳表中删除一个值，如果 num 不存在，直接返回false. 如果存在多个 num ，删除其中任意一个即可。
 * 了解更多 : https://en.wikipedia.org/wiki/Skip_list
 * 
 * 注意，跳表中可能存在多个相同的值，你的代码需要处理这种情况。
 * 
 * 样例:
 * 
 * Skiplist skiplist = new Skiplist();
 * 
 * skiplist.add(1); skiplist.add(2); skiplist.add(3); skiplist.search(0); // 返回
 * false skiplist.add(4); skiplist.search(1); // 返回 true skiplist.erase(0); //
 * 返回 false，0 不在跳表中 skiplist.erase(1); // 返回 true skiplist.search(1); // 返回
 * false，1 已被擦除 约束条件:
 * 
 * 0 <= num, target <= 20000 最多调用 50000 次 search, add, 以及 erase操作。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/design-skiplist
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class Skiplist {
	/**
	 * 参考redis和极客timedemo
	 * 
	 * @author Lenovo
	 *
	 */
	public SkipNode head;
	public int maxLevel;

	class SkipNode {
		public int value;
		public SkipNode[] next;
		public int level;

		public SkipNode(int maxLevel) {
			next = new SkipNode[maxLevel];
		}
	}

	public Skiplist() {
		this(20);
	}

	public Skiplist(int maxLevel) {
		this.maxLevel = maxLevel;
		head = new SkipNode(maxLevel);

	}

	public boolean search(int target) {
		SkipNode node = head;
		for (int i = maxLevel - 1; i >= 0; i--) {
			while (node.next[i] != null && node.next[i].value < target) {
				node = node.next[i];
			}
			if (node.next[i] != null && node.next[i].value == target) {
				return true;
			}
			
		}

		return false;

	}

	public void add(int num) {
		int level = (int) (Math.random() * maxLevel - 1) + 1;
		SkipNode newNode = new SkipNode(level);
		SkipNode[] next = new SkipNode[level];
		newNode.value = num;
		SkipNode node = head;
		for (int i = maxLevel - 1; i >= 0; i--) {
			while (node.next[i] != null && node.next[i].value < num)
				node = node.next[i];
			if (i < level)
				next[i] = node;
		}
		for (int i = 0; i < level; ++i) {
			newNode.next[i] = next[i].next[i];
			next[i].next[i] = newNode;
		}
	}

	public boolean erase(int num) {
		boolean isDelete = false;

		SkipNode node = head;
		for (int i = maxLevel - 1; i >= 0; i--) {
			while (node.next[i] != null && node.next[i].value < num)
				node = node.next[i];
			if (node.next[i] != null && node.next[i].value == num) {
				node.next[i] = node.next[i].next[i];
				isDelete = true;
			}
		}

		return isDelete;

	}

	public static void main(String[] args) {

		Skiplist skip = new Skiplist();
		skip.add(1);
		skip.add(2);
		skip.add(3);
		skip.add(4);
		System.out.println(skip.erase(1));
		System.out.println(skip.search(1));
	}

}