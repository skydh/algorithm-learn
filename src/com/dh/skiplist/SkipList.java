package com.dh.skiplist;

import java.util.Random;

/**
 * 跳跃表 采用一个哨兵结点作为前置结点
 * 
 * @author Lenovo
 *
 */
public class SkipList {
	/**
	 * 作为类成员变量供大家使用
	 */
	private static Random r = new Random();

	private Node head = new Node();
	private int level = 1;

	@SuppressWarnings("unused")
	private Node find(int value) {
		Node p = head;
		/**
		 * 从最上层开始寻找，一层层遍历，直到最后一层，停止循环。然后内部循环停止条件是找到的节点的下个节点不是尾部节点，
		 * 且该节点的下个节点的值小于所查找的值， 记住是必须小于，等于也不行哦。最后如果这个节点存在，那么p节点就是这个节点的上个节点。
		 * 因为它的下个节点必然大于等于value
		 */
		for (int i = level - 1; level >= 0; i--) {
			while (p.next[i] != null && p.next[i].data < value) {
				p = p.next[i];
			}
		}
		if (p.next[0] != null && p.next[0].data == value) {
			return p.next[0];
		}
		return null;
	}

	public void insert(int value) {

		/**
		 * 获取层数
		 */
		int levelCount = randomLevel();
		/**
		 * 创建新节点
		 */
		Node newNode = new Node();
		newNode.data = value;
		/**
		 * 设定这个节点上每层节点的上个节点的node
		 */
		Node[] update = new Node[levelCount];
		for (int i = 0; i < levelCount; i++) {
			update[i] = head;
		}
		Node p = head;
		/**
		 * 从顶层节点往下遍历，一层层找到 上个 节点
		 */
		for (int i = levelCount - 1; levelCount >= 0; i--) {
			while (p.next[i] != null && p.next[i].data < value) {
				p = p.next[i];
			}
			update[i] = p;
		}
		/**
		 * 好了，把新节点插进去
		 */
		for (int i = 0; i < levelCount; ++i) {
			newNode.next[i] = update[i].next[i];
			update[i].next[i] = newNode;
		}

		/**
		 * 跟新层数
		 */
		if (levelCount < level)
			levelCount = level;

	}

	public void delete(int value) {

		/**
		 * 设定这个节点上每层节点的上个节点的node
		 */
		Node[] update = new Node[level];

		Node p = head;
		/**
		 * 从顶层节点往下遍历，一层层找到上个节点
		 */
		for (int i = level - 1; level >= 0; i--) {
			while (p.next[i] != null && p.next[i].data < value) {
				p = p.next[i];
			}
			update[i] = p;
		}
		/**
		 * 开始删除
		 */
		if (p.next[0] != null && p.next[0].data == value) {
			for (int i = level - 1; i >= 0; --i) {
				if (update[i].next[i] != null && update[i].next[i].data == value) {
					update[i].next[i] = update[i].next[i].next[i];
				}
			}
		}

	}

	/**
	 * 这是一个随机函数，用来获取新插入的节点是第几层。
	 * 
	 * @return
	 */
	private int randomLevel() {

		int level = 1;
		for (int i = 1; i < 16; ++i) {
			if (r.nextInt() % 2 == 1) {
				level++;
			}
		}
		return level;
	}

}
