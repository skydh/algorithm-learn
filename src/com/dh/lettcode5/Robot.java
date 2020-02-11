package com.dh.lettcode5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 力扣团队买了一个可编程机器人，机器人初始位置在原点(0,
 * 0)。小伙伴事先给机器人输入一串指令command，机器人就会无限循环这条指令的步骤进行移动。指令有两种：
 * 
 * U: 向y轴正方向移动一格 R: 向x轴正方向移动一格。 不幸的是，在 xy
 * 平面上还有一些障碍物，他们的坐标用obstacles表示。机器人一旦碰到障碍物就会被损毁。
 * 
 * 给定终点坐标(x, y)，返回机器人能否完好地到达终点。如果能，返回true；否则返回false。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/programmable-robot
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author Lenovo
 *
 */
public class Robot {
	public boolean robot(String command, int[][] obstacles, int x, int y) {

		int sumX = 0;
		int sumY = 0;
		for (int i = 0; i < command.length(); i++) {
			if (command.charAt(i) == 'R')
				sumX++;
			else
				sumY++;
		}

		int n = x / sumX;
		int startX = 0 + n * sumX;
		int startY = 0 + n * sumY;
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < obstacles.length; i++) {
			if (map.get(obstacles[i][0]) == null) {
				List<Integer> list = new ArrayList<>();
				list.add(obstacles[i][1]);
				map.put(obstacles[i][0], list);
			} else {
				map.get(obstacles[i][0]).add(obstacles[i][1]);
			}
		}
		boolean first = false;
		for (int i = 0; i < command.length(); i++) {
			if (!isSuit(map, startX, startY)) {
				return false;
			}
			if (startX == x && startY == y) {
				first = true;
				break;
			}
			if (command.charAt(i) == 'R')
				startX++;
			else
				startY++;
		}
		if (!first) {
			return false;

		}

		/**
		 * 到达终点之前
		 */
		startX = 0;
		startY = 0;
		for (int i = 0; i < command.length(); i++) {
			if (command.charAt(i) == 'R')
				startX++;
			else
				startY++;
			for (int j = 0; j <n; j++) {
				if (!isSuit(map, startX + j * sumX, startY + j * sumY)) {
					return false;
				}

			}

		}
		return true;
	}

	public boolean isSuit(HashMap<Integer, List<Integer>> map, int x, int y) {
		List<Integer> list = map.get(x);
		if (list == null)
			return true;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == y) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Robot robot = new Robot();
		int[][] obstacles = { { 4, 2 } };
		System.out.println(robot.robot("URR", obstacles, 3, 2));

	}

}
