package com.dh.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于邻接表的图 图的话 直接定义为有权有向图，因为这个可以包含有权图，有向图，无向图（多行代码）
 * 
 * @author Lenovo
 *
 */
public class GraphTable {
	private List<Edge>[] list;

	private int nodeNum;

	public GraphTable(int num) {
		this.nodeNum = num;
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

}
