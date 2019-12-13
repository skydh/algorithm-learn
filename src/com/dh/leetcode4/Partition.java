package com.dh.leetcode4;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 
 * 返回 s 所有可能的分割方案。
 * 
 * 示例:
 * 
 * 输入: "aab" 输出: [ ["aa","b"], ["a","a","b"] ]
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class Partition {

	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		List<String> list = new ArrayList<>();
		doHelper(result, s, 0, list);
		return result;
	}

	public void doHelper(List<List<String>> result, String s, int cursor, List<String> list) {
		if (cursor >= s.length()) {
			result.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i + cursor < s.length(); i++) {
			if (isSuit(s, cursor, i + cursor)) {
				list.add(s.substring(cursor, cursor+i+1));
				doHelper(result, s, i + cursor + 1, list);
				list.remove(list.size() - 1);
			}
		}
	}

	/**
	 * 判断字符串是否为回文串
	 * 
	 * @param s
	 * @param i
	 * @param j
	 * @return
	 */
	public boolean isSuit(String s, int i, int j) {
		int end = j;
		while (i <= end) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;

	}

	public static void main(String[] args) {
		Partition pt = new Partition();
		pt.partition("aab");

	}

}
