package com.dh.leetcode4;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * 
 * 说明：
 * 
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 
 * 示例 1:
 * 
 * 输入: [2,2,3,2] 输出: 3 示例 2:
 * 
 * 输入: [0,1,0,1,0,1,99] 输出: 99
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/single-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class SingleNumber1 {

	/**
	 * 看了评论得到的方案。
	 * 
	 * 计算，一个整数由32位bit组成，我们32次遍历数组，计算这个数组在每一位中出现的次数，然后%3是否为0，不为0，则加值
	 * 
	 * @param nums
	 * @return
	 */
	public int singleNumber(int[] nums) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			int data = 1 << i;
			int count = 0;

			for (int j = 0; j < nums.length; j++)
				if ((nums[j] & data) != 0)
					count++;

			System.out.println(count);
			if (count % 3 != 0)
				result = result + data;

		}

		return result;

	}

}
