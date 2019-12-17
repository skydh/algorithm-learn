package com.dh.leetcode4;

/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 
 * 每个孩子至少分配到 1 个糖果。 相邻的孩子中，评分高的孩子必须获得更多的糖果。 那么这样下来，老师至少需要准备多少颗糖果呢？
 * 
 * 示例 1:
 * 
 * 输入: [1,0,2] 输出: 5 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。 示例 2:
 * 
 * 输入: [1,2,2] 输出: 4 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class Candy {

	/**
	 * 这个题目一定是dp算法 dp(i) 是第i个同学所分的糖果
	 * 
	 * 我们从第一个开始计算，为1开始计算，后续根据规则
	 * 
	 * 若是大于，则加一，若是等于则为一，若是小于，则为一，不满足条件则或者回退到满足为止
	 * 
	 * @param ratings
	 * @return
	 */
	public int candy(int[] ratings) {
		if (ratings.length == 0)
			return 0;

		int[] dp = new int[ratings.length];
		dp[0] = 1;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1])
				dp[i] = dp[i - 1] + 1;
			else if (ratings[i] == ratings[i - 1])
				dp[i] = 1;
			else {
				dp[i] = 1;

				/**
				 * 傻逼了半天，突然意识到，dp(i-1)为1，要么前面没有值了，要么按照顺序减小，按照顺序减小的，一次加一，直到不满足为止，
				 * 找到要么就是等于。不管了，直接ok 根据这3个情况就可以按照逻辑处理了，即便是dp也要动脑子，。。。
				 */
				if (dp[i - 1] == 1) {
					dp[i - 1] = 2;
					int j = i - 2;
					while (j >= 0) {
						if (ratings[j] > ratings[j + 1])
							if (dp[j] > dp[j +1])
								break;
							else
								dp[j] = dp[j + 1] + 1;
						else
							break;
						j--;
					}

				}
			}

		}
		int sum = 0;

		for (int i = 0; i < dp.length; i++)
			sum = sum + dp[i];

		return sum;

	}

	public static void main(String[] args) {

		Candy cnady = new Candy();
		int[] data = { 1, 2, 87, 87, 87, 2, 1 };
		System.out.println(cnady.candy(data));

	}

}
