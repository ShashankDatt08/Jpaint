package view.commands;

import controller.Point;
import controller.CommandPattern.URCommand;
import controller.CommandPattern.ICommandPattern;
import model.ShapeList;
import model.ShapeListManager;
import model.interfaces.IIteratorList;
import view.draw.CreateShape;
import view.interfaces.IUndoable;

public class MoveShapes implements ICommandPattern, IUndoable {
	private ShapeList selectedShapes = ShapeListManager.getSelectedShapeList();
	private ShapeList shapeList = ShapeListManager.getShapeList();
	private ShapeList movingShapes = ShapeListManager.getMovingShapeList();

	public MoveShapes(Point end) {
		IIteratorList iterator = selectedShapes.getIterator();
		while (iterator.Next()) {
			CreateShape createShape = iterator.obtainNext();
			CreateShape createShapeNew = createShape.createShape();
			int deltaX = end.getX() - createShape.getStartPoint().getX();
			int deltaY = end.getY() - createShape.getStartPoint().getY();
			Point newEnd = new Point(createShape.getEndPoint().getX() + deltaX, createShape.getEndPoint().getY() + deltaY);
			createShapeNew.setStartPoint(end);
			createShapeNew.setEndPoint(newEnd);
			movingShapes.addShape(createShapeNew);
		}
	}

	@Override
	public void run() {
		IIteratorList iteratorList = selectedShapes.getIterator();
		while (iteratorList.Next()) {
			shapeList.removeShape(iteratorList.obtainNext());
		}
		IIteratorList iteratorList1 = movingShapes.getIterator();
		while (iteratorList1.Next()) {
			shapeList.addShape(iteratorList1.obtainNext());
		}
		URCommand.add(this);
	}

	@Override
	public void undo() {
		IIteratorList iteratorList = movingShapes.getIterator();
		while (iteratorList.Next()) {
			shapeList.removeShape(iteratorList.obtainNext());
		}
		IIteratorList iteratorList1 = selectedShapes.getIterator();
		while (iteratorList1.Next()) {
			shapeList.addShape(iteratorList1.obtainNext());
		}
	}

	@Override
	public void redo() {
		IIteratorList iteratorList = selectedShapes.getIterator();
		while (iteratorList.Next()) {
			shapeList.removeShape(iteratorList.obtainNext());
		}
		IIteratorList iteratorList1 = movingShapes.getIterator();
		while (iteratorList1.Next()) {
			shapeList.addShape(iteratorList1.obtainNext());
		}
	}
}
