package com.dh.leetcode;

import java.util.PriorityQueue;

/**
 * 这里有 n 门不同的在线课程，他们按从 1 到 n 编号。每一门课程有一定的持续上课时间（课程时间）t 以及关闭时间第 d 天。一门课要持续学习 t
 * 天直到第 d 天时要完成，你将会从第 1 天开始。
 * 
 * 给出 n 个在线课程用 (t, d) 对表示。你的任务是找出最多可以修几门课。
 * 
 * 示例：
 * 
 * 输入: [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]] 输出: 3 解释: 这里一共有 4
 * 门课程, 但是你最多可以修 3 门: 首先, 修第一门课时, 它要耗费 100 天，你会在第 100 天完成, 在第 101 天准备下门课。 第二,
 * 修第三门课时, 它会耗费 1000 天，所以你将在第 1100 天的时候完成它, 以及在第 1101 天开始准备下门课程。 第三, 修第二门课时,
 * 它会耗时 200 天，所以你将会在第 1300 天时完成它。 第四门课现在不能修，因为你将会在第 3300 天完成它，这已经超出了关闭日期。  
 * 
 * 提示:
 * 
 * 整数 1 <= d, t, n <= 10,000 。 你不能同时修两门课程。  
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/course-schedule-iii
 * 
 * @author Lenovo
 *
 */
public class ScheduleCourse {

	/**
	 * 这是一种贪心的策略，首先按照结束时间，排序，按照贪心策略，也按照我们常人的正常逻辑思维，肯定先把结束时间早的先开始课程，
	 * 然后按照结束时间继续往下排课程，若是排到一个课程，无法加入，那么比对下已经排好的课程，是否有持续时间比其长的，若是有，那么替换，
	 * 因为替换了一定满足不说，还节约了时间，如此，遍历到结尾。
	 * 
	 * 
	 * 不需要具体怎么安排课程，只需要统计
	 * 
	 * @param courses
	 * @return
	 */
	public int scheduleCourse(int[][] courses) {
		quickSort(courses);
		int nowTime = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
		for (int i = 0; i < courses.length; i++) {
			int[] temp = courses[i];
			if (nowTime + temp[0] <= temp[1]) {
				pq.offer(temp);
				nowTime = nowTime + temp[0];
			} else {
				int[] newTemp = pq.poll();
				if (newTemp == null)
					continue;
				else if (newTemp[0] > temp[0]) {
					nowTime = nowTime - newTemp[0] + temp[0];
					pq.offer(temp);
				} else {
					pq.offer(newTemp);
				}
			}
		}

		return pq.size();

	}

	/**
	 * 使用快速排序，对这个数组进行排序。
	 * 
	 * @param courses
	 */
	public void quickSort(int[][] courses) {
		doHelper(0, courses.length - 1, courses);

	}

	public void doHelper(int start, int end, int[][] courses) {
		if (start >= end)
			return;
		int point = getPoint(start, end, courses);
		doHelper(start, point - 1, courses);
		doHelper(point+1, end, courses);

	}

	/**
	 * 
	 * 2,6,8,4,9,7
	 * 
	 * 2,6,4,8,9,7
	 * 
	 * 按照默认方案，还是用最后一个点作为分割点，前面的是大于他的，后面的则是小于他的。
	 * 
	 * @param start
	 * @param end
	 * @param cursor
	 * @return
	 */
	public int getPoint(int start, int end, int[][] courses) {
		int temp = courses[end][1];

		int cursor = start;
		for (int i = start; i <= end; i++) {
			if (courses[i][1] < temp) {
				swap(courses, i, cursor);
				cursor++;
			}
		}
		swap(courses, end, cursor);
		return cursor;

	}

	/**
	 * 交换数据
	 * 
	 * @param a
	 * @param i
	 * @param j
	 */
	public void swap(int[][] a, int i, int j) {
		int[] temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] arg) {
		ScheduleCourse scheduleCourse = new ScheduleCourse();

		int[][] group = { { 5, 5 }, { 4, 6 }, { 2, 6 } };

		System.out.println(scheduleCourse.scheduleCourse(group));
	}

}
