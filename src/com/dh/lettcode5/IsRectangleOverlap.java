package com.dh.lettcode5;

/**
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
 * 
 * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 * 
 * 给出两个矩形，判断它们是否重叠并返回结果
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/rectangle-overlap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class IsRectangleOverlap {

	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
		if ((rec2[0] >= rec1[0] && rec2[0] < rec1[2]) || (rec2[2] > rec1[0] && rec2[2] <= rec1[2])
				|| (rec2[0] <= rec1[0] && rec2[2] >= rec1[2])) {
			
			if ((rec2[1] >= rec1[1] && rec2[1] < rec1[3]) || (rec2[3] > rec1[1] && rec2[3] <= rec1[3])
					|| (rec2[1] <= rec1[1] && rec2[3] >= rec1[3])) {
				return true;
			}

		}

		return false;

	}

}
