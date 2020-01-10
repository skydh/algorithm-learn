package com.dh.lettcode5;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 * 
 * 示例 1:
 * 
 * 输入: [0,1,2,4,5,7] 输出: ["0->2","4->5","7"] 解释: 0,1,2 可组成一个连续的区间; 4,5
 * 可组成一个连续的区间。 示例 2:
 * 
 * 输入: [0,2,3,4,6,8,9] 输出: ["0","2->4","6","8->9"] 解释: 2,3,4 可组成一个连续的区间; 8,9
 * 可组成一个连续的区间
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/summary-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {

		List<String> result = new ArrayList<>();
		if (nums.length == 0)
			return result;
		else if (nums.length == 1) {
			result.add(String.valueOf(nums[0]));
			return result;
		}
		int start = 0;
		int cursor = 1;
		while (cursor < nums.length)

		{
			if (nums[cursor] - nums[cursor - 1] != 1) {
				if (cursor - 1 == start) {
					result.add(String.valueOf(nums[start]));
				} else {
					StringBuilder sb = new StringBuilder();
					sb.append(String.valueOf(nums[start]));
					sb.append("->");
					sb.append(String.valueOf(nums[cursor - 1]));
					result.add(sb.toString());

				}
				start = cursor;
			}
			cursor++;

		}

		if (start == cursor - 1) {
			result.add(String.valueOf(nums[start]));
		} else if (start < cursor - 1) {
			StringBuilder sb = new StringBuilder();
			sb.append(String.valueOf(nums[start]));
			sb.append("->");
			sb.append(String.valueOf(nums[cursor - 1]));
			result.add(sb.toString());
		}

		return result;

	}
}
