package com.dh.graph;

public class GraphTest {

	public static void main(String[] args) {
		GraphTable gt = new GraphTable(6);
		gt.addEdge(0, 1, 1);
		gt.addEdge(1, 3, 1);
		gt.addEdge(1, 2, 1);
		gt.addEdge(2, 3, 1);
		gt.addEdge(2, 1, 1);
		gt.addEdge(3, 4, 1);
		gt.addEdge(4, 5, 1);
		gt.addEdge(5, 1, 1);
		gt.bfs(0, 5);

	}

}
