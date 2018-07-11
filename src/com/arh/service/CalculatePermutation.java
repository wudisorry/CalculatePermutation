package com.arh.service;

import java.util.ArrayList;
import java.util.List;

import com.arh.pojo.Operation;

public class CalculatePermutation {

	public static void displayList(List<List<Operation>> result) {
		System.out.println("The number of result: " + result.size());
		for (List<Operation> sequence : result) {
			System.out.println(sequence);
		}
	}

	public static List<List<Operation>> outLoop(Operation[] ops) {
		List<List<Operation>> results = new ArrayList<>();
		for (int i = 0; i < ops.length; i++) {
			int depth = 0;
			initTempNumberOfAllOperations(ops);
			if (!ops[i].isAliveByTempNumber()) {
				continue;
			}
			List<Operation> sequence = new ArrayList<>();
			sequence.add(ops[i]);
			ops[i].reduceTempNumber();
			innerLoop(ops, depth, sequence, results);
		}
		return results;
	}

	private static boolean innerLoop(Operation[] ops, int depth, List<Operation> sequence,
			List<List<Operation>> results) {
		boolean flag = false;
		depth++;
		for (int i = 0; i < ops.length; i++) {

			if (ops[i].isAliveByTempNumber()) {
				sequence.add(ops[i]);
				ops[i].reduceTempNumber();
				if (sequence.size() < totalNumber(ops)) {
					boolean result = innerLoop(ops, depth, sequence, results);
					if (result) {
						sequence.remove(sequence.size() - 1);
						ops[i].increaseTempNumber();
						if (isLastOperation(i, ops)) {
							flag = true;
							return flag;
						}
					}
				} else {
					List<Operation> oneResult = new ArrayList<>(sequence);
					results.add(oneResult);
					Operation lastOp = sequence.remove(sequence.size() - 1);
					lastOp.increaseTempNumber();
					flag = true;
					return flag;
				}

			}

		}
		return flag;
	}

	private static void initTempNumberOfAllOperations(Operation[] ops) {
		for (Operation operation : ops) {
			operation.initTempNumber();
		}
	}

	private static int totalNumber(Operation[] ops) {
		int result = 0;
		for (Operation operation : ops) {
			result += operation.getNumber();
		}
		return result;
	}

	private static boolean isLastOperation(int index, Operation[] ops) {
		boolean result = true;
		for (int i = index + 1; i < ops.length; i++) {
			if (ops[i].isAliveByTempNumber()) {
				result = false;
				break;
			}
		}
		return result;
	}
}
