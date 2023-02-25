package view.commands;

import controller.CommandPattern.ICommandPattern;
import controller.CommandPattern.URCommand;
import model.ShapeList;
import model.ShapeListManager;
import model.interfaces.IIteratorList;
import view.interfaces.IUndoable;

public class PasteShape implements ICommandPattern,IUndoable{
    private ShapeList shapesCopied = ShapeListManager.getClipboardShapeList();
    private ShapeList shape = ShapeListManager.getShapeList();

    public PasteShape() {
    }

    @Override
    public void run() {
        IIteratorList iterator = shapesCopied.getIteratorList();
        while(iterator.Next()) {
            shape.addShape(iterator.obtainNext());
        }
        URCommand.add(this);
    }

    @Override
    public void undo() {
    	IIteratorList iterator = shapesCopied.getIteratorList();
        while (iterator.Next()) {
            shape.removeShape(iterator.obtainNext());
        }
    }

    @Override
    public void redo() {
    	IIteratorList iterator = shapesCopied.getIteratorList();
        while(iterator.Next()) {
            shape.addShape(iterator.obtainNext());
        }
    }
	

}
