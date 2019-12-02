package com.dh.leetcode4;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 3 输出: [1,3,3,1] 进阶：
 * 
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class GetRow {

	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<>();
		if (rowIndex < 0)
			return list;
		list.add(1);
		if (rowIndex == 0)
			return list;
		list.add(1);
		if (rowIndex == 1)
			return list;

		return doHelper(2, rowIndex, list);

	}

	public List<Integer> doHelper(int cursor, int rowIndex, List<Integer> list) {
		if (cursor > rowIndex)
			return list;

		List<Integer> temp = new ArrayList<>();
		temp.add(1);
		for (int i = 1; i < list.size(); i++)
			temp.add(list.get(i) + list.get(i - 1));

		temp.add(1);
		list = null;
		return doHelper(cursor + 1, rowIndex, temp);
	}

}
