package com.dh.leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 
 * 说明：
 * 
 * 所有数字（包括目标数）都是正整数。 解集不能包含重复的组合。  示例 1:
 * 
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8, 所求解集为: [ [1, 7], [1, 2, 5],
 * [2, 6], [1, 1, 6] ] 示例 2:
 * 
 * 输入: candidates = [2,5,2,1,2], target = 5, 所求解集为: [   [1,2,2],   [5] ]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class CombinationSum2 {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> sumList = new ArrayList<>();
		if (candidates.length == 0)
			return sumList;
		Arrays.sort(candidates);
		List<Integer> list = new ArrayList<>();
		Set<String> set = new HashSet<>();
		doHelper(candidates, target, 0, 0, list, sumList, set);
		return sumList;
	}

	public void doHelper(int[] candidates, int target, int sum, int cursor, List<Integer> list,
			List<List<Integer>> sumList, Set<String> set) {
		for (int i = cursor; i < candidates.length; i++) {
			if (sum + candidates[i] < target) {
				list.add(i);
				doHelper(candidates, target, sum + candidates[i], i + 1, list, sumList, set);
				list.remove(list.size() - 1);
			} else if (sum + candidates[i] > target) {
				return;
			} else {
				List<Integer> temp = new ArrayList<>();
				for (Integer j : list)
					temp.add(candidates[j]);
				temp.add(candidates[i]);
				String key = getKey(temp);
				if (!set.contains(key)) {
					sumList.add(temp);
					set.add(key);
				}

				return;
			}
		}
	}

	public static String getKey(List<Integer> temp) {
		StringBuilder sb = new StringBuilder();
		for (Integer i : temp) {
			sb.append(i);
		}
		return sb.toString();

	}
}
