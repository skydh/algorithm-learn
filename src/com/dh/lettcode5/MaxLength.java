package com.dh.lettcode5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
 * 
 * 请返回所有可行解 s 中最长长度。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入：arr = ["un","iq","ue"] 输出：4 解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和
 * "ique"，最大长度为 4。 示例 2：
 * 
 * 输入：arr = ["cha","r","act","ers"] 输出：6 解释：可能的解答有 "chaers" 和 "acters"。 示例 3：
 * 
 * 输入：arr = ["abcdefghijklmnopqrstuvwxyz"] 输出：26  
 * 
 * 提示：
 * 
 * 1 <= arr.length <= 16 1 <= arr[i].length <= 26 arr[i] 中只含有小写英文字母
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-
 * with-unique-characters 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class MaxLength {
	public int maxLength(List<String> arr) {

		Iterator<String> iter = arr.iterator();
		while (iter.hasNext()) {
			String temp = iter.next();
			if (!judgeStr(temp))
				iter.remove();
		}
		List<Set<Character>> list = new ArrayList<>(arr.size());
		for (int i = 0; i < arr.size(); i++) {
			Set<Character> set = new HashSet<>();
			for (int j = 0; j < arr.get(i).length(); j++) {
				set.add(arr.get(i).charAt(j));
			}
			list.add(set);
		}

		int[] max = { Integer.MIN_VALUE };
		Set<Character> set = new HashSet<>();
		doHelper(0, list, set, max);
		return max[0];
	}

	public void doHelper(int cursor, List<Set<Character>> list, Set<Character> set, int[] max) {

		if (cursor == list.size()) {
			if (set.size() > max[0])
				max[0] = set.size();
			return;
		}
		boolean isTrue = true;

		for (Character ar : list.get(cursor)) {
			if (set.contains(ar)) {
				isTrue = false;
				break;
			}

		}
		if (isTrue) {
			set.addAll(list.get(cursor));
			doHelper(cursor + 1, list, set, max);
			set.removeAll(list.get(cursor));
		}
		doHelper(cursor + 1, list, set, max);
	}

	public boolean judgeStr(String str) {
		Set<Character> set = new HashSet<>();

		for (int i = 0; i < str.length(); i++) {
			if (set.contains(str.charAt(i)))
				return false;
			set.add(str.charAt(i));
		}
		return true;

	}

	public static void main(String[] args) {

		MaxLength MaxLength = new MaxLength();
		List<String> list = new ArrayList<>();

		list.add("un");
		list.add("iq");
		list.add("ue");
		System.out.println(MaxLength.maxLength(list));
	}
}
