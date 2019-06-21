package com.dh.search.tree;

/**
 * 树节点定义
 * 
 * @author Lenovo
 *
 */
public class TreeNode {

	/**
	 * 直接公开节点，免得麻烦
	 */
	public int data;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int data) {
		super();
		this.data = data;
	}

}
