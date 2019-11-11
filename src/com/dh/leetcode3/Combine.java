package com.dh.leetcode3;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * 示例:
 * 
 * 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class Combine {

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> tempData = new ArrayList<>();
		doHelper(1, k, n, list, tempData, 0);
		return list;
	}

	public static void doHelper(int cursor, int k, int n, List<List<Integer>> list, List<Integer> tempData, int num) {
		if (num == k) {
			list.add(new ArrayList<>(tempData));
		} else {
			for (int i = cursor; i <= n - k + num; i++) {
				tempData.add(i);
				doHelper(i + 1, k, n, list, tempData, num + 1);
				tempData.remove(tempData.size() - 1);
			}
		}

	}

	public static void main(String[] args) {

		System.out.println(combine(20, 16));

	}

}
