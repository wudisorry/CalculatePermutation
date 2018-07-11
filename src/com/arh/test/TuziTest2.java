package com.arh.test;

public class TuziTest2 {

	public static void main(String[] args) {
		System.out.println(fun(10));
	}

	public static int fun(int n) {
		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		} else if (n == 3) {
			return 4;
		}
		return fun(n - 1) + fun(n - 2) + fun(n - 3);
	}
}
