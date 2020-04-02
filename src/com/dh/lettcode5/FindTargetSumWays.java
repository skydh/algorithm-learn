package com.dh.lettcode5;

/**
 * 给定一个非负整数数组，a1, a2, ..., an,
 * 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * 
 * 示例 1:
 * 
 * 输入: nums: [1, 1, 1, 1, 1], S: 3 输出: 5 解释:
 * 
 * -1+1+1+1+1 = 3 +1-1+1+1+1 = 3 +1+1-1+1+1 = 3 +1+1+1-1+1 = 3 +1+1+1+1-1 = 3
 * 
 * 一共有5种方法让最终目标和为3。 注意:
 * 
 * 数组非空，且长度不会超过20。 初始的数组的和不会超过1000。 保证返回的最终结果能被32位整数存下。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class FindTargetSumWays {
	public int findTargetSumWays(int[] nums, int S) {
		int length = 0;
		for (int i = 0; i < nums.length; i++) {
			length = length + nums[i];
		}
		if (length < S)
			return 0;
		int[][] data = new int[2 * (length + 1)][nums.length];
		/**
		 * 这里约定了 -符号，就是这个length-数本身，+符号则是这个数+length
		 * 
		 */
		data[length - nums[0]][0] = 1;
		data[nums[0] + length][0] = data[nums[0] + length][0] + 1;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < data.length; j++) {
				if (data[j][i - 1] > 0) {
					/**
					 * 符号-
					 */
					data[j - nums[i]][i] = data[j - nums[i]][i] + data[j][i - 1];

					/**
					 * 符号+
					 */
					data[j + nums[i]][i] = data[j + nums[i]][i] + data[j][i - 1];

				}

			}

		}
		return data[S + length][nums.length - 1];
	}

	public static void main(String[] args) {

		FindTargetSumWays fs = new FindTargetSumWays();
		int[] nums = { 0, 0, 1 };
		System.out.println(fs.findTargetSumWays(nums, 1));
	}
}
