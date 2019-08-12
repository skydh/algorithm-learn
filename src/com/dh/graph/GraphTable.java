package com.dh.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 基于邻接表的图 图的话 直接定义为有权有向图，因为这个可以包含有权图，有向图，无向图（多行代码）
 * 
 * @author Lenovo
 *
 */
public class GraphTable {
	private List<Edge>[] list;

	private int nodeNum;

	@SuppressWarnings("unchecked")
	public GraphTable(int num) {
		this.nodeNum = num;
		list = new ArrayList[num];
		for (int i = 0; i < num; i++) {
			list[i] = new ArrayList<>();
		}
	}

	public void addEdge(int start, int end, int weights) {
		list[start].add(new Edge(start, end, weights));

	}

	public int getNum() {
		return nodeNum;
	}

	public class Edge {
		public int start;
		public int end;
		public int weights;

		public Edge(int start, int end, int weights) {
			this.start = start;
			this.end = end;
			this.weights = weights;
		}

	}

	/**
	 * 广度优先搜索算法（英语：Breadth-First-Search，缩写为BFS），又译作宽度优先搜索，或横向优先搜索，是一种图形搜索算法。简单的说
	 * ，BFS是从根节点开始，沿着树的宽度遍历树的节点。如果所有节点均被访问，则算法中止。广度优先搜索的实现一般采用open-closed表。
	 * 
	 * 
	 * 本方法是通过广度优先搜索找出这2个点可达吗。且打印出路线
	 * 
	 * @param s
	 * @param t
	 */
	public boolean bfs(int s, int t) {
		if (s == t)
			return true;
		/**
		 * 判断节点是否遍历过
		 */
		boolean[] weights = new boolean[nodeNum];
		/**
		 * 前个节点
		 */
		int[] pre = new int[nodeNum];

		for (int i = 0; i < nodeNum; ++i) {
			pre[i] = -1;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		while (queue.size() > 0) {
			int temp = queue.poll();
			weights[temp] = true;
			List<Edge> tempList = list[temp];
			for (int i = 0; i < tempList.size(); i++) {

				Edge edge = tempList.get(i);
				if (!weights[edge.end]) {
					pre[edge.end] = temp;
					if (edge.end == t) {
						print(pre, s, t);
						return true;
					}
					queue.add(edge.end);

				}

			}

		}
		return true;
	}

	public void print(int[] pre, int start, int end) {
		int temp = end;
		while (pre[temp] != start) {
			System.out.println(temp);
			temp = pre[temp];
		}
		System.out.println(temp);
		System.out.println(start);
	}

	public boolean dfs(int s, int t) {
		if (s == t)
			return true;
		List<Edge> listTemp = list[s];
		for (Edge edge : listTemp) {
			if (edge.end == t)
				return true;
			else {
				if (dfs(edge.end, t)) {
					System.out.println(edge.end);
					return true;
				}
			}
		}
		return false;

	}

}
