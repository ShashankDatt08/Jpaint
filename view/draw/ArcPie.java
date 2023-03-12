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

	private ShapeColorMap colorMap = ShapeColorMap.getInstance();

	@Override
	public CreateShape createShape() {
		return new ArcPie(new ShapeInfo(new Point(this.startPoint.getX(), this.startPoint.getY()),
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
			graphics2D.fillArc(calc.getX(), calc.getY(), calc.getx1(), calc.gety1() , 45 , 90);
			break;
		case OUTLINE:
			Calculations calculation = new Calculations(this.getStartPoint(), this.getEndPoint());
			Graphics2D graphicss2D = this.getPaintCanvas().getGraphics2D();
			graphicss2D.setStroke(new BasicStroke(5));
			graphicss2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphicss2D.drawArc(calculation.getX(), calculation.getY(), calculation.getx1(), calculation.gety1() , 45 , 90);
			break;
		case OUTLINE_AND_FILLED_IN:
			Calculations calculations = new Calculations(this.getStartPoint(), this.getEndPoint());
			Graphics2D graphicsss2D = this.getPaintCanvas().getGraphics2D();
			graphicsss2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphicsss2D.fillRect(calculations.getX(), calculations.getY(), calculations.getx1(), calculations.gety1());
			graphicsss2D.setStroke(new BasicStroke(5));
			graphicsss2D.setColor(colorMap.get(this.getSecondaryColor()));
			graphicsss2D.drawArc(calculations.getX(), calculations.getY(), calculations.getx1(), calculations.gety1() , 45 , 90);
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
		graphics2D.drawArc(x, y, w, h,45,90);

	}

	@Override
	public void flipShape() {
		Graphics2D graphics2d = this.getPaintCanvas().getGraphics2D();
		graphics2d.setColor(colorMap.get(this.getPrimaryColor()));
		switch(this.shadingType) {
		case FILLED_IN:
			int x = Math.min(startPoint.getX(), endPoint.getX());
			int y = Math.min(startPoint.getY(), endPoint.getY());
			int w = Math.abs(startPoint.getX() - endPoint.getX());
			int h = Math.abs(startPoint.getY() - endPoint.getY());
			int temp = x;
			x = y;
			y = temp;
			graphics2d.fillArc(x, y, w, h,45,90);
			break;
		case OUTLINE:
			int x1 = Math.min(startPoint.getX(), endPoint.getX());
			int y1 = Math.min(startPoint.getY(), endPoint.getY());
			int w1 = Math.abs(startPoint.getX() - endPoint.getX());
			int h1 = Math.abs(startPoint.getY() - endPoint.getY());
			int temp1 = x1;
			x1= y1;
			y1 = temp1;
			graphics2d.drawArc(x1, y1, w1, h1,45,90);
			break;
		case OUTLINE_AND_FILLED_IN:
			int x2 = Math.min(startPoint.getX(), endPoint.getX());
			int y2 = Math.min(startPoint.getY(), endPoint.getY());
			int w2 = Math.abs(startPoint.getX() - endPoint.getX());
			int h2 = Math.abs(startPoint.getY() - endPoint.getY());
			int temp2 = x2;
			x2 = y2;
			y2 = temp2;
			graphics2d.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2d.fillRect(x2, y2, w2, h2);
			graphics2d.setStroke(new BasicStroke(5));
			graphics2d.setColor(colorMap.get(this.getSecondaryColor()));
			graphics2d.drawArc(x2, y2, w2, h2,45,90);
			break;
		default:
			throw new Error("Error in rotating shape.");
		}
	}

	@Override
	public void rotateShape() {
		Graphics2D graphics2d = this.getPaintCanvas().getGraphics2D();
		graphics2d.rotate(Math.toRadians(70), this.getStartPoint().getX(), this.getStartPoint().getY());
		switch(this.shadingType) {
		case FILLED_IN:
			int x = Math.min(startPoint.getX(), endPoint.getX());
			int y = Math.min(startPoint.getY(), endPoint.getY());
			int w = Math.abs(startPoint.getX() - endPoint.getX());
			int h = Math.abs(startPoint.getY() - endPoint.getY());
			graphics2d.fillArc(x, y, w, h,45,90);
			break;
		case OUTLINE:
			int x1 = Math.min(startPoint.getX(), endPoint.getX());
			int y1 = Math.min(startPoint.getY(), endPoint.getY());
			int w1 = Math.abs(startPoint.getX() - endPoint.getX());
			int h1 = Math.abs(startPoint.getY() - endPoint.getY());
			graphics2d.drawArc(x1, y1, w1, h1,45,90);
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
			graphics2d.drawArc(x2, y2, w2, h2,45,90);
			break;
		default:
			throw new Error("Error in rotating shape.");
		}
	}

}
