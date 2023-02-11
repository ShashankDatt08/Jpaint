package view.gui;

import java.awt.Graphics2D;

import model.interfaces.IShapeShadingType;
import view.draw.Calculations;
import view.draw.Ellipse;
import view.draw.Rectangle;
import view.draw.ShapeColorMap;
import view.draw.Triangle;

public class FilledStrategy implements IShapeShadingType {
	private ShapeColorMap colorMap = ShapeColorMap.getInstance();

	@Override
	public void draw(Ellipse e) {
		Calculations calc = new Calculations(e.getStartPoint(), e.getEndPoint());
		Graphics2D graphics2D = e.getPaintCanvas().getGraphics2D();
		graphics2D.setColor(colorMap.get(e.getPrimaryColor()));
		graphics2D.fillOval(calc.getX(), calc.getY(), calc.getx1(), calc.gety1());
	}

	@Override
	public void draw(Rectangle r) {
		Calculations calc = new Calculations(r.getStartPoint(), r.getEndPoint());
		Graphics2D graphics2D = r.getPaintCanvas().getGraphics2D();
		graphics2D.setColor(colorMap.get(r.getPrimaryColor()));
		graphics2D.fillRect(calc.getX(), calc.getY(), calc.getx1(), calc.gety1());
	}

	@Override
	public void draw(Triangle t) {
		int[] x = new int[] { t.getStartPoint().getX(), t.getStartPoint().getX(), t.getEndPoint().getX() };
		int[] y = new int[] { t.getStartPoint().getY(), t.getEndPoint().getY(), t.getEndPoint().getY() };
		Graphics2D graphics2D = t.getPaintCanvas().getGraphics2D();
		graphics2D.setColor(colorMap.get(t.getPrimaryColor()));
		graphics2D.fillPolygon(x, y, 3);
	}

}
