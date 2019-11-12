package com.dh.leetcode3;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * 
 * 示例 1:
 * 
 * 输入: nums = [2,5,6,0,0,1,2], target = 0 输出: true 示例 2:
 * 
 * 输入: nums = [2,5,6,0,0,1,2], target = 3 输出: false 进阶:
 * 
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class RotateSearch {

	public static boolean search(int[] nums, int target) {
		if (nums.length == 0)
			return false;
		if (nums.length == 1) {
			if (nums[0] == target) {
				return true;
			} else {
				return false;
			}
		}
		if (nums.length == 2) {
			if (nums[0] == target || nums[1] == target) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * 先用2分查找，找到分隔点。
		 */
		int start = 0;
		int end = nums.length - 1;
		int origin;
		while (true) {

			if (end == 0 || start == nums.length - 1) {
				origin = 0;
				break;
			}
			int mid = (start + end) / 2;
			if (mid == 0) {
				if (nums[0] <= nums[1]) {
					origin = 0;
				} else {
					origin = 1;
				}
				break;
			}
			if (mid == nums.length - 1) {
				if (nums[mid] <= nums[mid + 1]) {
					origin = 0;
				} else {
					origin = nums.length - 1;
				}
				break;
			}
			if (mid - 1 > 0)
				if (nums[mid - 1] > nums[mid]) {
					origin = mid;
					break;
				}

			if (mid + 1 < nums.length)
				if (nums[mid] > nums[mid + 1]) {
					origin = mid + 1;
					break;
				}

			if (nums[mid] < nums[0]) {
				end = mid - 1;
			} else if (nums[mid] > nums[0]) {
				start = mid + 1;
			} else {
				if (nums[mid] < nums[nums.length - 1]) {
					end = mid - 1;
				} else if (nums[mid] == nums[nums.length - 1]) {
					/**
					 * 111121111 这种奇葩情况，我只能遍历
					 */
					int cursor = 0;
					while (cursor < nums.length) {
						if (nums[cursor] == target)
							return true;

						cursor++;
					}
					return false;

				} else {
					start = mid + 1;
				}
			}

		}

		/**
		 * 很简单的意思啊，和原题几乎一样，先和第一个元素比较，如果小于第一个元素，那么从最后一个元素开始2分查找，否则，从第一个元素2分比较。
		 */
		if (nums[0] == target)
			return true;
		else if (nums[0] < target) {
			start = 0;
			end = origin - 1;
		} else {
			start = origin;
			end = nums.length - 1;
		}
		if (origin == 0) {
			start = origin;
			end = nums.length - 1;
		}
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target)
				return true;
			else if (nums[mid] < target)
				start = mid + 1;
			else
				end = mid - 1;
		}

		return false;

	}

	public static void main(String[] args) {

		int[] data = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1 };

		System.out.println(search(data, 2));

	}
}
