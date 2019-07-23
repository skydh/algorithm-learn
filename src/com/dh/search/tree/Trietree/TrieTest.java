package com.dh.search.tree.Trietree;

import java.util.List;

/**
 * 字典树测试
 * 
 * @author Lenovo
 *
 */
public class TrieTest {

	public static void main(String args[]) {
		TrieTree trieTree = new TrieTree();
		trieTree.insert("xabc".toCharArray());
		trieTree.insert("xabcd".toCharArray());
		trieTree.insert("xabcf".toCharArray());
		trieTree.insert("xabcg".toCharArray());
		trieTree.insert("xadcdfgds".toCharArray());
		trieTree.insert("xawbc".toCharArray());
		trieTree.insert("xafbc".toCharArray());
		trieTree.insert("vabc".toCharArray());
		trieTree.insert("xaebc".toCharArray());
		trieTree.insert("xab".toCharArray());
		
		System.out.println("--------------华丽的分割线----------------");

		List<String> list = trieTree.getData("xa".toCharArray());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

}
