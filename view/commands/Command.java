package view.commands;

import controller.Point;
import controller.CommandPattern.ICommandPattern;
import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;
import view.gui.IMode;
import view.gui.Mode;
import view.gui.PaintCanvas;

public class Command {
	private IMode paintmode;
	private ApplicationState applicationState;

	public Command(ApplicationState applicationState) {
		switch (applicationState.getActiveMouseMode()) {
		case DRAW:
			paintmode = Mode.getDrawMode();
			break;
		case SELECT:
			paintmode = Mode.getSelectMode();
			break;
		case MOVE:
			paintmode = Mode.getMoveMode();
			break;

		}
		this.applicationState = applicationState;
	}

	public ICommandPattern createCommand(Point startPoint, Point endPoint, PaintCanvas paintCanvas) {
		return paintmode.createCommand(startPoint, endPoint, applicationState, paintCanvas);
	}
}