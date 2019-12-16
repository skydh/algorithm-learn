package com.dh.leetcode4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
		}

		public Node(int _val, List<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	};

	public Node cloneGraph(Node node) {
		if (node == null)
			return null;

		HashMap<Node, Node> map = new HashMap<>();
		return doHelper(node, map);

	}

	public Node doHelper(Node source, HashMap<Node, Node> map) {
		Node target = map.get(source);
		if (target != null)
			return target;

		List<Node> neighbors = new ArrayList<>();
		target = new Node(source.val, neighbors);
		map.put(source, target);
		for (Node node : source.neighbors) {
			neighbors.add(doHelper(node, map));
		}

		return target;

	}

}
