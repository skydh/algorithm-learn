package com.dh.leetcode2;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 
 * 你可以假设数组中不存在重复的元素。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 示例 1:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 0 输出: 4 示例 2:
 * 
 * 输入: nums = [4,5,6,7,0,1,2], target = 3 输出: -1
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class ArraySearch {

	/**
	 * 全局遍历不行，时间复杂度是n,我们先和最后面的元素比对，如果大于，那就从前面开始比对，如果小于则是从后面比对，终止条件是出现小于或者大于的数字
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int search(int[] nums, int target) {
		if (nums.length == 0)
			return -1;
		if (nums[nums.length - 1] == target)
			return nums.length - 1;
		else if (nums[nums.length - 1] < target) {
			for (int i = 0; i < nums.length - 1 && nums[i] >= nums[0]; i++) {
				if (nums[i] == target)
					return i;
			}
		} else if (nums[nums.length - 1] > target) {
			for (int i = nums.length - 1; i >= 0 && nums[i] <= nums[nums.length - 1]; i--) {
				if (nums[i] == target)
					return i;
			}
		}

		return -1;

	}

	public static void main(String[] args) {
		int[] ary = { 4, 5, 6, 7, 0, 1, 2 };

		System.out.println(search(ary, 0));

	}
}
