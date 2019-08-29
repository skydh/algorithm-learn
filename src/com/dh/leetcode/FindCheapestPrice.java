package com.dh.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。
 * 
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。
 * 如果没有这样的路线，则输出 -1。
 * 
 * 链接：https://leetcode-cn.com/problems/cheapest-flights-within-k-stops。
 * 
 * @author Lenovo
 *
 */
public class FindCheapestPrice {
	/**
	 * dj算法，
	 * 
	 * @param n
	 * @param flights
	 * @param src
	 * @param dst
	 * @param K
	 * @return
	 */
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

		/**
		 * 首先构造一个图 key 出发点 map.key 到达点 map.value 钱
		 */
		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
		for (int i = 0; i < flights.length; i++) {
			map.computeIfAbsent(flights[i][0], k -> new HashMap<>()).put(flights[i][1], flights[i][2]);
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
		pq.offer(new int[] { 0, src, 0 });
		while (!pq.isEmpty()) {
			int[] temp = pq.poll();
			if (temp[1] == dst)
				return temp[0];
			if (temp[2] <= K) {
				Map<Integer, Integer> tempMap = map.getOrDefault(temp[1], new HashMap<Integer, Integer>());
				for (Map.Entry<Integer, Integer> entry : tempMap.entrySet()) {
					pq.offer(new int[] { entry.getValue() + temp[0], entry.getKey(), temp[2] + 1 });
				}
			}
		}
		return -1;

	}

	public static void main(String[] arg) {

		FindCheapestPrice findCheapestPrice = new FindCheapestPrice();

		int n = 4;
		int[][] flights = { { 0, 1, 1 }, { 0, 2, 5 }, { 1, 2, 1 }, { 2, 3, 1 } };

		int src = 0;
		int dst = 3;
		int K = 1;

		System.out.println(findCheapestPrice.findCheapestPrice(n, flights, src, dst, K));
	}

}
