package view.draw;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import controller.Point;
import model.ShapeConfiguration;
import view.gui.PaintCanvas;

public class ArcPie extends CreateShape {

	public ArcPie(ShapeInfo info, PaintCanvas paintCanvas) {
		super(info, paintCanvas);
	}

	@Override
	public CreateShape createShape() {
		return new ArcPie(new ShapeInfo(new Point(this.startPoint.getX(), this.startPoint.getY()),
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
			graphics2D.setColor(ShapeColorMap.getInstance(this.primaryColor));
			graphics2D.fillArc(calc.getX(), calc.getY(), calc.getx1(), calc.gety1(), -10, 45);
			break;
		case OUTLINE:
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(ShapeColorMap.getInstance(this.secondaryColor));
			graphics2D.drawArc(calc.getX(), calc.getY(), calc.getx1(), calc.gety1(), -10, 45);
			break;
		case OUTLINE_AND_FILLED_IN:
			graphics2D.setColor(ShapeColorMap.getInstance(this.primaryColor));
			graphics2D.fillRect(calc.getX(), calc.getY(), calc.getx1(), calc.gety1());
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(ShapeColorMap.getInstance(this.secondaryColor));
			graphics2D.drawArc(calc.getX(), calc.getY(), calc.getx1(), calc.gety1(), -10, 45);
			break;
		default:
			throw new Error("Error in drawing shape.");

		}
	}

	@Override
	public void outlineSelect() {
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		graphics2D.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[] { 9 }, 0));
		int x = Math.min(startPoint.getX(), endPoint.getX());
		int y = Math.min(startPoint.getY(), endPoint.getY());
		int w = Math.abs(startPoint.getX() - endPoint.getX());
		int h = Math.abs(startPoint.getY() - endPoint.getY());
		graphics2D.drawArc(x, y, w, h, -10, 45);

	}

	@Override
	public void flipShape() {
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		graphics2D.setColor(ShapeColorMap.getInstance(this.primaryColor));
		int x = Math.min(startPoint.getX(), endPoint.getX());
		int y = Math.min(startPoint.getY(), endPoint.getY());
		int w = Math.abs(startPoint.getX() - endPoint.getX());
		int h = Math.abs(startPoint.getY() - endPoint.getY());
		int temp = x;
		x = y;
		y = temp;
		switch (this.shadingType) {
		case FILLED_IN:		
			graphics2D.setColor(ShapeColorMap.getInstance(this.primaryColor));
			graphics2D.fillArc(x, y, w, h, 240, -100);
			break;
		case OUTLINE:
			graphics2D.setColor(ShapeColorMap.getInstance(this.secondaryColor));
			graphics2D.drawArc(x, y, w, h, 240, -100);
			break;
		case OUTLINE_AND_FILLED_IN:
			graphics2D.setColor(ShapeColorMap.getInstance(this.primaryColor));
			graphics2D.fillArc(x, y, w, h, 240, -100);
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(ShapeColorMap.getInstance(this.secondaryColor));
			graphics2D.drawArc(x, y, w, h, 240, -100);
			break;
		default:
			throw new Error("Error in flipping shape.");
		}
	}

	@Override
	public void rotateShape() {
		Graphics2D graphics2d = this.getPaintCanvas().getGraphics2D();
		graphics2d.rotate(Math.toRadians(180), this.getStartPoint().getX(), this.getStartPoint().getY());
		Calculations calc = new Calculations(this.getStartPoint(), this.getEndPoint());
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		switch (this.shadingType) {
		case FILLED_IN:
			graphics2d.setColor(ShapeColorMap.getInstance(this.primaryColor));
			graphics2D.fillArc(calc.getX(), calc.getY(), calc.getx1(), calc.gety1(), -10, 45);
			break;
		case OUTLINE:
			graphics2D.setStroke(new BasicStroke(5));
			graphics2d.setColor(ShapeColorMap.getInstance(this.secondaryColor));
			graphics2D.drawArc(calc.getX(), calc.getY(), calc.getx1(), calc.gety1(), -10, 45);
			break;
		case OUTLINE_AND_FILLED_IN:
			graphics2d.setColor(ShapeColorMap.getInstance(this.primaryColor));
			graphics2D.fillRect(calc.getX(), calc.getY(), calc.getx1(), calc.gety1());
			graphics2D.setStroke(new BasicStroke(5));
			graphics2d.setColor(ShapeColorMap.getInstance(this.secondaryColor));
			graphics2D.drawArc(calc.getX(), calc.getY(), calc.getx1(), calc.gety1(), -10, 45);
			break;
		default:
			throw new Error("Error in rotating shape.");

		}

	}
}
