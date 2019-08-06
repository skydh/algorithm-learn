package com.dh.sort.heap;

import java.util.ArrayList;
import java.util.List;

import com.dh.sort.heap.PriorityQueue.Node;

/**
 * 多个有序数组的合并 这里要使用堆来完成，为何是堆呢
 * 前面我们在数组那一个模块里面，是先将每个数组的最小元素加入到一个数组里面，然后取出最小的元素放入到新的数组里面，然后从取出元素的数组里面再取出一个元素，
 * 然后和暂存元素比对，时间复杂度为On,然而我们用堆来处理，或者用我们前面实现的基于堆的优先级队列
 * 
 * @author Lenovo
 *
 */
public class MergeArrayHeap {

	public List<Integer> merge(int[][] data) {
		List<Integer> list = new ArrayList<>();
		PriorityQueue priorityQueue = new PriorityQueue(data.length);
		for (int i = 0; i < data.length; i++) {
			priorityQueue.push(String.valueOf(i + "," + 0), data[i][0]);
		}

		while (true) {
			if (priorityQueue.getSize() <= 0)
				break;
			Node node = priorityQueue.get();
			list.add(node.sequence);
			String[] ss = node.value.split(",");
			int cursorData = Integer.parseInt(ss[0]);
			int cursorDataCursor = Integer.parseInt(ss[1]) + 1;
			if (data[cursorData].length > cursorDataCursor)
				priorityQueue.push(String.valueOf(cursorData + "," + cursorDataCursor),
						data[cursorData][cursorDataCursor]);

		}

		return list;

	}

}
