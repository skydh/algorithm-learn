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

	/**
	 * 初始化时就要给点赋值
	 */
	private Point[] points;
	private int nodeNum;

	@SuppressWarnings("unchecked")
	public GraphTable(Point[] points) {
		this.nodeNum = points.length;
		list = new ArrayList[points.length];
		for (int i = 0; i < points.length; i++) {
			list[i] = new ArrayList<>();
		}
		this.points = points;
	}

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

	public class Point {
		public int x;
		public int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
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

	/**
	 * dijkst算法是一个广度搜索算法。算法思路很有意思
	 * 建立一个数组，存放原点到其他节点的距离，建立一个集合，存放其他所有原点，然后在数组找出最小的一个点，将其从集合pass，同时修改数组的值，
	 * 看看有没有更小的值， 对了，为了记录目的节点的位置，在建立一个数组用来存储前驱节点
	 * 
	 * 首先定义一个优先级队列
	 * 前面学习小顶堆时定义过了，因此直接使用，顺便加一些api.，但是加update操作很难受，不知道如何是好，同时优先级队列的属性和这个不是很匹配，
	 * 想了下， 还是算了吧，直接用数组来玩
	 * 
	 * @author Lenovo
	 *
	 */
	public void dijkst(int s, int t) {
		boolean[] isUse = new boolean[nodeNum];
		isUse[s] = true;
		List<Edge> listEdge = list[s];
		int[] weights = new int[nodeNum];
		for (int i = 0; i < nodeNum; i++)
			weights[i] = Integer.MAX_VALUE;
		weights[s] = 0;
		int[] pre = new int[nodeNum];
		for (Edge edge : listEdge) {
			weights[edge.end] = edge.weights;
			pre[edge.end] = s;
		}
		boolean isFind = true;
		while (true) {
			int cursor = findMin(weights, isUse);
			if (cursor < 0) {
				isFind = false;
				break;
			}
			if (cursor == t) {
				break;
			}
			List<Edge> listi = list[cursor];
			for (Edge edge : listi) {
				int tempDatai = edge.weights + weights[cursor];
				if (tempDatai < weights[edge.end]) {

					pre[edge.end] = cursor;
					weights[edge.end] = tempDatai;
				}
			}
			isUse[cursor] = true;
		}

		if (isFind) {
			System.out.println("最短路径长度是：" + weights[t]);
			print(pre, s, t);
		}
		// syso
	}

	/**
	 * 获取排除已排除最小点的点
	 * 
	 * @param data
	 * @param isUse
	 * @return
	 */
	public int findMin(int[] data, boolean[] isUse) {
		int min = Integer.MAX_VALUE;
		int cursor = -1;
		for (int i = 0; i < data.length; i++) {
			if (!isUse[i]) {
				if (data[i] < min) {
					min = data[i];
					cursor = i;
				}
			}

		}
		return cursor;

	}

	/**
	 * A*算法，这个算法不一定是最优解，但是可能是比较优解，适用于大地图的情况，因为对于大地图来说，dj算法需要遍很多的最小顶点，只要是比这个节点小的，
	 * 都要遍历，看起来很高大上，实则很low,就是在加了一个判断条件，就是曼哈顿距离
	 */
	public void a(int s, int t) {
		boolean[] isUse = new boolean[nodeNum];
		isUse[s] = true;
		List<Edge> listEdge = list[s];
		int[] weights = new int[nodeNum];
		for (int i = 0; i < nodeNum; i++)
			weights[i] = Integer.MAX_VALUE;
		weights[s] = 0;
		int[] pre = new int[nodeNum];
		for (Edge edge : listEdge) {
			weights[edge.end] = edge.weights + absLength(points[edge.end], points[t]);
			pre[edge.end] = s;
		}
		boolean isFind = true;
		while (true) {
			int cursor = findMin(weights, isUse);
			if (cursor < 0) {
				isFind = false;
				break;
			}
			if (cursor == t) {
				break;
			}
			List<Edge> listi = list[cursor];
			for (Edge edge : listi) {
				int tempDatai = edge.weights + weights[cursor] + absLength(points[edge.end], points[t]);
				if (tempDatai < weights[edge.end]) {

					pre[edge.end] = cursor;
					weights[edge.end] = tempDatai;
				}
			}
			isUse[cursor] = true;
		}

		if (isFind) {
			System.out.println("最短路径长度是：" + weights[t]);
			print(pre, s, t);
		}
		// syso

	}

	public int absLength(Point v1, Point v2) { // Vertex 表示顶点，后面有定义
		return Math.abs(v1.x - v2.x) + Math.abs(v1.y - v2.y);
	}

}
