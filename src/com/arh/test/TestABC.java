package com.arh.test;

import java.util.List;

import com.arh.pojo.Operation;
import com.arh.service.CalculatePermutation;

/**
 * demo
 * @author Chen
 *
 */
public class TestABC {

	public static void main(String[] args) {
		Operation oA = new Operation("A", 1);
		Operation oB = new Operation("B", 1);
		Operation oC = new Operation("C", 1);
		List<List<Operation>> ls = CalculatePermutation.outLoop(new Operation[] { oA, oB, oC });
		CalculatePermutation.displayList(ls);
	}

}
