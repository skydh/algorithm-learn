package com.dh.leetcode4;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 
 * 示例 1:
 * 
 * 输入: "A man, a plan, a canal: Panama" 输出: true 示例 2:
 * 
 * 输入: "race a car" 输出: false
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class IsPalindrome {

	/**
	 * 数字 48-57
	 * 
	 * 大写字母 65-90
	 * 
	 * 小写字母 97-122
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isPalindrome(String s) {

		int start = 0;
		int end = s.length() - 1;
		char[] chars = s.toCharArray();
		int cursor = 0;
		for (int i = 0; i <= end; i++)
			if ((chars[i] <= 90 && chars[i] >= 65) || (chars[i] <= 122 && chars[i] >= 97)
					|| (chars[i] <= 57 && chars[i] >= 48)) {
				chars[cursor] = chars[i];
				cursor++;
			}

		end = cursor-1;
		while (start < cursor) {
			char char1 = chars[start];
			char char2 = chars[end];
			if (char1 <= 57 && char1 >= 48) {
				if (char1 != char2)
					return false;
			}
			if ((char1 <= 90 && char1 >= 65) || (char1 <= 122 && char1 >= 97)) {
				if (char1 >= 97)
					char1 = (char) (char1 - 32);
				if (char2 >= 97)
					char2 = (char) (char2 - 32);
				if (char1 != char2)
					return false;
			}
			start++;
			end--;
			System.out.println("aaa");
		}
		return true;

	}

	public static void main(String[] args) {

		// StringBuilder sb = new StringBuilder("asd123");
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

	}
}
