package view.commands;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.util.ArrayList;

import controller.CommandPattern.ICommandPattern;
import controller.CommandPattern.URCommand;
import model.ShapeList;
import model.ShapeListManager;
import model.interfaces.IIteratorList;
import view.draw.CreateShape;
import view.interfaces.IUndoable;

public class GroupCommand implements ICommandPattern, IUndoable {
	private ShapeList selectedShapes = ShapeListManager.getSelectedShapeList();
	private ShapeList master = ShapeListManager.getShapeList();
	private ShapeList group = ShapeListManager.getGroupShapeList();
	int minX = Integer.MAX_VALUE;
	int minY = Integer.MAX_VALUE;
	int maxX = Integer.MIN_VALUE;
	int maxY = Integer.MIN_VALUE;
	int width;
	int height;
	int padding = 50;
	
	@Override
	public void run() {
		IIteratorList iterator = selectedShapes.getIteratorList();
		while (iterator.Next()) {
			CreateShape shape = iterator.obtainNext();
			
			int startX = shape.getStartPoint().getX();
			int endX = shape.getEndPoint().getX();
			int startY = shape.getStartPoint().getY();
			int endY = shape.getEndPoint().getY();

			minX = Math.min(minX, Math.min(startX, endX));
			minY = Math.min(minY, Math.min(startY, endY));
			maxX = Math.max(maxX, Math.max(startX, endX));
			maxY = Math.max(maxY, Math.max(startY, endY));

			width = maxX - minX + padding;
			height = maxY - minY + padding;
			
			group.addShape(shape);
		}
		IIteratorList iteratorList = group.getIteratorList();
		while (iteratorList.Next()) {
			CreateShape shape = iteratorList.obtainNext();

			shape.graphics2d.setStroke(new BasicStroke(4.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 10.0f,new float[] { 16.0f, 20.0f }, 0.0f));
			shape.graphics2d.drawRect(minX - padding / 2, minY - padding / 2, width, height);
		}
		URCommand.add(this);
	}

	@Override
	public void undo() {
		IIteratorList iterator = group.getIteratorList();
		while (iterator.Next()) {
			CreateShape shape = iterator.obtainNext();
			master.groupRemove(shape);
		}
			
	}

	@Override
	public void redo() {
		run();
		}

}