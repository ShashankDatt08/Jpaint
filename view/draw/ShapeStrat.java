package view.draw;

import model.ShapeType;
import model.interfaces.IShape;

public class ShapeStrat {
	public static IShape getFactory(ShapeType shapeType) {
		IShape shapeFactory = null;
		switch (shapeType) {
		case ELLIPSE:
			shapeFactory = new EllipseStrat();
			break;
		case RECTANGLE:
			shapeFactory = new RectangleStrat();
			break;
		case TRIANGLE:
			shapeFactory = new TriangleStrat();
			break;
		case LINE:
			shapeFactory = new LineStrat();
			break;
		case ARCPIE:
			shapeFactory = new ArcPieStrat();
			break;
		case HEXAGON:
			shapeFactory = new HexagonStrat();
			break;
		case KITE:
			shapeFactory = new KiteStrat();
			break;
		case PENTAGON:
			shapeFactory = new PentagonStrat();
			break;
		case TEXT:
			shapeFactory = new TextStrat();
			break;
		}
		return shapeFactory;
	}
}
