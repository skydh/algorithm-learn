package com.dh.leetcode2;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 
 * 必须原地修改，只允许使用额外常数空间。
 * 
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 1,2,3 → 1,3,2 3,2,1 → 1,2,3 1,1,5 → 1,5,1
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class NextPermutation {
	/**
	 * 思路如下，从后往前遍历，遇到后面比前面大的，在后退，若没有交换，则逆序
	 * 
	 * @param nums
	 */
	public static void nextPermutation(int[] nums) {
		if (nums.length < 2)
			return;
		boolean isChange = true;
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				/**
				 * 在按照顺序走，当存在一个值小于这个值的时候，那就交换前一个值。
				 */
				int temp = nums[i - 1];
				int j = i;
				boolean isEnd = false;
				while (nums[j] > temp) {
					if (j < nums.length - 1)
						j++;
					else if (j == nums.length - 1) {
						isEnd = true;
						break;
					} else
						break;

				}
				if (!isEnd)
					j = j - 1;
				nums[i - 1] = nums[j];
				nums[j] = temp;
				/**
				 * 在对后面的排个序 i 到 length
				 */

				for (int k = nums.length - 1; k > (i + nums.length - 1) / 2; k--) {
					int newTemp = nums[k];
					nums[k] = nums[nums.length - 1 - k + i];
					nums[nums.length - 1 - k + i] = newTemp;
				}

				isChange = false;
				break;
			}
		}
		if (isChange) {
			for (int i = nums.length - 1; i > nums.length / 2; i--) {
				int temp = nums[i];
				nums[i] = nums[nums.length - 1 - i];
				nums[nums.length - 1 - i] = temp;
			}
		}
	}

	public static void main(String[] args) {

		int[] words = { 1,2,3 };

		nextPermutation(words);

	}

}
