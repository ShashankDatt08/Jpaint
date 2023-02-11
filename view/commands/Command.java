package view.commands;

import controller.Point;
import controller.CommandPattern.ICommandPattern;
import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;
import view.gui.IMode;
import view.gui.ModeStrat;
import view.gui.PaintCanvas;

public class Command {
	private IMode paintmode;
	private ApplicationState applicationState;

	public Command(ApplicationState applicationState) {
		switch (applicationState.getActiveMouseMode()) {
		case DRAW:
			paintmode = ModeStrat.getDrawMode();
			break;
		case SELECT:
			paintmode = ModeStrat.getSelectMode();
			break;
		case MOVE:
			paintmode = ModeStrat.getMoveMode();
			break;

		}
		this.applicationState = applicationState;
	}

	public ICommandPattern createCommand(Point startPoint, Point endPoint, PaintCanvas paintCanvas) {
		return paintmode.createCommand(startPoint, endPoint, applicationState, paintCanvas);
	}
}