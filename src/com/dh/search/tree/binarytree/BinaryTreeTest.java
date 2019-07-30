package com.dh.search.tree.binarytree;

import java.util.List;

public class BinaryTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
		tree.insert(20, 20);
		tree.insert(10, 10);
		tree.insert(30, 30);
		tree.insert(5, 5);
		tree.insert(15, 15);
		tree.insert(25, 25);
		tree.insert(35, 35);
		tree.insert(3, 3);
		tree.insert(8, 8);
		tree.insert(2, 2);
		tree.insert(4, 4);
		tree.insert(6, 6);
		tree.insert(9, 9);
		tree.insert(11, 11);
		tree.insert(16, 16);

		List<Integer> list = tree.levelSort();
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i)+" ");
	}

}
