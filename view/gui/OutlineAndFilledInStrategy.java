package view.gui;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import model.interfaces.IShapeShadingType;
import view.draw.Calculations;
import view.draw.Ellipse;
import view.draw.Rectangle;
import view.draw.ShapeColorMap;
import view.draw.Triangle;

public class OutlineAndFilledInStrategy implements IShapeShadingType {
	private ShapeColorMap colorMap = ShapeColorMap.getInstance();

	@Override
	public void draw(Ellipse ellipse) {
		Calculations calculation = new Calculations(ellipse.getStartPoint(), ellipse.getEndPoint());
		Graphics2D graphics2D = ellipse.getPaintCanvas().getGraphics2D();
		graphics2D.setColor(colorMap.get(ellipse.getPrimaryColor()));
		graphics2D.fillOval(calculation.getX(), calculation.getY(), calculation.getx1(), calculation.gety1());
		graphics2D.setStroke(new BasicStroke(5));
		graphics2D.setColor(colorMap.get(ellipse.getSecondaryColor()));
		graphics2D.drawOval(calculation.getX(), calculation.getY(), calculation.getx1(), calculation.gety1());
	}

	@Override
	public void draw(Rectangle rectangle) {
		Calculations calculation = new Calculations(rectangle.getStartPoint(), rectangle.getEndPoint());
		Graphics2D graphics2D = rectangle.getPaintCanvas().getGraphics2D();
		graphics2D.setColor(colorMap.get(rectangle.getPrimaryColor()));
		graphics2D.fillRect(calculation.getX(), calculation.getY(), calculation.getx1(), calculation.gety1());
		graphics2D.setStroke(new BasicStroke(5));
		graphics2D.setColor(colorMap.get(rectangle.getSecondaryColor()));
		graphics2D.drawRect(calculation.getX(), calculation.getY(), calculation.getx1(), calculation.gety1());
	}

	@Override
	public void draw(Triangle triangle) {
		int[] x = new int[] { triangle.getStartPoint().getX(), triangle.getStartPoint().getX(),
				triangle.getEndPoint().getX() };
		int[] y = new int[] { triangle.getStartPoint().getY(), triangle.getEndPoint().getY(),
				triangle.getEndPoint().getY() };
		Graphics2D graphics2D = triangle.getPaintCanvas().getGraphics2D();
		graphics2D.setColor(colorMap.get(triangle.getPrimaryColor()));
		graphics2D.fillPolygon(x, y, 3);
		graphics2D.setStroke(new BasicStroke(5));
		graphics2D.setColor(colorMap.get(triangle.getSecondaryColor()));
		graphics2D.drawPolygon(x, y, 3);
	}

}
