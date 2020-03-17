package com.dh.lettcode5;

/**
 * 有 N 堆石头排成一排，第 i 堆中有 stones[i] 块石头。
 * 
 * 每次移动（move）需要将连续的 K 堆石头合并为一堆，而这个移动的成本为这 K 堆石头的总数。
 * 
 * 找出把所有石头合并成一堆的最低成本。如果不可能，返回 -1 。
 * 
 *  
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-cost-to-merge-stones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class MergeStones {
	/**
	 * too hard 暂时放弃
	 * 
	 * @param stones
	 * @param K
	 * @return
	 */
	public int mergeStones(int[] stones, int K) {
		/**
		 * 先判断是否可以组成一个数
		 */
		int length = stones.length;
		while (length < K) {
			length = length / K + length % K;
		}
		if (length != 1)
			return -1;
		return K;

	}

}
