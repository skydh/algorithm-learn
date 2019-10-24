package com.dh.leetcode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 
 * 示例:
 * 
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"], 输出: [ ["ate","eat","tea"],
 * ["nat","tan"], ["bat"] ] 说明：
 * 
 * 所有输入均为小写字母。 不考虑答案输出的顺序。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> list = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			String key = getKey(strs[i]);
			Integer cursor = map.get(key);
			if (cursor != null) {
				list.get(cursor).add(strs[i]);
			} else {
				List<String> newList = new ArrayList<>();
				newList.add(strs[i]);
				list.add(newList);
				map.put(key, list.size() - 1);

			}

		}
		return list;

	}

	public String getKey(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return String.valueOf(chars);

	}

}
