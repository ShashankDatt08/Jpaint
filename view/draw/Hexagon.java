package view.draw;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import controller.Point;
import model.ShapeConfiguration;
import view.gui.PaintCanvas;

public class Hexagon extends CreateShape {

	public Hexagon(ShapeInfo info, PaintCanvas paintCanvas) {
		super(info, paintCanvas);
	}

	@Override
	public CreateShape createShape() {
		return new Hexagon(new ShapeInfo(new Point(this.startPoint.getX(), this.startPoint.getY()),
				new Point(this.endPoint.getX(), this.endPoint.getY()),
				new ShapeConfiguration(this.config.getActivePrimaryColor(), this.config.getActiveSecondaryColor(),
						this.config.getShapeType(), this.config.getShadingType())),
				this.paintCanvas);
	}

	@Override
	public void draw() {
		int x = Math.min(startPoint.getX(), endPoint.getX());
		int y = Math.min(startPoint.getY(), endPoint.getY());
		int w = Math.abs(startPoint.getX() - endPoint.getX());
		int h = Math.abs(startPoint.getY() - endPoint.getY());
		int[] x1 = new int[] { x + w, x + (w / 2), x - (w / 2), x - w, x - (w / 2), x + (w / 2) };
		int[] y1 = new int[] { y, y - h, y - h, y, y + h, y + h };
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		switch (this.shadingType) {
		case FILLED_IN:
			graphics2D.setColor(ShapeColorMap.getInstance(this.primaryColor));
			graphics2D.fillPolygon(x1, y1, 6);
			break;
		case OUTLINE:
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(ShapeColorMap.getInstance(this.secondaryColor));
			graphics2D.drawPolygon(x1, y1, 6);
			break;
		case OUTLINE_AND_FILLED_IN:
			graphics2D.setColor(ShapeColorMap.getInstance(this.primaryColor));
			graphics2D.fillPolygon(x1, y1, 6);
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(ShapeColorMap.getInstance(this.secondaryColor));
			graphics2D.drawPolygon(x1, y1, 6);
			break;
		default:
			throw new Error("Error in drawing shape.");
		}
	}

	@Override
	public void outlineSelect() {
		int x = Math.min(startPoint.getX(), endPoint.getX());
		int y = Math.min(startPoint.getY(), endPoint.getY());
		int w = Math.abs(startPoint.getX() - endPoint.getX());
		int h = Math.abs(startPoint.getY() - endPoint.getY());
		int[] x1 = new int[] { x + w, x + (w / 2), x - (w / 2), x - w, x - (w / 2), x + (w / 2) };
		int[] y1 = new int[] { y, y - h, y - h, y, y + h, y + h };
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		graphics2D.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[] { 9 }, 0));
		graphics2D.drawPolygon(x1, y1, 6);
	}

	@Override
	public void flipShape() {
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		int w = Math.abs(startPoint.getX() - endPoint.getX());
		int h = Math.abs(startPoint.getY() - endPoint.getY());
		int x = this.getStartPoint().getX();
		int y =this.getStartPoint().getY();
		int temp = x;
		x = y;
		y = temp;	
		int[] x1 = new int[] { x + w, x + (w / 2), x - (w / 2), x - w, x - (w / 2), x + (w / 2) };
		int[] y1 = new int[] { y, y - h, y - h, y, y + h, y + h };
		switch (this.shadingType) {
		case FILLED_IN:
			graphics2D.setColor(ShapeColorMap.getInstance(this.primaryColor));
			graphics2D.fillPolygon(x1, y1, 6);
			break;
		case OUTLINE:
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(ShapeColorMap.getInstance(this.secondaryColor));
			graphics2D.drawPolygon(x1, y1, 6);
			break;
		case OUTLINE_AND_FILLED_IN:
			graphics2D.setColor(ShapeColorMap.getInstance(this.primaryColor));
			graphics2D.fillPolygon(x1, y1, 6);
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(ShapeColorMap.getInstance(this.secondaryColor));
			graphics2D.drawPolygon(x1, y1, 6);
			break;
		default:
			throw new Error("Error in flipping shape.");

		}
	}

	@Override
	public void rotateShape() {
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		graphics2D.rotate(Math.toRadians(70), this.getStartPoint().getX(), this.getStartPoint().getY());
		int x = Math.min(startPoint.getX(), endPoint.getX());
		int y = Math.min(startPoint.getY(), endPoint.getY());
		int w = Math.abs(startPoint.getX() - endPoint.getX());
		int h = Math.abs(startPoint.getY() - endPoint.getY());
		int[] x1 = new int[] { x + w, x + (w / 2), x - (w / 2), x - w, x - (w / 2), x + (w / 2) };
		int[] y1 = new int[] { y, y - h, y - h, y, y + h, y + h };
		switch (this.shadingType) {
		case FILLED_IN:
			graphics2D.setColor(ShapeColorMap.getInstance(this.primaryColor));
			graphics2D.fillPolygon(x1, y1, 6);
			break;
		case OUTLINE:
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(ShapeColorMap.getInstance(this.secondaryColor));
			graphics2D.drawPolygon(x1, y1, 6);
			break;
		case OUTLINE_AND_FILLED_IN:
			graphics2D.setColor(ShapeColorMap.getInstance(this.primaryColor));
			graphics2D.fillPolygon(x1, y1, 6);
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(ShapeColorMap.getInstance(this.secondaryColor));
			graphics2D.drawPolygon(x1, y1, 6);
			break;
		default:
			throw new Error("Error in rotating shape.");
		}
	}

}
