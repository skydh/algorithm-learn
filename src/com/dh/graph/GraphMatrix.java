package com.dh.graph;

/**
 *
 * 基于邻接矩阵的有向有权图
 * 
 * @author Lenovo
 *
 */
public class GraphMatrix {
	private int[][] data;
	private int nodeNum;

	public GraphMatrix(int num) {
		this.nodeNum = num;
		data = new int[num][num];
	}

	public void addEdge(int start, int end, int weights) {
		data[start][end] = weights;
	}

	public int[][] getData() {
		return data;

	}

	public int getNodeNum() {
		return nodeNum;
	}
}
