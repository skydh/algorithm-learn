package com.dh.backtracking;

/**
 * 回溯算法解决01背包问题
 * 
 * 值引用是把值传递过去，对方方法只是获取了这个值，然后自己玩自己的。
 * 地址引用是把数据地址传递过去，修改了，会对其有影响
 * 
 * n个物品质量不确定 背包w空间，如何装，使得空间最大。
 * 
 * @
 * author Lenovo
 *
 */
public class BackTrackingFor01 {
	private int[] item;
	private int packageCapacity;

	public BackTrackingFor01(int[] item, int packageCapacity) {
		this.item = item;
		this.packageCapacity = packageCapacity;

	}

	/**
	 * 原本打算是在return的时候，把值放到一个map里面，然后遍历，去除最大值，即可 现在想了下，没必要，加个参数，打印大于这个值的所有情况
	 */
	public void howPut(int max) {
		if (max > packageCapacity)
			return;
		int[] data = new int[item.length];
		int maxWeight = 0;
		putData(0, data, maxWeight, max);

	}

	public void putData(int cursor, int[] data, int maxWeight, int max) {
		if (cursor == item.length) {
			if (maxWeight > max) {
				print(data, maxWeight);
			}
			return;
		}
		if (maxWeight == packageCapacity) {
			print(data, maxWeight);
			return;
		}
		putData(cursor + 1, data, maxWeight, max);

		if (maxWeight + item[cursor] < packageCapacity) {
			/**
			 * 把这个值加进去
			 */
			data[cursor] = 1;
			putData(cursor + 1, data, maxWeight + item[cursor], max);
			/**
			 * 失败则把值取出去
			 */
			data[cursor] = 0;
		}

	}

	public void print(int[] data, int maxWeight) {

		System.out.println(maxWeight + "---------");
		for (int i = 0; i < item.length; i++) {
			System.out.print(data[i] + "  ");
		}
		System.out.println("   ");

	}
}
