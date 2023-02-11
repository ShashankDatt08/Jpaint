package view.commands;

import controller.Point;
import controller.CommandPattern.URCommand;
import controller.CommandPattern.ICommandPattern;
import model.ShapeConfiguration;
import model.ShapeList;
import model.ShapeListManager;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.draw.CreateShape;
import view.draw.ShapeStrat;
import view.draw.ShapeInfo;
import view.gui.PaintCanvas;
import view.interfaces.IUndoable;

public class DrawShape implements ICommandPattern, IUndoable {
	private ShapeInfo shapeInfo;
	private PaintCanvas paintCanvas;
	private ShapeList shapeList = ShapeListManager.getShapeList();
	private CreateShape shape;

	public DrawShape(Point startPoint, Point endPoint, ApplicationState applicationState, PaintCanvas paintCanvas) {
		ShapeConfiguration shapeConfig = new ShapeConfiguration(applicationState.getActivePrimaryColor(),
				applicationState.getActiveSecondaryColor(), applicationState.getActiveShapeType(),
				applicationState.getActiveShapeShadingType());
		shapeInfo = new ShapeInfo(startPoint, endPoint, shapeConfig);
		this.paintCanvas = paintCanvas;
	}

	@Override
	public void run() {
		IShape factory = ShapeStrat.getFactory(shapeInfo.getShapeConfiguration().getShapeType());
		shape = factory.createShape(shapeInfo, paintCanvas);
		shapeList.addShape(shape);
		URCommand.add(this);
	}

	@Override
	public void undo() {
		shapeList.removeShape(shape);
	}

	@Override
	public void redo() {
		shapeList.addShape(shape);
	}
}
