package com.dh.leetcode4;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 
 * 说明：
 * 
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 
 * 示例 1:
 * 
 * 输入: [2,2,1] 输出: 1 示例 2:
 * 
 * 输入: [4,1,2,1,2] 输出: 4
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class SingleNumber {

	/**
	 * 异或运算
	 * 将数字转换为２进制后做异或运算，每一个数字都要做异或运算。２个数进行异或时，将２个数均转换为２进制数，然后按照顺序每一位开始做对应的异或运算。
	 * 均为０，或者均为１，才是0，否则为０.
	 * 
	 * 一样的数字进行异或运算为0，
	 * 0异或运算一个数字，等于这个数字。
	 * 
	 * @param nums
	 * @return
	 */
	public int singleNumber(int[] nums) {

		if (nums.length == 0)
			return -1;
		int result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			result = result ^ nums[i];
		}
		return result;

	}

}
