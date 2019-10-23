package com.dh.leetcode2;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 
 * 示例:
 * 
 * 输入: [2,3,1,1,4] 输出: 2 解释: 跳到最后一个位置的最小跳跃数是 2。   从下标为 0 跳到下标为 1
 * 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。 说明:
 * 
 * 假设你总是可以到达数组的最后一个位置。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class Jump {
	/**
	 * 我这么想的，从你可以跳的地方，跳，有n个选择，这n就是你跳的长度，然后在计算，谁可以去更加远，选择更多，那就谁，然后不断计算次数，就算出来了，
	 * 好好奇， 这个也算困难？？？
	 * 
	 * @param nums
	 * @return
	 */
	public static int jump(int[] nums) {
		int size = 0;
		int cursor = 0;
		while (cursor < nums.length - 1) {
			int newCursor = 0;
			int sum = 0;
			size++;
			int length = nums[cursor];
			if (cursor + length >= nums.length - 1) {
				return size;
			}
			for (int i = cursor + 1; i <= cursor + length; i++) {
				int temp = i + nums[i];
				if (temp > sum) {
					sum = temp;
					newCursor = i;
				}
			}
			cursor = newCursor;

		}
		return size;

	}

	public static void main(String[] args) {

		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println(jump(nums));

	}

}
