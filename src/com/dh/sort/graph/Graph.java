package com.dh.sort.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 邻接表，最简单的方式。链表为简单的链表
 * 
 * @author Lenovo
 *
 */
public class Graph { // 无向图
	private int v; // 顶点的个数
	private LinkedList<Integer> adj[]; // 邻接表

	@SuppressWarnings("unchecked")
	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i) {
			adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int s, int t) { // 无向图一条边存两次
		adj[s].add(t);
		adj[t].add(s);
	}

	/**
	 * 广度优先搜索 思想很简单，就是从当前节点为起点，遍历完自己的子节点，后，再根据子节点一层层遍历。
	 * 
	 * @param s
	 * @param t
	 */
	public void bfs(int s, int t) {
		/**
		 * 如果节点一样直接返回
		 */
		if (s == t)
			return;
		/**
		 * 记录已经访问的节点
		 */
		boolean[] visited = new boolean[v];
		visited[s] = true;
		/**
		 * 一层层遍历，一层层加入到队列，遍历完一个，就推出去一个
		 */
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		/**
		 * 存储的路径，记录每个节点的上级节点
		 */
		int[] prev = new int[v];
		for (int i = 0; i < v; ++i) {
			prev[i] = -1;
		}
		/**
		 * 
		 */
		while (queue.size() != 0) {
			int w = queue.poll();
			for (int i = 0; i < adj[w].size(); ++i) {
				int q = adj[w].get(i);
				if (!visited[q]) {
					prev[q] = w;
					if (q == t) {
						print(prev, s, t);
						return;
					}
					visited[q] = true;
					queue.add(q);
				}
			}
		}
	}

	private void print(int[] prev, int s, int t) { // 递归打印 s->t 的路径
		if (prev[t] != -1 && t != s) {
			print(prev, s, prev[t]);
		}
		System.out.print(t + " ");
	}

	boolean found = false; // 全局变量或者类成员变量

	/**
	 * 深度优先搜索，按着一条线走到底，然后遇到走过的点就回溯，直到找到所需要的点。记录好最终路径即可
	 * 
	 * @param s
	 * @param t
	 */
	public void dfs(int s, int t) {
		found = false;
		/**
		 * 记录走过的点
		 */
		boolean[] visited = new boolean[v];
		/**
		 * 记录路径
		 */
		int[] prev = new int[v];
		for (int i = 0; i < v; ++i) {
			prev[i] = -1;
		}
		/**
		 * 开始遍历，从第一个子节点开始
		 */
		recurDfs(s, t, visited, prev);
		print(prev, s, t);
	}

	private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
		/**
		 * 判断状态
		 */
		if (found == true)
			return;
		visited[w] = true;
		if (w == t) {
			found = true;
			return;
		}
		for (int i = 0; i < adj[w].size(); ++i) {
			int q = adj[w].get(i);
			if (!visited[q]) {
				prev[q] = w;
				recurDfs(q, t, visited, prev);
			}
		}
	}

}
