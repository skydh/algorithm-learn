package com.dh.sort.bucket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dh.sort.Sort;
import com.dh.sort.quick.QuickSort;

/**
 * 桶排序就是将数据分成一个个从大到小的桶子里面，然后每个桶子快速排序， 因此时间复杂度趋近于O(n),当然这是有要求的就是，数据分配均匀点
 * 否则就分配不均匀，甚至就分配到一个桶里面，那么就退化为快速排序了。 主要用于外部排序，主要要分析数据的数据的分布，适不适合使用桶排序。
 * 
 * @author Lenovo
 *
 */
public class BucketSort implements Sort {

	public static int bucketNum = 4;

	/**
	 * 分析数据，自定义m个桶，
	 */
	@Override
	public void sort(int[] a, int n) {
		int min = a[0];
		int max = a[0];

		/**
		 * 找出最大值，最小值
		 */
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			} else if (a[i] < min) {
				min = a[i];
			}
		}
		/**
		 * 根据最大最下值确定区间范围
		 */
		int adjective = (max - min) / bucketNum;
		/**
		 * 创建一个长为每个桶大小的，宽为桶数目的2维数组。
		 */
		Integer[][] bucket = new Integer[bucketNum][n];
		/**
		 * 创建一个游标集合
		 */
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		/**
		 * 初始化
		 */
		for (int i = 0; i < bucketNum; i++) {
			map.put(i, 0);
		}

		/**
		 * 将数据放到每个桶里面
		 */
		for (int i = 0; i < a.length; i++) {
			int kuan = (a[i] - min) / adjective;
			if (kuan >= bucketNum)
				kuan = bucketNum - 1;
			int cursor = map.get(kuan);
			bucket[kuan][cursor] = a[i];
			map.put(kuan, cursor + 1);
		}
		/**
		 * 然后对2维数组每一维快速排序喽，看着像n2实则不是，bucketNum是常量。
		 */
		List<Integer> list = null;
		Sort sort = new QuickSort();
		int cursor = 0;
		for (int i = 0; i < bucketNum; i++) {

			list = new ArrayList<Integer>();
			int j = 0;
			for (; j < n; j++) {
				if (bucket[i][j] != null) {

					list.add(bucket[i][j]);
				}
			}
			int[] temp = new int[list.size()];
			for (int k = 0; k < list.size(); k++) {
				temp[k] = list.get(k);
			}

			sort.sort(temp, list.size());
			for (int k = 0; k < list.size(); k++) {
				a[cursor] = temp[k];
				cursor++;
			}
		}

	}

}
