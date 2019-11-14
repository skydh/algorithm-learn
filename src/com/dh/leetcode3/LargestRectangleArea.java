package com.dh.leetcode3;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 
 *  
 * 
 * 
 * 
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * 
 *  
 * 
 * 
 * 
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * 
 *  
 * 
 * 示例:
 * 
 * 输入: [2,1,5,6,2,3] 输出: 10
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class LargestRectangleArea {

	/**
	 * 只考虑到了暴力，看了题解，分治算法，很不错
	 * 
	 * @param heights
	 * @return
	 */

	public int largestRectangleArea(int[] heights) {
		int[] data = new int[1];

		doHelper(0, heights.length - 1, heights, data);
		return data[0];

	}

	public void doHelper(int start, int end, int[] heights, int[] data) {
		if (start > end)
			return;
		int minCursor = getMin(start, end, heights);
		int tempData = heights[minCursor] * (end - start + 1);
		
		if (data[0] < tempData) {
			data[0] = tempData;
		}
		doHelper(start, minCursor - 1, heights, data);
		doHelper(minCursor + 1, end, heights, data);

	}

	public int getMin(int start, int end, int[] heights) {
		int min = heights[start];
		int minCursor = start;
		for (int i = start + 1; i <= end; i++) {
			if (heights[i] < min) {
				min = heights[i];
				minCursor = i;
			}
		}
		return minCursor;
	}

}
