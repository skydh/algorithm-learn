package com.dh.lettcode5;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。
 * 
 * 请你重新排列这些条形码，使其中两个相邻的条形码 不能 相等。 你可以返回任何满足该要求的答案，此题保证存在答案。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入：[1,1,1,2,2,2] 输出：[2,1,2,1,2,1] 示例 2：
 * 
 * 输入：[1,1,1,1,2,2,3,3] 输出：[1,3,1,3,2,1,2,1]  
 * 
 * 提示：
 * 
 * 1 <= barcodes.length <= 10000 1 <= barcodes[i] <= 10000
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/distant-barcodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class RearrangeBarcodes {

	public int[] rearrangeBarcodes(int[] barcodes) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < barcodes.length; i++)
			map.put(barcodes[i], map.get(barcodes[i]) == null ? 1 : map.get(barcodes[i]) + 1);

		PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(
				(a, b) -> (b.getValue() - a.getValue()));

		for (Map.Entry<Integer, Integer> entry : map.entrySet())
			priorityQueue.add(entry);
		Map.Entry<Integer, Integer> first = priorityQueue.poll();
		barcodes[0] = first.getKey();

		if (first.getValue() > 1) {
			first.setValue(first.getValue() - 1);
			priorityQueue.add(first);
		}
		int cursor = 1;
		while (!priorityQueue.isEmpty()) {

			Map.Entry<Integer, Integer> entry = priorityQueue.poll();
			if (priorityQueue.isEmpty()) {
				barcodes[cursor] = entry.getKey();
				break;
			}
			Map.Entry<Integer, Integer> entry1 = priorityQueue.poll();
			if (barcodes[cursor - 1] == entry.getKey()) {
				barcodes[cursor] = entry1.getKey();
				barcodes[cursor + 1] = entry.getKey();
			} else {
				barcodes[cursor] = entry.getKey();
				barcodes[cursor + 1] = entry1.getKey();
			}
			if (entry.getValue() > 1) {
				entry.setValue(entry.getValue() - 1);
				priorityQueue.add(entry);
			}
			if (entry1.getValue() > 1) {
				entry1.setValue(entry1.getValue() - 1);
				priorityQueue.add(entry1);
			}
			cursor=cursor+2;
		}

		return barcodes;

	}
	
	

}
