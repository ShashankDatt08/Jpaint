package view.commands;

import controller.CommandPattern.ICommandPattern;
import model.ShapeList;
import model.ShapeListManager;
import model.interfaces.IIteratorList;
import view.draw.CreateShape;

;

public class CopyShape implements ICommandPattern {
    private ShapeList shapesSelected = ShapeListManager.getSelectedShapeList();
    private ShapeList shapesCopied = ShapeListManager.getClipboardShapeList();

	    @Override
	    public void run() {
	        IIteratorList iterator = shapesSelected.getIteratorList();
	        if (iterator.Next()) {
	            CreateShape current = iterator.obtainNext().createShape();
	            current.translate(200,70);
	            shapesCopied.addShape(current);
	        }
	    }

}
