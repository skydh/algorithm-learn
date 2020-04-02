package com.dh.lettcode5;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一副牌，每张牌上都写着一个整数。
 * 
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 * 
 * 每组都有 X 张牌。 组内所有的牌上都写着相同的整数。 仅当你可选的 X >= 2 时返回 true。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class HasGroupsSizeX {
	public boolean hasGroupsSizeX(int[] deck) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < deck.length; i++) {
			Integer temp = map.get(deck[i]);
			if (temp == null) {
				temp = 0;
			}
			map.put(deck[i], temp + 1);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			min = Math.min(entry.getValue(), min);
		}
		int cursor = 2;
		while (cursor <= min) {
			boolean isRight = true;
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if (entry.getValue() % cursor != 0)
					isRight = false;
			}
			if (isRight)
				return true;
		}

		return false;
	}
}
