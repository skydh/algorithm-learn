package com.dh.search.tree.binarytree;

public class BinaryTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
		tree.insert(13, 12);
		tree.insert(6, 22);
		tree.insert(8, 32);
		tree.insert(7, 422);
		tree.insert(12, 4232);
		tree.insert(11, 4232);
		tree.insert(24, 4232);
		tree.delete(13);

		System.out.println(tree.search(9));
	}

}
