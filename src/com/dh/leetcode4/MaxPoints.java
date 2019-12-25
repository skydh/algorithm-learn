package com.dh.leetcode4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * 
 * 示例 1:
 * 
 * 输入: [[1,1],[2,2],[3,3]] 输出: 3 解释: ^ | |        o |     o |  o  
 * +-------------> 0  1  2  3 4 示例 2:
 * 
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]] 输出: 4 解释: ^ | | o |     o   o |
 *      o |  o   o +-------------------> 0  1  2  3  4  5  6
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/max-points-on-a-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class MaxPoints {

	class Entry {
		public long start;
		public long end;
		public int count;

		public Entry(long start, long end) {
			this.start = start;
			this.end = end;
			this.count = 2;
		}
	}

	public int maxPoints(int[][] points) {
		if (points.length == 0)
			return 0;

		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 0);
		for (int i = 1; i < points.length; i++) {
			if (points[i][0] == points[i - 1][0] && points[i][1] == points[i - 1][1]) {

				map.put(i, map.get(i - 1) + 1);
			} else {
				map.put(i, 0);
			}
		}

		List<List<Entry>> countLength = new ArrayList<>();
		for (int i = 0; i < points.length; i++) {
			List<Entry> list = new ArrayList<>();
			int length=0;
			for (int j = i + 1; j < points.length; j++) {
				long newStart = points[j][0] - points[i][0];
				long newEnd = points[j][1] - points[i][1];
				if (newStart == 0 && newEnd == 0 && j - i == 1) {
					Entry entry = new Entry(newStart, newEnd);
					entry.count = entry.count + map.get(i);
					list.add(entry);
					countLength.add(list);
					break;
				}

				if (newStart == 0 && newEnd == 0) {
					for (Entry entry : list)
						entry.count = entry.count + 1;
					length++;
					continue;

				}

				boolean isSuit = false;
				for (Entry entry : list) {
					if (newStart * entry.end == newEnd * entry.start) {
						isSuit = true;
						entry.count = entry.count + 1;
						break;
					}
				}
				if (!isSuit) {
					Entry entry = new Entry(newStart, newEnd);
					entry.count = entry.count + map.get(i)+length;
					list.add(entry);
				}

			}
			countLength.add(list);

		}
		int max = 1;
		for (List<Entry> list : countLength) {
			for (Entry entry : list) {
				if (entry.count > max)
					max = entry.count;
			}
		}
		return max;

	}

	public static void main(String[] args) {

		MaxPoints wb = new MaxPoints();
		int[][] points = { { 40, -23 }, { -3, 80 }, { 5, -21 }, { -3, 80 }, { -6, -65 }, { -6, -65 } };
		System.out.println(wb.maxPoints(points));
	}

}