package com.dh.lettcode5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 你打算利用空闲时间来做兼职工作赚些零花钱。
 * 
 * 这里有 n 份兼职工作，每份工作预计从 startTime[i] 开始到 endTime[i] 结束，报酬为 profit[i]。
 * 
 * 给你一份兼职工作表，包含开始时间 startTime，结束时间 endTime 和预计报酬 profit 三个数组，请你计算并返回可以获得的最大报酬。
 * 
 * 注意，时间上出现重叠的 2 份工作不能同时进行。
 * 
 * 如果你选择的工作在时间 X 结束，那么你可以立刻进行在时间 X 开始的下一份工作。
 * 
 *  
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-profit-in-job-scheduling
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class JobScheduling {
	/**
	 * 
	 * dp算法
	 * 
	 * dp(i)=max{dp(i-1),dp(i-j)+p(j)}
	 * 
	 * @param startTime
	 * @param endTime
	 * @param profit
	 * @return
	 */
	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		if (startTime.length == 0)
			return 0;

		HashMap<Integer, List<Integer>> map = new HashMap<>();
		int minEnd = endTime[0], maxEnd = endTime[0];
		for (int i = 0; i < endTime.length; i++) {
			if (endTime[i] < minEnd) {
				minEnd = endTime[i];
			}
			if (endTime[i] > maxEnd) {
				maxEnd = endTime[i];
			}

			if (map.get(endTime[i]) == null) {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				map.put(endTime[i], list);
			} else {
				map.get(endTime[i]).add(i);
			}
		}
		int[] dp = new int[maxEnd + 1];
		for (int i = 1; i <= maxEnd; i++) {
			List<Integer> list = map.get(i);
			if (list == null) {
				dp[i] = dp[i - 1];
			} else {
				int max = dp[i - 1];
				for (int j = 0; j < list.size(); j++) {
					int cursor = list.get(j);
					int temp = dp[startTime[cursor]] + profit[cursor];
					if (max < temp) {
						max = temp;
					}

				}
				dp[i] = max;

			}

		}

		return 0;

	}

}
