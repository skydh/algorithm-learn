package com.dh.leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的数字可以无限制重复被选取。
 * 
 * 说明：
 * 
 * 所有数字（包括 target）都是正整数。 解集不能包含重复的组合。  示例 1:
 * 
 * 输入: candidates = [2,3,6,7], target = 7, 所求解集为: [ [7], [2,2,3] ] 示例 2:
 * 
 * 输入: candidates = [2,3,5], target = 8, 所求解集为: [   [2,2,2,2],   [2,3,3],  
 * [3,5] ]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> sumList = new ArrayList<>();
		if (candidates.length == 0)
			return sumList;
		Arrays.sort(candidates);
		List<Integer> list = new ArrayList<>();
		doHelper(candidates, target, 0, 0, list, sumList);
		return sumList;

	}

	public void doHelper(int[] candidates, int target, int sum, int cursor, List<Integer> list,
			List<List<Integer>> sumList) {
		for (int i = cursor; i < candidates.length; i++) {
			if (sum + candidates[i] < target) {
				list.add(i);
				doHelper(candidates, target, sum + candidates[i], i, list, sumList);
				list.remove(list.size() - 1);
			} else if (sum + candidates[i] > target) {
				return;
			} else {
				List<Integer> temp = new ArrayList<>();
				for (Integer j : list)
					temp.add(candidates[j]);
				temp.add(candidates[i]);
				sumList.add(temp);
				return;

			}

		}

	}

}
