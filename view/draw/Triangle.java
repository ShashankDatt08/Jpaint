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
	public void draw() {
		strategy.draw(this);
	}

	@Override
	public CreateShape createShape() {
		return new Triangle(new ShapeInfo(new Point(this.startPoint.getX(), this.startPoint.getY()),
				new Point(this.endPoint.getX(), this.endPoint.getY()),
				new ShapeConfiguration(this.config.getActivePrimaryColor(), this.config.getActiveSecondaryColor(),
						this.config.getShapeType(), this.config.getShadingType())),
				this.paintCanvas);
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
