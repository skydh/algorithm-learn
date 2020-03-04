package com.dh.lettcode5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 给定一组 N 人（编号为 1, 2, ..., N）， 我们想把每个人分进任意大小的两组。
 * 
 * 每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 * 
 * 形式上，如果 dislikes[i] = [a, b]，表示不允许将编号为 a 和 b 的人归入同一组。
 * 
 * 当可以用这种方法将每个人分进两组时，返回 true；否则返回 false。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/possible-bipartition
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class PossibleBipartition {

	public boolean possibleBipartition(int N, int[][] dislikes) {
		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
		for (int i = 0; i < dislikes.length; i++) {
			HashSet<Integer> set1 = map.get(dislikes[i][0]);
			if (set1 == null) {
				set1 = new HashSet<>();
				map.put(dislikes[i][0], set1);
			}
			HashSet<Integer> set2 = map.get(dislikes[i][1]);
			if (set2 == null) {
				set2 = new HashSet<>();
				map.put(dislikes[i][1], set2);
			}
			if (!set1.contains(dislikes[i][1])) {
				set1.add(dislikes[i][1]);
			}
			if (!set2.contains(dislikes[i][0])) {
				set2.add(dislikes[i][0]);
			}

		}

		HashSet<Integer> set1 = new HashSet<>();
		HashSet<Integer> set2 = new HashSet<>();

		HashSet<Integer> temp = new HashSet<>();
		for (Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()) {
			if (set1.contains(entry.getKey()) || set2.contains(entry.getKey())) {
				continue;
			}
			set1.add(entry.getKey());
			temp.addAll(entry.getValue());
			if (!doHelper(map, set1, set2, temp))
				return false;

		}

		return true;

	}

	public boolean doHelper(HashMap<Integer, HashSet<Integer>> map, HashSet<Integer> set1, HashSet<Integer> set2,
			HashSet<Integer> temp) {
		HashSet<Integer> temp1 = new HashSet<>();
		temp1.addAll(temp);
		temp1.removeAll(set2);
		if (temp1.size() == 0)
			return true;
		HashSet<Integer> temp4 = new HashSet<>();
		HashSet<Integer> temp5 = new HashSet<>();
		for (int num : temp1) {
			temp5.clear();
			HashSet<Integer> temp3 = map.get(num);
			temp5.addAll(temp3);
			temp5.retainAll(set2);

			if (temp5.size() != 0)
				return false;
			else {
				temp4.addAll(temp3);
				set2.add(num);
			}

		}
		return doHelper(map, set2, set1, temp4);

	}

	public static void main(String[] args) {

		PossibleBipartition sn = new PossibleBipartition();
		int[][] data = { { 1, 2 }, { 1, 3 } };
		System.out.println(sn.possibleBipartition(10, data));
	}

}
