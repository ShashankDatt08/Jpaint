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

		}
		return shapeFactory;
	}
}
