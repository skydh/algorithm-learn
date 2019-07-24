package com.dh.stringmatch;

/**
 * bf 暴力匹配，先判断follow的长度是否大于main,然后从main的第一个字符开始一个个匹配 也叫做朴素字符串匹配算法。
 * 
 * @author Lenovo
 *
 */
public class BFMatch {

	/**
	 * 第一次实现
	 * 
	 * @param main
	 * @param follow
	 * @return
	 */
	public boolean BFMatcher(String main, String follow) {
		char[] mainChar = main.toCharArray();
		char[] followChar = follow.toCharArray();
		int lengthDiff = mainChar.length - followChar.length;
		if (lengthDiff < 0) {
			return false;
		}
		for (int i = 0; i < lengthDiff + 1; i++) {
			boolean flag = true;
			for (int j = 0; j < followChar.length; j++) {
				if (mainChar[i + j] != followChar[j]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 第二次实现，虽然这个算法很简单，但是talk is cheap ,show me the code
	 * 
	 * @param main
	 * @param follow
	 * @return
	 */
	public boolean isMatch(String main, String follow) {
		/**
		 * 首先转换为字符数组
		 */
		char[] mainChars = main.toCharArray();
		char[] followChars = follow.toCharArray();
		if (followChars.length > mainChars.length) {
			return false;
		}
		for (int i = 0; i <= mainChars.length - followChars.length; i++) {
			boolean isMatch = true;
			for (int j = 0; j < followChars.length; j++) {
				if (followChars[j] != mainChars[i + j]) {
					isMatch = false;
					break;
				}
			}
			if (isMatch) {
				return true;
			}

		}
		return false;
	}

}
