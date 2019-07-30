package com.dh.search.tree.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉查找树，也叫做二叉搜索树，支持快速插入，删除数据。 其规则如下：任意一个节点，左子树的每个节点都小于这个节点，右子树的节点都大于这个节点的值。
 * 至于等于，直接覆盖 如是节点是对象类型，我们，我们根据某个key值判断，对象不一样，我们可以让节点维持一个链表处理。
 * 
 * 
 * 只要实现了基于数字的，链表的可以根据此优化修改即可。
 * 
 * 
 * 现在我们说出，查找二叉树相对于散列表的优势，这个是核心。 1.现对于散列表，可以高效的顺序输出数据 2.散列表不稳定，比如扩容，散列冲突，等
 * 
 * 
 * 为了方便，我们约定，所有的value不能为-1
 * 
 * @author Lenovo
 *
 */
public class BinaryTree {

	/**
	 * 定义的一个简单的二叉树节点
	 * 
	 * @author Lenovo
	 *
	 */
	public class BinaryTreeNode {
		public int key;
		public int value;
		public BinaryTreeNode left;
		public BinaryTreeNode right;
		public BinaryTreeNode parents;

		public BinaryTreeNode(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	/**
	 * 纠结了一下，还是不定义root节点了，直接初始化了，第一个节点就是那啥就行
	 */
	public BinaryTreeNode root;

	public BinaryTree() {

	}

	/**
	 * 查找
	 * 
	 * @param key
	 * @return
	 */
	public int search(int key) {
		if (root == null) {
			return -1;
		}
		BinaryTreeNode node = root;
		while (node != null) {
			if (node.key < key)
				node = node.right;
			else if (node.key == key)
				return node.value;
			else
				node = node.left;
		}
		return -1;
	}

	/**
	 * 插入
	 * 
	 * @param key
	 * @param value
	 */
	public void insert(int key, int value) {
		if (root == null) {
			root = new BinaryTreeNode(key, value);
			return;
		}
		BinaryTreeNode node = root;
		while (node != null) {
			if (node.key < key) {
				if (node.right != null)
					node = node.right;
				else {
					BinaryTreeNode newNode = new BinaryTreeNode(key, value);
					node.right = newNode;
					newNode.parents = node;
				}

			} else if (node.key == key) {
				/**
				 * 覆盖处理，以后若是对象，对象节点可以维持一个链表，再加一个横向指针
				 */
				node.value = value;
				return;

			} else {
				if (node.left != null)
					node = node.left;
				else {
					BinaryTreeNode newNode = new BinaryTreeNode(key, value);
					node.left = newNode;
					newNode.parents = node;
				}
			}

		}

	}

	/**
	 * 删除较为复杂，第一位子节点，直接让上级节点指向为null, 第二，有一个子节点，那么直接让，自节点接上来。 第三，有2个子节点，
	 * 但是我们需要上层节点的信息
	 * 
	 * @param key
	 */
	public void delete(int key) {

		if (root == null) {
			return;
		}
		BinaryTreeNode node = root;

		while (node != null) {

			if (node.key < key)
				node = node.right;
			else if (node.key == key) {
				/**
				 * 按照网上的建议，找到其节点的右节点的最小节点，或者左节点的最大节点，替换这个节点。 这边方案是找左边最大节点
				 */
				if (node.left != null && node.right != null) {
					BinaryTreeNode tempNode = node.left;
					/**
					 * 找到最大左边最大节点
					 */
					while (tempNode.right != null) {
						tempNode = tempNode.right;
					}
					/**
					 * 找到最大节点父节点
					 */
					BinaryTreeNode ftempNode = tempNode.parents;

					/**
					 * 让父节点的右子指向最大节点的左子，现在相当于删除了这个节点了
					 * 这里这个判断是为了防止左边最大节点的父节点就是被删除节点
					 */
					if (ftempNode.right == tempNode) {
						ftempNode.right = tempNode.left;
						tempNode.left.parents = ftempNode;
					}

					/**
					 * 替代待删除节点的位置
					 */
					tempNode.right = node.right;
					node.right.parents = tempNode;
					/**
					 * 防止其左节点就是自己本身，形成死循环
					 */
					if (node.left != tempNode) {
						tempNode.left = node.left;
						node.left.parents = tempNode;
					}

					if (root != node) {
						BinaryTreeNode fnode = node.parents;
						tempNode.parents = fnode;
						if (fnode.right == node) {
							fnode.right = tempNode;
						} else {
							fnode.left = tempNode;
						}
					} else {
						root = tempNode;
						tempNode.parents = null;
					}

					/**
					 * 彻底删除节点
					 */
					node.parents = null;
					node.right = null;
					node.left = null;
				} else {
					if (node == root) {
						if (node.left != null) {
							root = node.left;
							node.left.parents = null;
						} else {
							root = node.right;
							node.right.parents = null;
						}
						return;
					}
					BinaryTreeNode tempNode = null;
					if (node.left != null) {
						tempNode = node.left;
					} else if (node.right != null) {
						tempNode = node.right;
					}
					BinaryTreeNode fnode = node.parents;
					if (tempNode != null)
						tempNode.parents = fnode;

					if (fnode.right == node) {
						fnode.right = tempNode;
					} else {
						fnode.left = tempNode;
					}
				}
				return;
			}

			else
				node = node.left;
		}
	}

	/**
	 * 查询节点的父节点
	 * 
	 * @param key
	 * @return
	 */
	public BinaryTreeNode findPrefixNode(int key) {
		if (root == null) {
			return null;
		}
		BinaryTreeNode node = root;
		while (node != null) {
			if (node.key < key)
				node = node.right;
			else if (node.key == key)
				return node.parents;
			else
				node = node.left;
		}
		return null;
	}

	/**
	 * 前序 本->左->右
	 * 
	 * 这个玩意递归很简单
	 * 
	 * @return
	 */
	public List<Integer> frontSort() {
		List<Integer> list = new ArrayList<>();
		addFrontNode(root, list);
		return list;
	}

	public void addFrontNode(BinaryTreeNode node, List<Integer> list) {
		list.add(node.value);
		if (node.left != null)
			addFrontNode(node.left, list);
		if (node.right != null)
			addFrontNode(node.right, list);
	}

	/**
	 * 中序 左->本->右
	 * 
	 * @return
	 */
	public List<Integer> mediumSort() {
		List<Integer> list = new ArrayList<>();
		addMediumNode(root, list);
		return list;
	}

	public void addMediumNode(BinaryTreeNode node, List<Integer> list) {
		if (node.left != null)
			addMediumNode(node.left, list);
		list.add(node.value);
		if (node.right != null)
			addMediumNode(node.right, list);

	}

	/**
	 * 后序 左->右->本
	 * 
	 * @return
	 */
	public List<Integer> behindSort() {
		List<Integer> list = new ArrayList<>();
		addBehindNode(root, list);
		return list;
	}

	public void addBehindNode(BinaryTreeNode node, List<Integer> list) {
		if (node.left != null)
			addBehindNode(node.left, list);
		if (node.right != null)
			addMediumNode(node.right, list);
		list.add(node.value);

	}

	/**
	 * 层级 一层一层的
	 * 
	 * @return
	 */
	public List<Integer> levelSort() {
		List<Integer> list = new ArrayList<>();
		List<BinaryTreeNode> temp = new ArrayList<>();
		temp.add(root);
		addLevelNode(temp, list);
		return list;
	}

	public void addLevelNode(List<BinaryTreeNode> nodes, List<Integer> list) {
		if (nodes.size() == 0)
			return;
		List<BinaryTreeNode> temp = new ArrayList<>();
		for (BinaryTreeNode node : nodes) {
			list.add(node.value);
			if (node.left != null)
				temp.add(node.left);
			if (node.right != null)
				temp.add(node.right);
		}
		nodes = null;
		addLevelNode(temp, list);
	}
}
