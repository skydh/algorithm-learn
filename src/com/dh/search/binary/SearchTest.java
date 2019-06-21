package com.dh.search.binary;

/**
 * 二分查找无论是什么变形种，本质上都是2分后比较大小，直到找到符合条件的，至于相同元素的情况，比如查找第一个出现的元素。你可能二分查找的不是第一个元素，
 * 那么你就判断一下，二分查找到这个元素的前一个元素是否相等，若是相等，那么让high=mid-1,继续二分查找，直到找到一个前面元素也不等于其的元素为止。
 * 其他的变种，比喻查找最后一个元素，那就判断下一个元素，同样的思路，或者查找第一个大于等于这个值的元素。还是二分，小于的没话说，直接low=mid+1;
 * 若是大于这个值，在判断前面的值是否也大于等于value,若是大于等于，那么high=mid-1，继续二分，知道找到前面的值小于value的mid游标。
 * 其余的都差不多吧，本质上都是二分查找，然后判断前一个或者后一个是否满足业务需求
 * 
 * @author Lenovo
 *
 */
public class SearchTest {

	public static void main(String[] args) {
		int[] a = { 1, 3, 4, 5, 9, 9, 9, 9, 534, 62323 };
		FindLastSmallThanSearch simpleBinarySearch = new FindLastSmallThanSearch();
		System.out.println(simpleBinarySearch.search(a, a.length, 534));

	}

}
