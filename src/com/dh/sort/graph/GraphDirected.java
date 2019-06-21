package com.dh.sort.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 有向图
 * 
 * @author Lenovo
 *
 */

public class GraphDirected {

	private int v; // 顶点的个数
	/**
	 * 在java里面除非你自定义链表，不然矩阵还是arraylist效率高
	 */
	private List<Integer> adj[]; // 邻接表

	@SuppressWarnings("unchecked")
	public GraphDirected(int v) {
		this.setV(v);
		adj = new ArrayList[v];
		for (int i = 0; i < v; ++i) {
			adj[i] = new ArrayList<>();
		}
	}

	public void addEdge(int s, int t) { // s 先于 t，边 s->t
		adj[s].add(t);
	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}

	/**
	 * 这里2个算法进行拓扑排序。
	 */

	/**
	 * 这个算法，就是先统计出每个点的被多少要求先依赖 kahn 这里面的矩阵是顺矩阵，链表里面的数据是后执行的。
	 */
	public void kahn() {
		/**
		 * 这个数组是存放每个点被执行前有多少点要先执行
		 */
		int[] temp = new int[v];
		/**
		 * 遍历整个矩阵数组
		 */
		for (int i = 0; i < v; i++) {
			/**
			 * 遍历链表
			 */
			for (int j = 0; j < adj[i].size(); j++) {

				/**
				 * k是这个链表里面的元素值，那么temp数组中对应的元素要加一。因为查出来了
				 */
				int k = adj[i].get(j);
				temp[k]++;
			}

		}
		/**
		 * 找出执行前需要执行的点为0的数据。
		 */
		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 0; i < v; i++) {
			if (temp[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {

			int i = queue.remove();
			/**
			 * 打印可以执行的点
			 */
			System.out.print("->" + i);
			/**
			 * 找到矩阵中打印元素的数组，里面的元素都是要这个点执行后才能执行的，将其temp减1；在判断是否为0.
			 */
			for (int j = 0; j < adj[i].size(); ++j) {
				int k = adj[i].get(j);
				temp[k]--;
				if (temp[k] == 0)
					queue.add(k);
			}
		}

	}

	/**
	 * dns算法 先构建逆矩阵,链表里面是要先于这个点执行的点。
	 */
	@SuppressWarnings("unchecked")
	public void Dns() {
		/**
		 * 构建逆矩阵
		 */
		List<Integer>[] temp = new ArrayList[v];
		for (int i = 0; i < v; ++i) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < adj[i].size(); j++) {
				temp[adj[i].get(j)].add(i);
			}
		}
		/**
		 * 构建一个数组，该数据是记录状态
		 */
		boolean[] help = new boolean[v];
		for (int i = 0; i < v; ++i) {
			help[i] = true;
			doHelper(temp, help, i);
		}
	}

	/**
	 * 这个方法，调用这个方法，如果这个元素没有值，那么直接打印，有元素，那么就是需要先打印这个元素集合，看看这个这个元素是否已经打印过了，
	 * 没有就进入下一个循环，有则是处理
	 * 
	 * @param temp
	 * @param help
	 * @param cursor
	 */
	public void doHelper(List<Integer> temp[], boolean[] help, int cursor) {
		for (int i = 0; i < temp[cursor].size(); i++) {
			int k = temp[cursor].get(i);
			if (help[k]) {
				continue;
			}
			help[k] = true;
			doHelper(temp, help, i);
		}
		System.out.println(cursor);

	}

}
