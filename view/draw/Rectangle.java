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
		Calculations calc = new Calculations(this.getStartPoint(), this.getEndPoint());
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		switch (this.shadingType) {
		case FILLED_IN:			
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.fillRect(calc.getX(), calc.getY(), calc.getx1(), calc.gety1());
			break;
		case OUTLINE:
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.drawRect(calc.getX(), calc.getY(), calc.getx1(), calc.gety1());
			break;
		case OUTLINE_AND_FILLED_IN:
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.fillRect(calc.getX(), calc.getY(), calc.getx1(), calc.gety1());
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(colorMap.get(this.getSecondaryColor()));
			graphics2D.drawRect(calc.getX(), calc.getY(), calc.getx1(), calc.gety1());
			break;
		default:
			throw new Error("Error in drawing shape.");

		}
	}

	@Override
	public void outlineSelect() {
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		graphics2D.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0));
		int x = Math.min(startPoint.getX(), endPoint.getX());
		int y = Math.min(startPoint.getY(), endPoint.getY());
		int w = Math.abs(startPoint.getX() - endPoint.getX());
		int h = Math.abs(startPoint.getY() - endPoint.getY());
		graphics2D.drawRect(x, y, w, h);

	}

	@Override
	public void flipShape() {
		Graphics2D graphics2d = this.getPaintCanvas().getGraphics2D();
		int w = Math.abs(startPoint.getX() - endPoint.getX());
		int h = Math.abs(startPoint.getY() - endPoint.getY());
		int x = this.getStartPoint().getX();
		int y =this.getStartPoint().getY();
		int temp = x;
		x = y;
		y = temp;
		switch(this.shadingType) {
		case FILLED_IN:		
			graphics2d.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2d.fillRect(x, y, w, h);
			break;
		case OUTLINE:
			graphics2d.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2d.drawRect(x, y, w, h);
			break;
		case OUTLINE_AND_FILLED_IN:
			graphics2d.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2d.fillRect(x, y, w, h);
			graphics2d.setStroke(new BasicStroke(5));
			graphics2d.setColor(colorMap.get(this.getSecondaryColor()));
			graphics2d.drawRect(x, y, w, h);
			break;
		default:
			throw new Error("Error in flipping shape.");
		}

	}

	@Override
	public void rotateShape() {
		Graphics2D graphics2d = this.getPaintCanvas().getGraphics2D();
		graphics2d.rotate(Math.toRadians(180), this.getStartPoint().getX(), this.getStartPoint().getY());
		switch(this.shadingType) {
		case FILLED_IN:
			int x = Math.min(startPoint.getX(), endPoint.getX());
			int y = Math.min(startPoint.getY(), endPoint.getY());
			int w = Math.abs(startPoint.getX() - endPoint.getX());
			int h = Math.abs(startPoint.getY() - endPoint.getY());
			graphics2d.fillRect(x, y, w, h);
			break;
		case OUTLINE:
			int x1 = Math.min(startPoint.getX(), endPoint.getX());
			int y1 = Math.min(startPoint.getY(), endPoint.getY());
			int w1 = Math.abs(startPoint.getX() - endPoint.getX());
			int h1 = Math.abs(startPoint.getY() - endPoint.getY());
			graphics2d.drawRect(x1, y1, w1, h1);
			break;
		case OUTLINE_AND_FILLED_IN:
			int x2 = Math.min(startPoint.getX(), endPoint.getX());
			int y2 = Math.min(startPoint.getY(), endPoint.getY());
			int w2 = Math.abs(startPoint.getX() - endPoint.getX());
			int h2 = Math.abs(startPoint.getY() - endPoint.getY());
			graphics2d.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2d.fillRect(x2, y2, w2, h2);
			graphics2d.setStroke(new BasicStroke(5));
			graphics2d.setColor(colorMap.get(this.getSecondaryColor()));
			graphics2d.drawRect(x2, y2, w2, h2);
			break;
		default:
			throw new Error("Error in rotating shape.");
		}
	}
}
