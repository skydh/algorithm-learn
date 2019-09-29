package com.dh.leetcode;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线
 * i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class MaxArea {

	/**
	 * 
	 * 
	 * @param height
	 * @return
	 */
	public static int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int maxSize = Math.min(height[left], height[right]) * right;
		while (left < right) {
			if (height[left] > height[right])
				right--;
			else
				left++;

			maxSize = Math.max(maxSize, Math.min(height[left], height[right]) * (right - left));

		}
		return maxSize;

	}

	public static void main(String[] arg) {

		int[] data = { 2, 3, 10, 5, 7, 8, 9 };
		System.out.println(maxArea(data));
	}

}
