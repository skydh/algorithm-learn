package com.dh.leetcode4;

/**
 * 给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。
 * 
 * 换句话说，你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，然后该子数组（剩下）
 * 的元素总和是所有子数组之中最大的。
 * 
 * 注意，删除一个元素后，子数组 不能为空。
 * 
 * 请看示例：
 * 
 * 示例 1：
 * 
 * 输入：arr = [1,-2,0,3] 输出：4 解释：我们可以选出 [1, -2, 0, 3]，然后删掉 -2，这样得到 [1, 0, 3]，和最大。
 * 示例 2：
 * 
 * 输入：arr = [1,-2,-2,3] 输出：3 解释：我们直接选出 [3]，这就是最大和。 示例 3：
 * 
 * 输入：arr = [-1,-1,-1,-1] 输出：-1 解释：最后得到的子数组不能为空，所以我们不能选择 [-1] 并从中删去 -1 来得到 0。
 * 我们应该直接选择 [-1]，或者选择 [-1, -1] 再从中删去一个 -1。  
 * 
 * 提示：
 * 
 * 1 <= arr.length <= 10^5 -10^4 <= arr[i] <= 10^4
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray-sum-with-one-deletion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class MaximumSum {

	/**
	 * 遍历数组，记录3个值 第一个值：记录当前最大值， 第二个值，记录当前有增福子序列 第三个值，记录最大的负数，当前增幅子序列里面
	 * 做了不行，不满足部分条件，感觉要dp，重新规划。
	 * 
	 * 
	 * @param arr
	 * @return
	 */
	public int maximumSum(int[] arr) {
		int len = arr.length;
		int[] f = new int[len];
		int[] g = new int[len];
		f[0] = arr[0];
		g[0] = -200001;
		for (int i = 1; i < len; i++) {
			f[i] = Math.max(f[i - 1] + arr[i], arr[i]);// 其实就是f(i-1)是否<0
			g[i] = Math.max(g[i - 1] + arr[i], f[i - 1]);
		}
		
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			res = Math.max(res, Math.max(f[i], g[i]));
		}
		return res;
	}

}
