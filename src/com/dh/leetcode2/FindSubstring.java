package com.dh.leetcode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入： s = "barfoothefoobarman", words = ["foo","bar"] 输出：[0,9] 解释： 从索引 0 和 9
 * 开始的子串分别是 "barfoor" 和 "foobar" 。 输出的顺序不重要, [9,0] 也是有效答案。 示例 2：
 * 
 * 输入： s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出：[]
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class FindSubstring {

	/**
	 * 个人想法意见： 遍历这个字符串，一次3个，然后判断这个字符串是否存在剩下的字符串中。若不满足则是，下一个开始，还要判断长度是否满足
	 * 
	 * @param s
	 * @param words
	 * @return
	 */
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> list = new ArrayList<>();
		if (words.length == 0)
			return list;
		int subLength = words[0].length();
		int allLength = words.length * subLength;
		Map<String, Integer> baseMap = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			if (baseMap.get(words[i]) == null) {
				baseMap.put(words[i], 1);
			} else {
				baseMap.put(words[i], baseMap.get(words[i]) + 1);
			}
		}
		Map<String, Integer> map = new HashMap<>();
		map.putAll(baseMap);
		char[] chars = s.toCharArray();
		for (int i = 0; i <= chars.length - allLength; i++) {
			boolean isMatch = true;
			for (int j = i; j < allLength + i;) {
				String temp = new String(chars, j, subLength);
				if (map.get(temp) != null) {
					if (map.get(temp) == 1) {
						map.remove(temp);
					} else {
						map.put(temp, map.get(temp) - 1);
					}
				} else {
					isMatch = false;
					break;
				}
				j = j + subLength;
			}
			if (isMatch) {
				list.add(i);
			}
			map.clear();
			map.putAll(baseMap);

		}

		return list;

	}

	public static void main(String[] args) {

		String temp = "wordgoodgoodgoodbestword";
		String[] words = { "word", "good", "best", "good" };

		System.out.println(findSubstring(temp, words));

	}
}
