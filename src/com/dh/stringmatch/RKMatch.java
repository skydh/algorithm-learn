package com.dh.stringmatch;

public class RKMatch {

	/**
	 * 被匹配串不是很长的情况
	 * 
	 * @param main
	 * @param follow
	 * @return
	 */
	public boolean RKMatcher(String main, String follow) {

		char[] mainChar = main.toCharArray();

		char[] followChar = follow.toCharArray();
		int lengthDiff = mainChar.length - followChar.length;

		double[] hashInt = new double[lengthDiff + 1];

		/**
		 * 计算这n个串的hash值
		 */
		for (int i = 0; i < lengthDiff + 1; i++) {
			double temp = 0;
			for (int j = 0; j < followChar.length; j++) {
				temp = temp + mainChar[j] * Math.pow(10, j);
			}
			hashInt[i] = temp;
		}

		/**
		 * 计算要匹配的子串
		 */
		double followDouble = 0;
		for (int j = 0; j < followChar.length; j++) {
			followDouble = followDouble + mainChar[j] * Math.pow(10, j);
		}
		/**
		 * 这里特意分开使其更加好理解
		 */
		for (int i = 0; i < lengthDiff + 1; i++) {

			if (hashInt[i] == followDouble) {
				return true;
			}
		}
		return false;
	}

}
