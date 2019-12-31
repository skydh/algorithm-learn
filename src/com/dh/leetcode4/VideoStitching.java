package com.dh.leetcode4;

import java.util.HashMap;

/**
 * 你将会获得一系列视频片段，这些片段来自于一项持续时长为 T 秒的体育赛事。这些片段可能有所重叠，也可能长度不一。
 * 
 * 视频片段 clips[i] 都用区间进行表示：开始于 clips[i][0] 并于 clips[i][1] 结束。我们甚至可以对这些片段自由地再剪辑，
 * 例如片段 [0, 7] 可以剪切成 [0, 1] + [1, 3] + [3, 7] 三部分。
 * 
 * 我们需要将这些片段进行再剪辑，并将剪辑后的内容拼接成覆盖整个运动过程的片段（[0, T]）。返回所需片段的最小数目，如果无法完成该任务，则返回 -1 。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入：clips = [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]], T = 10 输出：3 解释： 我们选中
 * [0,2], [8,10], [1,9] 这三个片段。 然后，按下面的方案重制比赛片段： 将 [1,9] 再剪辑为 [1,2] + [2,8] +
 * [8,9] 。 现在我们手上有 [0,2] + [2,8] + [8,10]，而这些涵盖了整场比赛 [0, 10]。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/video-stitching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class VideoStitching {

	/**
	 * 一个经典的贪婪算法。每次选最大的
	 * 
	 * @param clips
	 * @param T
	 * @return
	 */
	public int videoStitching(int[][] clips, int T) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < clips.length; i++) {
			Integer temp = map.get(clips[i][0]) == null ? 0 : map.get(clips[i][0]);
			if (clips[i][1] > temp)
				map.put(clips[i][0], clips[i][1]);

		}
		int[] data = new int[T];
		return doHelper(map, 0, 0, T, data);

	}

	public int doHelper(HashMap<Integer, Integer> map, int cursor, int count, int T, int[] data) {
		if (data[cursor] != 0) {
			return count + data[cursor];
		}
		Integer temp = map.get(cursor);

		if (temp == null) {
			return -1;
		} else {
			if (temp >= T)
				return count + 1;
			int min = Integer.MAX_VALUE;
			boolean isUse = false;
			while (temp > cursor) {
				int newTemp = doHelper(map, temp, count + 1, T, data);
				if (newTemp != -1) {
					isUse = true;
					min = Math.min(min, newTemp);
				}

				temp--;

			}
			if (isUse) {
				data[temp] = min - count;
				return min;
			} else {
				return -1;
			}

		}

	}

}
