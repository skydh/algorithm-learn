package com.dh.leetcode2;

import java.util.ArrayList;
import java.util.List;

/**
 * #42
 * 
 * @author Lenovo
 *
 */
public class Trap {
	/**
	 * 我是这么思索的，一个栈，2个指针指向初始位置，开始遍历，若是小于上一个值，则将其不断加入到栈里面，
	 * 反之，则开始计算容积，遍历这个栈，同时找到第二小的值，作为基准点，计算，最后，若是，这个值大于最大的值，则清空栈，加入这个值，反之直接加入。
	 * 
	 * @param height
	 * @return
	 */
	public int trap(int[] height) {
		if (height.length == 0)
			return 0;
		int sum = 0;
		List<Integer> list = new ArrayList<>();
		list.add(height[0]);
		for (int i = 1; i < height.length; i++) {
			if (height[i] <= height[i - 1]) {
				list.add(height[i]);
			} else {
				int second = 0;
				for (int j = list.size() - 1; j >= 0; j--) {
					if (j + 1 < list.size() && list.get(j + 1) > height[i])
						break;
					else {
						if (list.get(j) > second) {
							sum = sum + (Math.min(list.get(j), height[i]) - second) * (list.size() - j - 1);
							second = list.get(j);
						}
					}
				}
				if (height[i] > list.get(0))
					list.clear();
				list.add(height[i]);
			}

		}

		return sum;

	}
}
