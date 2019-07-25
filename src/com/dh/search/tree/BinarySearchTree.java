package com.dh.search.tree;

/**
 * 定义很简单，右子树节点大于本节点，左子树节点小于本节点 插入操作都是放在叶子节点 这是针对没有相同数据的 ，
 * 有相同数据的3个方案（实际上一个node节点，包含一个key和node的具体值）： 1.对每个节点加一个链表， 2.等于自己的放在右节点。
 * 3.可以按照hashmap的策略进行覆盖
 * 
 * 相对散列表的优势，没有扩容造成的影响。 可以中序输出有序
 * 
 * 
 * @author Lenovo
 *
 */
public class BinarySearchTree {
	private TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	/**
	 * 简单遍历，一层层遍历，比当前节点大则去右节点那边，比当前节点小则去左节点那边，否则则是本节点。
	 * 
	 * @param data
	 * @return
	 */
	public TreeNode find(int data) {
		if (root == null) {
			return null;
		}
		TreeNode node = root;
		while (node != null) {
			if (node.data > data)
				node = node.left;
			else if (node.data < data)
				node = node.right;
			else
				return node;
		}
		return null;

	}

	/**
	 * 插入，反正必须插入到叶子节点，从根节点一下一下比较，比该节点大，则去右边 ， 比该节点小则去左边。若是为null，则插入，不为空，继续向下遍历
	 * 
	 * @param data
	 */
	public void insert(int data) {
		if (root == null) {
			root = new TreeNode(data);
			return;
		}
		TreeNode node = root;
		while (node != null) {
			if (node.data > data) {
				if (node.right == null) {
					node.right = new TreeNode(data);
					return;
				} else {
					node = node.right;
				}
			} else if (node.data < data) {
				if (node.left == null) {
					node.left = new TreeNode(data);
					return;
				} else {
					node = node.left;
				}
			} else {
				return;
			}
		}

	}

	/**
	 * 删除，我们可以分为3种情况 1.删除叶子节点 2.删除节点只有一个子节点 3.删除节点有2个节点
	 * 对于1,2，这2种情况，很简单，直接让当前节点的父节点指向其子节点(叶子节点的子节点就是null)
	 * 对于3，我们找出其右节点最小节点，或者左子树最大节点提换这个节点，然后删除该节点。将其转换为删除子节点。
	 * 其查找时间复杂度当为完全2叉树的时候为log(n)
	 * 
	 * @param data
	 */
	public void delete(int data) {
		TreeNode node = root;
		TreeNode fnode = null;
		while (node != null && node.data != data) {
			fnode = node;
			if (node.data > data)
				node = node.left;
			else if (node.data < data)
				node = node.right;

		}
		/**
		 * 如果node为null ，那么找不到删除的节点。
		 */
		if (node == null) {
			return;
		}
		/**
		 * 我们要将有2子节点的数据变成删除单节点的
		 */
		if (node.left != null && node.right != null) {
			TreeNode mnode = node.right;
			TreeNode mfnode = node;
			/**
			 * 找到右节点最小的节点,一直向左即可
			 */
			while (mnode.left != null) {
				mfnode = mnode;
				mnode = mnode.left;
			}
			/**
			 * 替换。
			 */
			node.data = mnode.data;

			/**
			 * 再将这个地址重指向
			 */
			node = mnode;
			fnode = mfnode;
		}

		/**
		 * 好了，现在要删除的都是叶子节点或者只有一个子节点的节点了。 那么，让child指向其下级节点
		 */
		TreeNode child;
		if (node.left != null)
			child = node.left;
		else if (node.right != null)
			child = node.right;
		else
			child = null;// 叶子节点。

		/**
		 * 根节点特殊处理
		 */
		if (fnode == null) {
			root = child;
		}
		/**
		 * 最后就是指向了。父节点指向下一级节点。
		 */
		else if (fnode.left == node)
			fnode.left = child;
		else
			fnode.right = child;

	}

}
