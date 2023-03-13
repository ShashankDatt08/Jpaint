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
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		switch (this.shadingType) {
		case FILLED_IN:
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.drawLine(this.getStartPoint().getX(), this.getStartPoint().getY(), this.getEndPoint().getX(),
					this.getEndPoint().getY());
			break;
		case OUTLINE:
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.drawLine(this.getStartPoint().getX(), this.getStartPoint().getY(), this.getEndPoint().getX(),
					this.getEndPoint().getY());
			break;
		case OUTLINE_AND_FILLED_IN:
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.drawLine(this.getStartPoint().getX(), this.getStartPoint().getY(), this.getEndPoint().getX(),
					this.getEndPoint().getY());
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(colorMap.get(this.getSecondaryColor()));
			graphics2D.drawLine(this.getStartPoint().getX(), this.getStartPoint().getY(), this.getEndPoint().getX(),
					this.getEndPoint().getY());
			break;
		default:
			throw new Error("Error in drawing shape.");

		}
	}

	@Override
	public void outlineSelect() {
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		graphics2D.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[] { 9 }, 0));
		graphics2D.drawLine(this.getStartPoint().getX(), this.getStartPoint().getY(), this.getEndPoint().getX(),
				this.getEndPoint().getY());

	}

	@Override
	public void flipShape() {
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
		int x = this.getStartPoint().getX();
		int y = this.getEndPoint().getY();
		int temp = x;
		x = y;
		y = temp;
		switch (this.shadingType) {
		case FILLED_IN:
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.drawLine(x, y, this.getEndPoint().getX(), this.getEndPoint().getY());
			break;
		case OUTLINE:
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.drawLine(x, y, this.getEndPoint().getX(), this.getEndPoint().getY());
			break;
		case OUTLINE_AND_FILLED_IN:
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.drawLine(x, y, this.getEndPoint().getX(), this.getEndPoint().getY());
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(colorMap.get(this.getSecondaryColor()));
			graphics2D.drawLine(x, y, this.getEndPoint().getX(), this.getEndPoint().getY());
			break;
		default:
			throw new Error("Error in flipping shape.");

		}
	}

	@Override
	public void rotateShape() {
		Graphics2D graphics2d = this.getPaintCanvas().getGraphics2D();
		graphics2d.rotate(Math.toRadians(70), this.getStartPoint().getX(), this.getStartPoint().getY());
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		switch (this.shadingType) {
		case FILLED_IN:
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.drawLine(this.getStartPoint().getX(), this.getStartPoint().getY(), this.getEndPoint().getX(),
					this.getEndPoint().getY());
			break;
		case OUTLINE:
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.drawLine(this.getStartPoint().getX(), this.getStartPoint().getY(), this.getEndPoint().getX(),
					this.getEndPoint().getY());
			break;
		case OUTLINE_AND_FILLED_IN:
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.drawLine(this.getStartPoint().getX(), this.getStartPoint().getY(), this.getEndPoint().getX(),
					this.getEndPoint().getY());
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(colorMap.get(this.getSecondaryColor()));
			graphics2D.drawLine(this.getStartPoint().getX(), this.getStartPoint().getY(), this.getEndPoint().getX(),
					this.getEndPoint().getY());
			break;
		default:
			throw new Error("Error in rotating shape.");

		}
	}

}
