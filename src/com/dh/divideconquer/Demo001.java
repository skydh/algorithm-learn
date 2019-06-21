package com.dh.divideconquer;

/**
 * 利用归并排序来求取逆序度
 * 
 * @author Lenovo
 *
 */
public class Demo001 {
	private int num = 0; // 全局变量或者成员变量

	public int count(int[] a, int n) {
		num = 0;
		mergeSortCounting(a, 0, n - 1);
		return num;
	}

	public int maxW = Integer.MIN_VALUE; // 存储背包中物品总重量的最大值
	// cw 表示当前已经装进去的物品的重量和；i 表示考察到哪个物品了；
	// w 背包重量；items 表示每个物品的重量；n 表示物品个数
	// 假设背包可承受重量 100，物品个数 10，物品重量存储在数组 a 中，那可以这样调用函数：
	// f(0, 0, a, 10, 100)

	public void f(int i, int cw, int[] items, int n, int w) {
		if (cw == w || i == n) { // cw==w 表示装满了 ;i==n 表示已经考察完所有的物品
			if (cw > maxW)
				maxW = cw;
			return;
		}
		f(i + 1, cw, items, n, w);
		if (cw + items[i] <= w) {// 已经超过可以背包承受的重量的时候，就不要再装了
			f(i + 1, cw + items[i], items, n, w);
		}
	}

	private void mergeSortCounting(int[] a, int p, int r) {
		if (p >= r)
			return;
		int q = (p + r) / 2;
		mergeSortCounting(a, p, q);
		mergeSortCounting(a, q + 1, r);
		merge(a, p, q, r);
	}

	private void merge(int[] a, int p, int q, int r) {
		int i = p, j = q + 1, k = 0;
		int[] tmp = new int[r - p + 1];
		while (i <= q && j <= r) {
			if (a[i] <= a[j]) {
				tmp[k++] = a[i++];
			} else {
				num += (q - i + 1); // 统计 p-q 之间，比 a[j] 大的元素个数
				tmp[k++] = a[j++];
			}
		}
		while (i <= q) { // 处理剩下的
			tmp[k++] = a[i++];
		}
		while (j <= r) { // 处理剩下的
			tmp[k++] = a[j++];
		}
		for (i = 0; i <= r - p; ++i) { // 从 tmp 拷贝回 a
			a[p + i] = tmp[i];
		}
	}

}
