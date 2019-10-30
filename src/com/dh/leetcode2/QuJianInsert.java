package com.dh.leetcode2;

import java.util.LinkedList;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 
 * 示例 1:
 * 
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5] 输出: [[1,5],[6,9]] 示例 2:
 * 
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8] 输出:
 * [[1,2],[3,10],[12,16]] 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class QuJianInsert {
	/**
	 * 和前面的那个区间合并没啥区别啊 不懂为啥难度不一样，我觉得这个甚至更加简单
	 * 
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
	public int[][] insert(int[][] intervals, int[] newInterval) {
		int[][] result;
		if (intervals.length == 0) {
			result = new int[1][2];
			result[0][0] = newInterval[0];
			result[0][1] = newInterval[1];
			return result;
		}

		/**
		 * 定义一个链表,类似一条线段,我们将一个个数组放进去。每2个点为一组
		 */
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < intervals.length; i++) {
			list.add(intervals[i][0]);
			list.add(intervals[i][1]);
		}

		int left = newInterval[0];
		int right = newInterval[1];
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
		cursor = 0;
		int arrayCursor = 0;
		result = new int[list.size() / 2][2];
		while (cursor < list.size()) {
			result[arrayCursor][0] = list.get(cursor);
			result[arrayCursor][1] = list.get(cursor + 1);
			cursor = cursor + 2;
			arrayCursor++;
		}
		return result;

	}

}
