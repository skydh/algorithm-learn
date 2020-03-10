package com.dh.lettcode5;

import java.util.ArrayList;
import java.util.List;

/**
 * just for test
 * 
 * @author Lenovo
 *
 */
public class Test {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(2);
		list.add(2);
		list.add(4);
		list.add(6);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		List<Integer> result = new ArrayList<>();

		int max = 0;
		int currentMax = 1;
		int current = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			System.out.println("list.get(i)=  " + list.get(i) + "currentMax=  " + currentMax + " current =  " + current
					+ " max =  " + max);
			if (list.get(i) == current)
				currentMax++;
			else {
				if (currentMax > max) {
					result.clear();
					result.add(current);
					max = currentMax;
					current = list.get(i);
					currentMax = 1;

				} else if (currentMax == max) {

					result.add(current);
					current = list.get(i);
					currentMax = 1;
				} else {
					current = list.get(i);
					currentMax = 1;
				}

			}

		}
		if (currentMax > max) {
			result.clear();
			result.add(current);

		} else if (currentMax == max) {
			result.add(current);
		}
	}

}
