package view.commands;

import java.util.ArrayList;

import controller.CommandPattern.ICommandPattern;
import model.ShapeList;
import model.ShapeListManager;
import model.interfaces.IIteratorList;
import view.draw.CreateShape;
import view.interfaces.IUndoable;

public class RotateShape implements ICommandPattern, IUndoable {
	private ShapeList master = ShapeListManager.getShapeList();
	private ShapeList selectedShape = ShapeListManager.getSelectedShapeList();
	private CreateShape shapesUR;

	@Override
	public void run() {
		IIteratorList iteratorList = selectedShape.getIteratorList();
		while (iteratorList.Next()) {
			CreateShape createShape = iteratorList.obtainNext();
			selectedShape.add(createShape);
			master.rotateShape(createShape);
			master.add(createShape);
			shapesUR = createShape;
		}
	}

	@Override
	public void undo() {
		master.removeShape(shapesUR);
	}

	@Override
	public void redo() {
		run();
	}

}
