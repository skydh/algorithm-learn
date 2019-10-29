package com.dh.leetcode2;

import java.util.LinkedList;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 
 * 示例 1:
 * 
 * 输入: [[1,3],[2,6],[8,10],[15,18]] 输出: [[1,6],[8,10],[15,18]] 解释: 区间 [1,3] 和
 * [2,6] 重叠, 将它们合并为 [1,6]. 示例 2:
 * 
 * 输入: [[1,4],[4,5]] 输出: [[1,5]] 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class QuJianMerge {

	public static int[][] merge(int[][] intervals) {
		if (intervals.length == 0)
			return intervals;

		/**
		 * 定义一个链表,类似一条线段,我们将一个个数组放进去。每2个点为一组
		 */
		LinkedList<Integer> list = new LinkedList<>();
		list.add(intervals[0][0]);
		list.add(intervals[0][1]);
		for (int i = 1; i < intervals.length; i++) {
			int left = intervals[i][0];
			int right = intervals[i][1];
			int cursor = 0;
			boolean isUse = true;
			while (cursor < list.size()) {
				isUse = true;
				int start = list.get(cursor);
				int end = list.get(cursor + 1);

				if (start > right) {
					list.add(cursor, left);
					list.add(cursor + 1, right);
					break;
				}
				if (end < left) {
					cursor = cursor + 2;
					isUse = false;
					continue;
				}
				int min = Math.min(start, left);
				int max = Math.max(end, right);
				list.set(cursor, min);
				list.set(cursor + 1, max);
				/**
				 * 还要向右边扩散，前面的，绝对可以了
				 */
				int newCursor = cursor + 2;
				while (newCursor < list.size()) {
					int newStart = list.get(newCursor);
					int newEnd = list.get(newCursor + 1);
					if (newStart > max) {
						break;
					}
					if (newEnd >= max) {
						list.remove(newCursor);
						list.remove(newCursor - 1);
						break;
					}
					list.remove(newCursor);
					list.remove(newCursor);

				}

				break;
			}
			if (!isUse) {
				list.add(left);
				list.add(right);
			}

		}
		int cursor = 0;
		int arrayCursor = 0;
		int[][] newIntervals = new int[list.size() / 2][2];
		while (cursor < list.size()) {
			newIntervals[arrayCursor][0] = list.get(cursor);
			newIntervals[arrayCursor][1] = list.get(cursor + 1);
			cursor = cursor + 2;
			arrayCursor++;
		}
		return newIntervals;

	}

	public static void main(String[] args) {
		int[][] intervals = { { 2, 3 }, { 4, 5 }, { 6, 7 }, { 8, 9 }, { 1, 10 } };
		System.out.println(merge(intervals));

	}

}
