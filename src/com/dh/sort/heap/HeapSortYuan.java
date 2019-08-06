package com.dh.sort.heap;

/**
 * 本质上是一个完全二叉树，有大顶树（父节点大于子节点），小顶树（父节点小于总结点）
 * 
 * 作用： 1.多个有序文件排序，我们可以使用归并排序的思想，但是我们维护的不是数组，而是一个堆，如此效率高很多。
 * 2.定时器，多个定时器任务做成一个小顶堆，定时器则不用时时去更新了。 上面2个都是优先队列。
 * 3求top10算法，静态数据求去前10，先让前10个数据堆化，小顶堆，然后依次遍历数组和堆顶元素比较大小即可。大则删除堆顶元素，且让该元素汝堆。
 * 对于动态数据来说，有2个接口，一个接口是持续询问前10的数据，衣蛾接口不断插入数据，那么除了初始化时采用静态数据堆化的策略。
 * 后续每个插入的数据都要判断是否入堆即可。
 * 
 * 4求取中位数，静态数据求取中位数很简单，我们先排序，在获取，但是动态数据如何获取呢？
 * 将数据排序后划分为2个堆，前半部分是大顶堆，后半部分是小顶堆，大顶堆数据>=小顶堆数据，因此中位数就是大顶堆元素。插入元素，
 * 若是小于等于大顶堆的堆顶元素则将值放到大顶堆里面，反之则加入到小顶堆里面，若是数据分布不满足我上述的规则了，那么将堆顶元素一个个迁移。
 * 同理这个不只是可以求取中位数，也可以求取其他比例的数据。
 * 
 * 
 * 大小为5g的搜索日志，我们要选出前10的搜索关键词。内存只有1g,方案把这遍历该文件将每一个词先根据hash算法分为平均分为10个文件，
 * 然后每个文件用hashmap存储， 然后遍历这个hashmap，制作一个大小为10的小顶堆，然后把这10个小顶堆，然后取出10个即可。
 * 
 * @author Lenovo
 *
 */
public class HeapSortYuan {

	public int[] a;
	public int total;
	public int count;

	public HeapSortYuan(int capacity) {
		a = new int[capacity + 1];
		total = capacity;
		count = 0;

	}

	/**
	 * 堆排序中我们插入数据放在最后一层。由于是大顶树，我们这里有类似红黑树的调整，但是相对而言还是蛮简单的调整。就是不断向上改进。
	 * 
	 * @param a
	 */
	public void insert(int data) {
		if (count >= total)
			return;
		count++;
		a[count] = data;
		int i = count;
		while (a[i / 2] < a[i] && i / 2 > 0) {
			swap(a, i, i / 2);
			i = i / 2;
		}

	}

	/**
	 * 交换元素。
	 * 
	 * @param a
	 * @param point0
	 * @param point1
	 */
	public void swap(int[] a, int point0, int point1) {
		int temp = a[point0];
		a[point0] = a[point1];
		a[point1] = temp;
	}

	/**
	 * 这里我们假设你删除的是你知道的index的点，比如，删除堆顶元素，index就是1，删除最后一个元素则是count.
	 * 
	 * @param index
	 */
	public void deleteValue(int index) {
		if (count == 0)
			return;
		if (index == count) {
			count--;
			return;
		}
		a[index] = a[count];
		count--;
		/**
		 * 从上到下遍历，直到遇到不交换数据的为止
		 */
		while (true) {
			int maxPos = index;
			if (index * 2 <= count && a[index] < a[index * 2])
				maxPos = index * 2;
			if (index * 2 + 1 <= count && a[maxPos] < a[index * 2 + 1])
				maxPos = index * 2 + 1;
			if (maxPos == index)
				break;
			swap(a, index, maxPos);
			index = maxPos;
		}

	}

	/**
	 * 
	 * 有2个实现方式，第一个就是就是按照插入的方法，吧数组的元素一个个插进去，时间复杂度较高nlogn
	 * 
	 * 第二个则不是，我们自低向上，从非叶子节点开始计算起。
	 * 把数组重建为一个堆 时间复杂度不是nlogn而是n,可以计算。
	 * 
	 * @param a
	 * @param n
	 */
	public void buildHeap(int[] a, int n) {
		for (int i = n / 2; i >= 1; --i) {
			heapify(a, n, i);
		}
	}

	/**
	 * 就是节点不断下降的过程，使其满足堆的结构。
	 * @param a
	 * @param n
	 * @param i
	 */
	public void heapify(int[] a, int n, int i) {
		while (true) {
			int maxPos = i;
			if (i * 2 <= n && a[i] < a[i * 2])
				maxPos = i * 2;
			if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1])
				maxPos = i * 2 + 1;
			if (maxPos == i)
				break;
			swap(a, i, maxPos);
			i = maxPos;
		}
	}

	// n 表示数据的个数，数组 a 中的数据从下标 1 到 n 的位置。
	public void sort(int[] a, int n) {
		buildHeap(a, n);
		int k = n;
		while (k > 1) {
			swap(a, 1, k);
			--k;
			heapify(a, k, 1);
		}
	}

}
