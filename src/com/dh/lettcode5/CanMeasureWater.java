package com.dh.lettcode5;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * 
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * 
 * 你允许：
 * 
 * 装满任意一个水壶 清空任意一个水壶 从一个水壶向另外一个水壶倒水，直到装满或者倒空 示例 1: (From the famous "Die Hard"
 * example)
 * 
 * 输入: x = 3, y = 5, z = 4 输出: True 示例 2:
 * 
 * 输入: x = 2, y = 6, z = 5 输出: False
 * 
 * @author Lenovo
 *
 */
public class CanMeasureWater {

	/**
	 * 
	 * 
	 * 模拟所有的操作 1，加满x 2,加满y，3,倒空X，4,倒空Y 5，X倒入Y,6,Y倒入X
	 * 
	 * 
	 *通过这个问题，我们要发现分析问题的本质，仔细分析处理。
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public boolean canMeasureWater(int x, int y, int z) {
		Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<>();
		HashSet<Map.Entry<Integer, Integer>> set = new HashSet<>();
		AbstractMap.SimpleImmutableEntry<Integer, Integer> map = new AbstractMap.SimpleImmutableEntry<Integer, Integer>(
				0, 0);
		queue.add(map);
		set.add(map);
		while (queue.size() != 0) {
			Map.Entry<Integer, Integer> currentMap = queue.poll();
			int curx = currentMap.getKey();
			int cury = currentMap.getValue();
			if (curx == z || cury == z || curx + cury == z)
				return true;
			if (curx != x) {
				doHelper(queue, set, new AbstractMap.SimpleImmutableEntry<Integer, Integer>(x, cury));
			}
			if (cury != y) {
				doHelper(queue, set, new AbstractMap.SimpleImmutableEntry<Integer, Integer>(curx, y));
			}
			if (curx != 0) {
				doHelper(queue, set, new AbstractMap.SimpleImmutableEntry<Integer, Integer>(0, cury));
			}
			if (cury != 0) {
				doHelper(queue, set, new AbstractMap.SimpleImmutableEntry<Integer, Integer>(curx, 0));
			}
			/**
			 * x->y
			 */
			if (y - cury > curx) {
				doHelper(queue, set, new AbstractMap.SimpleImmutableEntry<Integer, Integer>(0, cury + curx));
			} else {
				doHelper(queue, set, new AbstractMap.SimpleImmutableEntry<Integer, Integer>(curx + cury - y, y));
			}

			/**
			 * y->x
			 */
			if (x - curx > cury) {
				doHelper(queue, set, new AbstractMap.SimpleImmutableEntry<Integer, Integer>(cury + curx, 0));
			} else {
				doHelper(queue, set, new AbstractMap.SimpleImmutableEntry<Integer, Integer>(x, cury + curx - x));
			}
		}
		return false;

	}

	public void doHelper(Queue<Map.Entry<Integer, Integer>> queue, HashSet<Map.Entry<Integer, Integer>> set,
			AbstractMap.SimpleImmutableEntry<Integer, Integer> map) {
		if (!set.contains(map)) {
			queue.add(map);
			set.add(map);
		}

	}

}
