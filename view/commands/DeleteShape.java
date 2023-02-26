package view.commands;

import controller.CommandPattern.ICommandPattern;
import controller.CommandPattern.URCommand;
import model.ShapeList;
import model.ShapeListManager;
import model.interfaces.IIteratorList;
import view.draw.CreateShape;
import view.interfaces.IUndoable;

public class DeleteShape implements ICommandPattern,IUndoable {
    private ShapeList shape = ShapeListManager.getShapeList();
    private ShapeList shapeSelected = ShapeListManager.getSelectedShapeList();
    private ShapeList shapesMoving = ShapeListManager.getMovingShapeList();

    @Override
    public void run() {
        IIteratorList iteratorList = shapeSelected.getIteratorList();
        while(iteratorList.Next()) {
            CreateShape createShape = iteratorList.obtainNext();
            shape.removeShape(createShape);
        }
        IIteratorList iteratorList1 = shapesMoving.getIteratorList();
        while(iteratorList1.Next()) {
        	CreateShape createShape = iteratorList1.obtainNext();
            shape.removeShape(createShape);
        }
        URCommand.add(this);
    }

    @Override
    public void undo() {
    	IIteratorList iteratorList = shapeSelected.getIteratorList();
        while(iteratorList.Next()) {
        	CreateShape createShape = iteratorList.obtainNext();
            shape.addShape(createShape);
        }
    }

    @Override
    public void redo() {
    	IIteratorList iteratorList = shapeSelected.getIteratorList();
        while(iteratorList.Next()) {
        	CreateShape createShape = iteratorList.obtainNext();
            shape.removeShape(createShape);
        }
    }

}
