package com.dh.lettcode5;

/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * 
 * update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
 * 
 * 示例:
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/range-sum-query-mutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * ps:时间复杂度logn
 * 
 * @author Lenovo
 *
 */
public class NumArray {

	private  int[] tree;
	private int numsLength;

	public NumArray(int[] nums) {
		if (nums.length == 0)
			return;

		this.numsLength = nums.length - 1;
		int length = nums.length;
		int times = 1;
		while (length != 0) {
			length = length / 2;
			times++;
		}
		tree = new int[(1 << times) - 1];
		int mid = (0 + numsLength) / 2;
		int leftNode = buildTree(nums, tree, 1, 0, mid);
		int rightNode = 0;
		if (mid + 1 <= nums.length - 1)
			rightNode = buildTree(nums, tree, 2, mid + 1, nums.length - 1);

		tree[0] = leftNode + rightNode;

	}

	public int buildTree(int[] nums, int[] tree, int target, int start, int end) {

		if (start == end) {
			tree[target] = nums[start];
			return tree[target];
		}
		int mid = (start + end) / 2;
		int leftNode = buildTree(nums, tree, target * 2 + 1, start, mid);
		int rightNode = buildTree(nums, tree, target * 2 + 2, mid + 1, end);
		tree[target] = leftNode + rightNode;
		return tree[target];

	}

	public void update(int i, int val) {
		if (i > numsLength)
			return;
		int mid = (0 + numsLength) / 2;
		int data;
		if (i <= mid)
			data = update(0, mid, 1, i, val);
		else
			data = update(mid + 1, numsLength,2, i, val);
		tree[0] = tree[0] + data;

	}

	public int update(int start, int end, int cursor, int i, int val) {
		if (start == end) {
			int result = val - tree[cursor];
			tree[cursor] = val;
			return result;
		}

		int mid = (start + end) / 2;
		int data;
		if (i <= mid)
			data = update(start, mid, cursor * 2 + 1, i, val);
		else
			data = update(mid + 1, end, cursor * 2 + 2, i, val);
		tree[cursor] = tree[cursor] + data;
		return data;

	}

	public int sumRange(int i, int j) {
		if (i > j || j > numsLength || i < 0)
			return 0;
		int mid = (0 + numsLength) / 2;
		if (mid >= j) {
			/**
			 * 左节点
			 */
			return sumRange(i, j, 0, mid, 1);
		} else if (mid < i) {
			/**
			 * 右节点
			 * 
			 */
			return sumRange(i, j, mid + 1, numsLength, 2);
		} else {
			/**
			 * 都有
			 */
			return sumRange(i, mid, 0, mid, 1) + sumRange(mid + 1, j, mid + 1, numsLength, 2);

		}

	}

	public int sumRange(int i, int j, int start, int end, int cursor) {
		if (i == start && j == end) {
			return tree[cursor];
		}

		int mid = (start + end) / 2;
		if (mid >= j) {
			/**
			 * 左节点
			 */
			/**
			 * 左节点
			 */
			return sumRange(i, j, start, mid, cursor * 2 + 1);
		} else if (mid < i) {
			/**
			 * 右节点
			 * 
			 */
			return sumRange(i, j, mid + 1, end, cursor * 2 + 2);
		} else {
			/**
			 * 都有
			 */
			return sumRange(i, mid, start, mid, cursor * 2 + 1) + sumRange(mid + 1, j, mid + 1, end, cursor * 2 + 2);
		}

	}

	public static void main(String[] args) {
		int[] data = { 9,-8 };

		NumArray t = new NumArray(data);
		System.out.println(t.sumRange(0, 0));
		t.update(1, -3);
		System.out.println(t.sumRange(0, 1));

	}
}