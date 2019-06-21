package com.dh.skiplist;

/**
 * 跳跃表结点定义，这边我设置的是最高16层的
 * 
 * @author Lenovo
 *
 */
public class Node {
	public int data = -1;
	public Node[] next = new Node[16];
	public int maxLevel = 0;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{ data: ");
		builder.append(data);
		builder.append("; levels: ");
		builder.append(maxLevel);
		builder.append(" }");

		return builder.toString();
	}
}