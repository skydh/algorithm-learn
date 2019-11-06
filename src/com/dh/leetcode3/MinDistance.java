package com.dh.leetcode3;

/**
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 
 * 你可以对一个单词进行如下三种操作：
 * 
 * 插入一个字符 删除一个字符 替换一个字符 示例 1:
 * 
 * 输入: word1 = "horse", word2 = "ros" 输出: 3 解释: horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r') rose -> ros (删除 'e') 示例 2:
 * 
 * 输入: word1 = "intention", word2 = "execution" 输出: 5 解释: intention -> inention
 * (删除 't') inention -> enention (将 'i' 替换为 'e') enention -> exention (将 'n' 替换为
 * 'x') exention -> exection (将 'n' 替换为 'c') exection -> execution (插入 'u')
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class MinDistance {
	/**
	 * 这个是个非常经典的dp算法。 我们来分析分析。 2个字符串都从第一个字符开始比较：
	 * 
	 * 一样的话，字符串都向后位移，则是都加一，1,1
	 * 
	 * 不一样的话，有三个方案。
	 * 
	 * 插入，a字符串插入一个和b字符串一样的字符，1,0 。 删除，a字符串的这个字符， 0,1
	 * 替换，将a字符串的这个字符替换成b字符串的字符，1,1,
	 * 
	 * 
	 * 那么我们得出了一个结论，要想到达 a.length-1,b.length-1,必须从这3个点来。
	 * 
	 * a.length-2,b.length-2， a.length-2,b.length-1，
	 * a.length-1,b.length-2，那么我们综合下，得到了公式如下；
	 * 
	 * 
	 * 
	 * 
	 * dp(i,j)=min(dp(i-1,j-1)+{0,1},dp(i-1,j)+1,dp(i,j-1)+1)
	 * i是字符串1的长度，j是字符串2的长度。
	 * 
	 * 公式都得到了，我们如何解答呢？ 画个状态表就好了。 那么请看代码
	 * 
	 * @param word1
	 * @param word2
	 * @return
	 */
	public static int minDistance(String word1, String word2) {
		if (word1.length() == 0)
			return word2.length();
		if (word2.length() == 0)
			return word1.length();
		int[][] state = new int[word2.length()][word1.length()];
		boolean isUse = false;
		if (word2.charAt(0) == word1.charAt(0)) {
			state[0][0] = 0;
			isUse = true;
		} else {
			state[0][0] = 1;
			isUse = false;
		}

		for (int i = 1; i < word1.length(); i++) {
			if (word1.charAt(i) == word2.charAt(0) && !isUse) {
				isUse = true;
				state[0][i] = state[0][i - 1];
			} else
				state[0][i] = state[0][i - 1] + 1;
		}
		if (word2.charAt(0) == word1.charAt(0)) {

			isUse = true;
		} else {

			isUse = false;
		}
		for (int i = 1; i < word2.length(); i++) {
			if (word2.charAt(i) == word1.charAt(0) && !isUse) {
				isUse = true;
				state[i][0] = state[i - 1][0];
			} else
				state[i][0] = state[i - 1][0] + 1;
		}

		for (int i = 1; i < word2.length(); i++) {
			for (int j = 1; j < word1.length(); j++) {
				if (word1.charAt(j) == word2.charAt(i)) {
					state[i][j] = min(state[i - 1][j - 1], state[i - 1][j] + 1, state[i][j - 1] + 1);
				} else {
					state[i][j] = min(state[i - 1][j - 1] + 1, state[i - 1][j] + 1, state[i][j - 1] + 1);
				}

			}
		}

		return state[word2.length() - 1][word1.length() - 1];

	}

	private static int min(int x, int y, int z) {
		int minv = Integer.MAX_VALUE;
		if (x < minv)
			minv = x;
		if (y < minv)
			minv = y;
		if (z < minv)
			minv = z;
		return minv;
	}

	public static void main(String[] args) {

		System.out.println(minDistance("horse", "ros"));
	}

}
