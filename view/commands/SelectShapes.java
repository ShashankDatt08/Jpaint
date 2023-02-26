package view.commands;

import controller.Point;
import controller.CommandPattern.ICommandPattern;
import model.ShapeList;
import model.ShapeListManager;
import model.interfaces.IIteratorList;
import view.draw.CreateShape;

public class SelectShapes implements ICommandPattern {
	private ShapeList shapeList = ShapeListManager.getShapeList();
	private ShapeList selectedShape = ShapeListManager.getSelectedShapeList();
	private Point startPoint;
	private Point endPoint;

	public SelectShapes(Point start, Point end) {
		selectedShape.clear();
		startPoint = start;
		endPoint = end;
	}

	@Override
	public void run() {
		IIteratorList iteratorList = shapeList.getIteratorList();
		while (iteratorList.Next()) {
			CreateShape createShape = iteratorList.obtainNext();
			if (Collision.isCollision(createShape, startPoint, endPoint)) {
				selectedShape.addShape(createShape);
			}
			IIteratorList iterator = selectedShape.getIteratorList();
			while (iterator.Next()) {
				shapeList.add(iterator.obtainNext());
			}

		}
	}
}