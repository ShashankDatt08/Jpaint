package view.draw;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import controller.Point;
import model.ShapeConfiguration;
import view.gui.PaintCanvas;

public class Line extends CreateShape {

	public Line(ShapeInfo info, PaintCanvas paintCanvas) {
		super(info, paintCanvas);
	}

	private ShapeColorMap colorMap = ShapeColorMap.getInstance();
	
	@Override
	public CreateShape createShape() {
		return new Line(new ShapeInfo(new Point(this.startPoint.getX(), this.startPoint.getY()),
				new Point(this.endPoint.getX(), this.endPoint.getY()),
				new ShapeConfiguration(this.config.getActivePrimaryColor(), this.config.getActiveSecondaryColor(),
						this.config.getShapeType(), this.config.getShadingType())),
				this.paintCanvas);
	}
	@Override
	public void draw() {
		switch (this.shadingType) {
		case FILLED_IN:
			Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));			
			graphics2D.drawLine(this.getStartPoint().getX(), this.getStartPoint().getY(), this.getEndPoint().getX(), this.getEndPoint().getY());
			break;
		case OUTLINE:
			Graphics2D graphicss2D = this.getPaintCanvas().getGraphics2D();
			graphicss2D.setStroke(new BasicStroke(5));
			graphicss2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphicss2D.drawLine(this.getStartPoint().getX(), this.getStartPoint().getY(), this.getEndPoint().getX(), this.getEndPoint().getY());
			break;
		case OUTLINE_AND_FILLED_IN:
			Graphics2D graphicsss2D = this.getPaintCanvas().getGraphics2D();
			graphicsss2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphicsss2D.drawLine(this.getStartPoint().getX(), this.getStartPoint().getY(), this.getEndPoint().getX(), this.getEndPoint().getY());
			graphicsss2D.setStroke(new BasicStroke(5));
			graphicsss2D.setColor(colorMap.get(this.getSecondaryColor()));
			graphicsss2D.drawLine(this.getStartPoint().getX(), this.getStartPoint().getY(), this.getEndPoint().getX(), this.getEndPoint().getY());
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
		graphics2D.drawLine(x, y, w, h);
	}



	@Override
	public void flipShape() {
		// TODO Auto-generated method stub

	}

	@Override
	public void rotateShape() {
		// TODO Auto-generated method stub

	}

}
