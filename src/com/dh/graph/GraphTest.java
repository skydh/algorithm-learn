package com.dh.graph;

public class GraphTest {

	public static void main(String[] args) {
		GraphTable gt = new GraphTable(6);
		gt.addEdge(0, 1, 5);
		gt.addEdge(1, 3, 6);
		gt.addEdge(1, 2, 7);
		gt.addEdge(1, 5, 100);
		gt.addEdge(2, 3, 3);
		gt.addEdge(2, 5, 100);

		gt.addEdge(3, 4, 4);
		gt.addEdge(4, 5, 1);
		gt.addEdge(5, 1, 1);
		gt.dijkst(0, 5);
		gt.dijkst(5, 0);

	}

}
