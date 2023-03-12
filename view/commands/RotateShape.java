package view.commands;

import controller.CommandPattern.ICommandPattern;
import model.ShapeList;
import model.ShapeListManager;
import model.interfaces.IIteratorList;
import view.draw.CreateShape;

public class RotateShape implements ICommandPattern {
	private ShapeList master = ShapeListManager.getShapeList();
	private ShapeList selectedShape = ShapeListManager.getSelectedShapeList();


	@Override
	public void run() {
		IIteratorList iteratorList = selectedShape.getIteratorList();
		while (iteratorList.Next()) {
			CreateShape createShape = iteratorList.obtainNext();
			selectedShape.add(createShape);
			master.rotateShape(createShape);
			
	}
	}

}
