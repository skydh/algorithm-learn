package com.dh.stringmatch;

/**
 * bf 暴力匹配，先判断follow的长度是否大于main,然后从main的第一个字符开始一个个匹配
 * 
 * @author Lenovo
 *
 */
public class BFMatch {

	public boolean BFMatcher(String main, String follow) {

		
		
		char[] mainChar = main.toCharArray();

		char[] followChar = follow.toCharArray();
		int lengthDiff = mainChar.length - followChar.length;
		if (lengthDiff < 0) {
			return false;
		}

		for (int i = 0; i < lengthDiff+1; i++) {
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

}
