
package view.commands;

import controller.CommandPattern.ICommandPattern;
import controller.CommandPattern.URCommand;
import model.ShapeList;
import model.ShapeListManager;
import model.interfaces.IIteratorList;
import view.draw.CreateShape;
import view.interfaces.IUndoable;

public class UngroupCommand implements ICommandPattern , IUndoable{
	private ShapeList master = ShapeListManager.getShapeList();
	private ShapeList group = ShapeListManager.getGroupShapeList();
	
	@Override
	public void run() {
		IIteratorList iterator = group.getIteratorList();
		while (iterator.Next()) {
			CreateShape shape = iterator.obtainNext();
			master.groupRemove(shape);
		}
		URCommand.add(this);
	}
	
	@Override
	public void undo() {
		GroupCommand group = new GroupCommand();
		group.run();

	}
	@Override
	public void redo() {
		run();	
	}
	
}
