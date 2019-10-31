package com.dh.leetcode2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * 
 * "123" "132" "213" "231" "312" "321" 给定 n 和 k，返回第 k 个排列。
 * 
 * 说明：
 * 
 * 给定 n 的范围是 [1, 9]。 给定 k 的范围是[1,  n!]。 示例 1:
 * 
 * 输入: n = 3, k = 3 输出: "213" 示例 2:
 * 
 * 输入: n = 4, k = 9 输出: "2314"
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class GetPermutation {
	public String getPermutation(int n, int k) {
		if(n==1)
			return "1";
		Map<Integer, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new LinkedList<>();
		int mux = 1;
		for (int i = 1; i < n; i++) {
			mux = mux * i;
			map.put(i, mux);
		}
		int tempK = k;
		int cursor = n - 1;
		int tempData = map.get(cursor);
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		while (true) {
			if (list.size() == 1) {
				sb.append(list.get(0));
				break;
			}
			if (tempK / tempData > 0) {
				int temp = tempK / tempData;
				if (tempK % tempData == 0) {
					sb.append(list.get(temp - 1));
					for (int i = list.size() - 1; i >= 0; i--) {
						if (i != temp - 1) {
							sb.append(list.get(i));
						}
					}
					break;
				}
				sb.append(list.get(temp));
				list.remove(temp);
				tempK = tempK % tempData;
				cursor--;
				tempData = map.get(cursor);

			} else {
				sb.append(list.get(0));
				list.remove(0);
				cursor--;
				tempData = map.get(cursor);
			}

		}

		return sb.toString();

	}

}
