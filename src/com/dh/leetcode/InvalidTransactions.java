package com.dh.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 如果出现下述两种情况，交易 可能无效：
 * 
 * 交易金额超过 ¥1000 或者，它和另一个城市中同名的另一笔交易相隔不超过 60 分钟（包含 60 分钟整）
 * 每个交易字符串 transactions[i] 由一些用逗号分隔的值组成，这些值分别表示交易的名称，时间（以分钟计），金额以及城市。
 * 
 * 给你一份交易清单 transactions，返回可能无效的交易列表。你可以按任何顺序返回答案。
 * 
 * 输入：transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
 * 输出：["alice,20,800,mtv","alice,50,100,beijing"] 解释：第一笔交易是无效的，因为第二笔交易和它间隔不超过 60
 * 分钟、名称相同且发生在不同的城市。同样，第二笔交易也是无效的。
 * 
 * 
 * 
 * @author Lenovo
 *
 */
public class InvalidTransactions {

	public List<String> invalidTransactions(String[] transactions) {
		List<String> result = new ArrayList<>();
		List<String[]> list = new ArrayList<>();
		for (int i = 0; i < transactions.length; i++) {
			String[] str = transactions[i].split(",");
			list.add(str);
		}
		for (int i = 0; i < list.size(); i++) {
			String[] temp = list.get(i);
			if (Integer.parseInt(temp[2]) > 1000) {
				result.add(splice(temp));
				continue;
			}
			for (int j = 0; j < list.size(); j++) {
				String[] newTemp = list.get(j);
				if (temp[0].equals(newTemp[0])
						&& Math.abs(Integer.parseInt(temp[1]) - Integer.parseInt(newTemp[1])) <= 60
						&& !temp[3].equals(newTemp[3])) {
					result.add(splice(temp));
					break;
				}
			}
		}
		return result;
	}

	public String splice(String[] args) {
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < args.length; k++) {
			sb.append(args[k]);
			if (k != args.length - 1)
				sb.append(",");
		}
		return sb.toString();
	}

	public static void main(String[] arg) {

		InvalidTransactions invalidTransactions = new InvalidTransactions();

		String[] transactions = { "bob,689,1910,barcelona", "alex,696,122,bangkok", "bob,832,1726,barcelona",
				"bob,820,596,bangkok", "chalicefy,217,669,barcelona", "bob,175,221,amsterdam" };
		System.out.println(invalidTransactions.invalidTransactions(transactions));
	}
}
