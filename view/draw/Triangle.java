package view.draw;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import controller.Point;
import model.ShapeConfiguration;
import view.gui.PaintCanvas;

public class Triangle extends CreateShape {

	public Triangle(ShapeInfo info, PaintCanvas paintCanvas) {
		super(info, paintCanvas);
	}

	private ShapeColorMap colorMap = ShapeColorMap.getInstance();

	
	@Override
	public CreateShape createShape() {
		return new Triangle(new ShapeInfo(new Point(this.startPoint.getX(), this.startPoint.getY()),
				new Point(this.endPoint.getX(), this.endPoint.getY()),
				new ShapeConfiguration(this.config.getActivePrimaryColor(), this.config.getActiveSecondaryColor(),
						this.config.getShapeType(), this.config.getShadingType())),
				this.paintCanvas);
	}
	
	@Override
	public void draw() {
		int[] x = new int[] { this.getStartPoint().getX(), this.getStartPoint().getX(), this.getEndPoint().getX() };
		int[] y = new int[] { this.getStartPoint().getY(), this.getEndPoint().getY(), this.getEndPoint().getY() };
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		switch (this.shadingType) {
		case FILLED_IN:		
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.fillPolygon(x, y, 3);
			break;
		case OUTLINE:
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.drawPolygon(x, y, 3);
			break;
		case OUTLINE_AND_FILLED_IN:
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.fillPolygon(x, y, 3);
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(colorMap.get(this.getSecondaryColor()));
			graphics2D.drawPolygon(x, y, 3);
			break;
		default:
			throw new Error("Error in drawing shape.");

		}
			
	}


	@Override
	public void outlineSelect() {
		int x[] = { startPoint.getX(), startPoint.getX(), endPoint.getX() };
		int y[] = { startPoint.getY(), endPoint.getY(), endPoint.getY() };
		int z = 3;
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		graphics2D.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0));
		graphics2D.drawPolygon(x, y, z);
	}

	@Override
	public void flipShape() {
		int x = this.getStartPoint().getX();
		int y =this.getStartPoint().getY();
		int temp = x;
		x = y;
		y = temp;	
		int[] x1 = new int[] { x, y, this.getEndPoint().getX() };
		int[] y1 = new int[] { y, this.getEndPoint().getY(), this.getEndPoint().getY() };
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		switch (this.shadingType) {
		case FILLED_IN:		
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.fillPolygon(x1, y1, 3);
			break;
		case OUTLINE:
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.drawPolygon(x1, y1, 3);
			break;
		case OUTLINE_AND_FILLED_IN:
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.fillPolygon(x1, y1, 3);
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(colorMap.get(this.getSecondaryColor()));
			graphics2D.drawPolygon(x1, y1, 3);
			break;
		default:
			throw new Error("Error in flipping shape.");

		}
	}

	@Override
	public void rotateShape() {
		int[] x = new int[] { this.getStartPoint().getX(), this.getStartPoint().getX(), this.getEndPoint().getX() };
		int[] y = new int[] { this.getStartPoint().getY(), this.getEndPoint().getY(), this.getEndPoint().getY() };
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		graphics2D.rotate(Math.toRadians(180), this.getStartPoint().getX(), this.getStartPoint().getY());	
		switch (this.shadingType) {
		case FILLED_IN:		
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.fillPolygon(x, y, 3);
			break;
		case OUTLINE:
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.drawPolygon(x, y, 3);
			break;
		case OUTLINE_AND_FILLED_IN:
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.fillPolygon(x, y, 3);
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(colorMap.get(this.getSecondaryColor()));
			graphics2D.drawPolygon(x, y, 3);
			break;
		default:
			throw new Error("Error in rotating shape.");

		}
	}

}
