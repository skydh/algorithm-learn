package com.dh.dynamic;

/**
 * 用动态规划处理Levenshtein距离，2个字符串之间的距离 所有的动态规划都是可以用回溯算法解决的。
 * 
 * 我们分析算法时，先看看是否可以用回溯算法，解决，然后判断是否存在重复子问题，若存在，要么加个备忘录，要么继续分析使用动态规划来解决。
 * 
 * 好烦躁，有大佬知道如何租房吗，难受，租的都是差房子
 * 
 * 
 * 还是写代码舒服。没那么多套路，祝那些赚黑心钱的人早日去死。
 * 
 * 开始代码设计：2个字符串啊，比对啊 2个指针，当一样时，2个指针都加1，不一样时，不一样时，其中一个指针就要向前走一步。或者替换后，2个都往前走一步
 * 而求取2个字符串的levenshtein距离，就是2个指针都要走到尾部
 * 
 * 我们可以得出一个公式 x(i,j)=min(x(i-1,j-1),x(i-1,j)+1,x(i,j-1)+1)
 * 
 * @author Lenovo
 *
 */
public class DynamicForLevenshtein {

	public int getNum(String s1, String s2) {
		if (s1.length() == 0)
			return s2.length();
		if (s2.length() == 0)
			return s1.length();
		char[] charS1 = s1.toCharArray();
		char[] charS2 = s2.toCharArray();

		/**
		 * 根据前面的公式，我们要构建一个 n*m的矩阵。然后初始化值 然后都是从1开始
		 * 
		 */
		int[][] tempArray = new int[charS1.length][charS2.length];
		int defaultValue = 0;
		if (charS1[0] != charS2[0])
			defaultValue = 1;
		for (int i = 0; i < charS1.length; i++) {
			tempArray[0][i] = defaultValue++;
		}
		for (int i = 0; i < charS2.length; i++) {
			tempArray[i][0] = defaultValue++;
		}

		for (int i = 1; i < charS1.length; i++) {
			for (int j = 1; j < charS2.length; j++) {
				if (charS1[i] == charS2[j]) {
					/**
					 * 要么直接不算值，直接过去，要么从另外2个点进来。
					 */
					tempArray[i][j]=getMin(tempArray[i - 1][j]+1,tempArray[i][j - 1]+1,tempArray[i-1][j-1]);
				} else {
					tempArray[i][j]=getMin(tempArray[i - 1][j]+1,tempArray[i][j - 1]+1,tempArray[i-1][j-1]+1);
				}

			}
		}
		return 0;
	}

	public int getMin(int x, int y, int z) {
		int min = x;
		if (min > y)
			min = y;
		if (min > z)
			min = z;
		return min;
	}
}
