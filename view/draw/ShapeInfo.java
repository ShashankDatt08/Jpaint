package view.draw;

import controller.Point;
import model.ShapeConfiguration;

public class ShapeInfo {
	private ShapeConfiguration shapeConfiguration;
	private Point start, end;

	public ShapeInfo(Point start, Point end, ShapeConfiguration shapeConfiguration) {
		this.start = start;
		this.end = end;
		this.shapeConfiguration = shapeConfiguration;
	}

	public ShapeConfiguration getShapeConfiguration() {
		return shapeConfiguration;
	}

	public Point getStart() {
		return start;
	}

	public Point getEnd() {
		return end;
	}

	public void setStart(Point newStart) {
		this.start = newStart;
	}

	public void setEnd(Point newEnd) {
		this.end = newEnd;
	}

}
