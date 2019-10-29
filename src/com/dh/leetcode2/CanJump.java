package com.dh.leetcode2;

import java.util.LinkedList;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 判断你是否能够到达最后一个位置。
 * 
 * 示例 1:
 * 
 * 输入: [2,3,1,1,4] 输出: true 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3
 * 步到达最后一个位置。 示例 2:
 * 
 * 输入: [3,2,1,0,4] 输出: false 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ，
 * 所以你永远不可能到达最后一个位置。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class CanJump {

	/**
	 * 这个题目可以使用贪心的策略。
	 * 要达到终点，那么每次选择综合最大值的点，判断最后是否可以到达即可，要是综合最大点也到不了，那就gg，同时这个点也不能为0，除非是终点
	 * 
	 * @param nums
	 * @return
	 */
	public static boolean canJump(int[] nums) {
		if (nums.length == 0 || (nums.length == 1 && nums[0] == 0))
			return true;
		int cursor = 0;
		while (true) {
			if (nums[cursor] + cursor >= nums.length - 1)
				return true;
			if (nums[cursor] == 0)
				return false;

			int max = 0;
			int newCoursor = cursor;
			for (int i = cursor + 1; i <= nums[cursor] + cursor && i < nums.length; i++) {
				int sum = i + nums[i];
				if (sum > max) {
					max = sum;
					newCoursor = i;
				}

			}
			cursor = newCoursor;
		}
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(0, -1);
		list.set(0, 2);
		System.out.println(list);

	}

}
