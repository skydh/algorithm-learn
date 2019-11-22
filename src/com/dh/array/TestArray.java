package com.dh.array;

public class TestArray {

	public static void main(String[] args) {
		System.out.println(getLength("abcd", "febcf"));
	}

	public static int getLength(String s1, String s2) {
		int max = 0;
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					int cursor1 = i + 1;
					int cursor2 = j + 1;
					int newMax = 1;
					while (cursor1 < s1.length() && cursor2 < s2.length()) {
						if (s1.charAt(cursor1) == s2.charAt(cursor2)) {
							newMax++;
							cursor1++;
							cursor2++;
						} else {
							if (newMax > max)
								max = newMax;
							break;
						}
					}
				}
			}
		}
		return max;
	}
}
