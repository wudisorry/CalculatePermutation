package com.arh.test;

import java.util.ArrayList;
import java.util.List;

import com.arh.pojo.Operation;
import com.arh.service.CalculatePermutation;

public class TuziTest {

	public static void main(String[] args) {
		List<Operation[]> l = new ArrayList<>();
		int step = 10;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				for (int x = 0; x < 11; x++) {
					if (i + 2 * j + 3 * x == step) {
						Operation o1 = new Operation("1", i);
						Operation o2 = new Operation("2", j);
						Operation o3 = new Operation("3", x);
						Operation[] ops = new Operation[] { o1, o2, o3 };
						l.add(ops);
					}
				}
			}
		}
		System.out.println(l.size());
		int sum = 0;
		for (Operation[] object : l) {
			List<List<Operation>> ls = CalculatePermutation.outLoop(object);
			sum += ls.size();
		}
		System.out.println(sum);
	}

}
