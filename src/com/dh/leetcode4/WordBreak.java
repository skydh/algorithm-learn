package com.dh.leetcode4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 
 * 说明：
 * 
 * 拆分时可以重复使用字典中的单词。 你可以假设字典中没有重复的单词。 示例 1：
 * 
 * 输入: s = "leetcode", wordDict = ["leet", "code"] 输出: true 解释: 返回 true 因为
 * "leetcode" 可以被拆分成 "leet code"。 示例 2：
 * 
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"] 输出: true 解释: 返回 true 因为
 * "applepenapple" 可以被拆分成 "apple pen apple"。   注意你可以重复使用字典中的单词。 示例 3：
 * 
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"] 输出:
 * false
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class WordBreak {

	
	/**
	 * 暴力方法不行哦
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
		HashMap<Character, List<String>> map = new HashMap<>();
		for (String str : wordDict) {
			List<String> list = map.get(str.charAt(0));
			if (list != null)
				list.add(str);
			else {
				list = new ArrayList<>();
				list.add(str);
				map.put(str.charAt(0), list);
			}
		}

		return doHelper(map, s, 0);

	}

	public boolean doHelper(HashMap<Character, List<String>> map, String s, int cursor) {
		if (cursor >= s.length())
			return true;

		List<String> list = map.get(s.charAt(cursor));
		if (list == null)
			return false;
		for (String str : list) {
			if (str.length() > s.length() - cursor)
				continue;
			if (str.equals(s.substring(cursor, cursor + str.length()))) {
				boolean isSuit = doHelper(map, s, cursor + str.length());
				if (isSuit)
					return true;
			}

		}

		return false;

	}

	public static void main(String[] args) {

		WordBreak wb = new WordBreak();
		List<String> list = new ArrayList<>();
		list.add("lett");
		list.add("code");
		String a = "bccdbacdbdacddabbaaaadababadad";
		System.out.println(wb.wordBreak(a, list));

	}

}
