package view.draw;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import controller.Point;
import model.ShapeConfiguration;
import view.gui.PaintCanvas;

public class Rectangle extends CreateShape {

	public Rectangle(ShapeInfo info, PaintCanvas paintCanvas) {
		super(info, paintCanvas);
	}

	private ShapeColorMap colorMap = ShapeColorMap.getInstance();

	@Override
	public CreateShape createShape() {
		return new Rectangle(new ShapeInfo(new Point(this.startPoint.getX(), this.startPoint.getY()),
				new Point(this.endPoint.getX(), this.endPoint.getY()),
				new ShapeConfiguration(this.config.getActivePrimaryColor(), this.config.getActiveSecondaryColor(),
						this.config.getShapeType(), this.config.getShadingType())),
				this.paintCanvas);
	}

	public void draw() {
		switch (this.shadingType) {
		case FILLED_IN:
			Calculations calc = new Calculations(this.getStartPoint(), this.getEndPoint());
			Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.fillRect(calc.getX(), calc.getY(), calc.getx1(), calc.gety1());
			break;
		case OUTLINE:
			Calculations calculation = new Calculations(this.getStartPoint(), this.getEndPoint());
			Graphics2D graphicss2D = this.getPaintCanvas().getGraphics2D();
			graphicss2D.setStroke(new BasicStroke(5));
			graphicss2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphicss2D.drawRect(calculation.getX(), calculation.getY(), calculation.getx1(), calculation.gety1());
			break;
		case OUTLINE_AND_FILLED_IN:
			Calculations calculations = new Calculations(this.getStartPoint(), this.getEndPoint());
			Graphics2D graphicsss2D = this.getPaintCanvas().getGraphics2D();
			graphicsss2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphicsss2D.fillRect(calculations.getX(), calculations.getY(), calculations.getx1(), calculations.gety1());
			graphicsss2D.setStroke(new BasicStroke(5));
			graphicsss2D.setColor(colorMap.get(this.getSecondaryColor()));
			graphicsss2D.drawRect(calculations.getX(), calculations.getY(), calculations.getx1(), calculations.gety1());
			break;
		default:
			throw new Error("Error in drawing shape.");

		}
	}

	@Override
	public void outlineSelect() {
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		graphics2D.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 10.0f,new float[] { 16.0f, 20.0f }, 0.0f));
		int x = Math.min(startPoint.getX(), endPoint.getX());
		int y = Math.min(startPoint.getY(), endPoint.getY());
		int w = Math.abs(startPoint.getX() - endPoint.getX());
		int h = Math.abs(startPoint.getY() - endPoint.getY());
		graphics2D.drawRect(x, y, w, h);

	}

}
