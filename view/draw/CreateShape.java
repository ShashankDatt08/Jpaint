package view.draw;

import java.awt.Graphics2D;

import controller.Point;
import model.ShapeColor;
import model.ShapeConfiguration;
import model.ShapeShadingType;
import model.interfaces.IShapeShadingType;
import view.gui.PaintCanvas;

public abstract class CreateShape {
	public Point startPoint;
	public Point endPoint;
	public IShapeShadingType strategy;
	public Graphics2D graphics2d;
	public ShapeColor secondaryColor;
	public ShapeConfiguration config;
	public PaintCanvas paintCanvas;
	public ShapeShadingType shadingType;
	public ShapeColor primaryColor;

	public CreateShape(ShapeInfo shapeInfo, PaintCanvas paintCanvas) {
		this.startPoint = shapeInfo.getStart();
		this.endPoint = shapeInfo.getEnd();
		graphics2d = paintCanvas.getGraphics2D();
		this.config = shapeInfo.getShapeConfiguration();
		this.shadingType = shapeInfo.getShapeConfiguration().getShadingType();
		this.paintCanvas = paintCanvas;
		this.secondaryColor = shapeInfo.getShapeConfiguration().getActiveSecondaryColor();
		this.primaryColor = shapeInfo.getShapeConfiguration().getActivePrimaryColor();
	}

	public abstract void draw();
	
	public abstract void outlineSelect();

	public abstract CreateShape createShape();

	public Graphics2D getGraphics2d() {
		return graphics2d;
	}

	public ShapeColor getSecondaryColor() {
		return secondaryColor;
	}

	public ShapeColor getPrimaryColor() {
		return primaryColor;
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public PaintCanvas getPaintCanvas() {
		return paintCanvas;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public String toString() {
		return "Shape " + startPoint.toString();
	}

	public void translate(int deltaX, int deltaY) {
		startPoint = new Point(startPoint.getX() + deltaX, startPoint.getY() + deltaY);
		endPoint = new Point(endPoint.getX() + deltaX, endPoint.getY() + deltaY);
	}

	public void setStartPoint(Point start) {
		this.startPoint = start;
	}

	public void setEndPoint(Point end) {
		this.endPoint = end;
	}
}
