package com.kavinschool.examples;

public class Calc {
	private double x, y;

	public Calc(double a, double b) {
		x = a;
		y = b;
	}

	public double add() {
		return x + y;
	}

	public double mul() {
		return x * y;
	}

	public double sub() {
		return x - y;
	}

	public double div() {
		return x / y;
	}

	public double rem() {
		return x % y;
	}

	public double cube() {
		return x * x * x;
	}

	public double square() {
		return x * x;
	}

	public double pow() {
		return (int) x ^ (int) y;
	}

	public double square4() {
		return square() * square();
	}

}