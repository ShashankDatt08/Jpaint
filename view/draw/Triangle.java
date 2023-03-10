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
		switch (this.shadingType) {
		case FILLED_IN:
			int[] x = new int[] { this.getStartPoint().getX(), this.getStartPoint().getX(), this.getEndPoint().getX() };
			int[] y = new int[] { this.getStartPoint().getY(), this.getEndPoint().getY(), this.getEndPoint().getY() };
			Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.fillPolygon(x, y, 3);
			break;
		case OUTLINE:
			int[] a = new int[] { this.getStartPoint().getX(), this.getStartPoint().getX(),
					this.getEndPoint().getX() };
			int[] b = new int[] { this.getStartPoint().getY(), this.getEndPoint().getY(),
					this.getEndPoint().getY() };
			Graphics2D graphicss2D = this.getPaintCanvas().getGraphics2D();
			graphicss2D.setStroke(new BasicStroke(5));
			graphicss2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphicss2D.drawPolygon(a, b, 3);
			break;
		case OUTLINE_AND_FILLED_IN:
			int[] c = new int[] { this.getStartPoint().getX(), this.getStartPoint().getX(),
					this.getEndPoint().getX() };
			int[] d = new int[] { this.getStartPoint().getY(), this.getEndPoint().getY(),
					this.getEndPoint().getY() };
			Graphics2D graphicsss2D = this.getPaintCanvas().getGraphics2D();
			graphicsss2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphicsss2D.fillPolygon(c, d, 3);
			graphicsss2D.setStroke(new BasicStroke(5));
			graphicsss2D.setColor(colorMap.get(this.getSecondaryColor()));
			graphicsss2D.drawPolygon(c, d, 3);
		}
			
	}


	@Override
	public void outlineSelect() {
		int x[] = { startPoint.getX(), startPoint.getX(), endPoint.getX() };
		int y[] = { startPoint.getY(), endPoint.getY(), endPoint.getY() };
		int z = 3;
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		float flo[] = { 6.0f };
		graphics2D.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 6.0f, flo, 0.0f));
		graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
		graphics2D.drawPolygon(x, y, z);
	}

}
