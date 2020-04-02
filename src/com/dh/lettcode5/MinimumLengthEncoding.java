package com.dh.lettcode5;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 * 
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0,
 * 2, 5]。
 * 
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 * 
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 * 
 *  
 * 
 * 示例：
 * 
 * 输入: words = ["time", "me", "bell"] 输出: 10 说明: S = "time#bell#" ， indexes =
 * [0, 2, 5] 。  
 * 
 * 提示：
 * 
 * 1 <= words.length <= 2000 1 <= words[i].length <= 7 每个单词都是小写字母 。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/short-encoding-of-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class MinimumLengthEncoding {

	class TrieNode {
		TreeNode[] data = new TreeNode[26];
	}

	public int minimumLengthEncoding(String[] words) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			list.add(words[i]);
		}
		int result = 0;
		while (list.size() > 0) {
			String maxLength = getMaxLength(list);
			result = result + maxLength.length() + 1;
			for (int i = list.size() - 1; i >= 0; i--) {
				int cursorA = maxLength.length() - 1;
				String str = list.get(i);
				int cursorB = str.length() - 1;
				boolean isSuit = true;
				while (cursorB >= 0) {
					if (maxLength.charAt(cursorA) != str.charAt(cursorB)) {
						isSuit = false;
						break;
					}
					cursorB--;
					cursorA--;
				}
				if (isSuit)
					list.remove(i);

			}

		}
		return result;

	}

	// public int minimumLengthEncoding(String[] words) {
	// List<String> list = new ArrayList<>();
	// for (int i = 0; i < words.length; i++) {
	// list.add(words[i]);
	// }
	// int result = 0;
	// while (list.size() > 0) {
	// String maxLength = getMaxLength(list);
	// result = result + maxLength.length() + 1;
	// for (int i = list.size() - 1; i >= 0; i--) {
	// int cursorA = maxLength.length() - 1;
	// String str = list.get(i);
	// int cursorB = str.length() - 1;
	// boolean isSuit = true;
	// while (cursorB >= 0) {
	// if (maxLength.charAt(cursorA) != str.charAt(cursorB)) {
	// isSuit = false;
	// break;
	// }
	// cursorB--;
	// cursorA--;
	// }
	// if (isSuit)
	// list.remove(i);
	//
	// }
	//
	// }
	// return result;
	//
	// }

	public String getMaxLength(List<String> list) {
		int cursor = 0;
		int maxLength = list.get(0).length();
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).length() > maxLength) {
				cursor = i;
				maxLength = list.get(i).length();
			}

		}

		String result = list.remove(cursor);
		return result;

	}

}
