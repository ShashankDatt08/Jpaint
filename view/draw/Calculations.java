package view.draw;

import static java.lang.Integer.min;
import static java.lang.Math.abs;

import controller.Point;

public class Calculations {
	private Point startPoint;
	private Point endPoint;
	private int x, y, x1, y1;

	public Calculations(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		calculate();
	}

	public void setPoint(Point start, Point end) {
		this.startPoint = start;
		this.endPoint = end;
		calculate();
	}

	private void calculate() {
		x1 = abs(startPoint.getX() - endPoint.getX());
		y1 = abs(startPoint.getY() - endPoint.getY());
		x = min(startPoint.getX(), endPoint.getX());
		y = min(startPoint.getY(), endPoint.getY());

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getx1() {
		return x1;
	}

	public int gety1() {
		return y1;
	}
}
