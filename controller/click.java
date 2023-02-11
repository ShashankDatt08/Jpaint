package controller;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controller.CommandPattern.ICommandPattern;
import model.interfaces.IApplicationState;
import model.persistence.ApplicationState;
import view.commands.Command;
import view.gui.PaintCanvas;

public class click extends MouseAdapter {
	private Command command;
	private Point startPoint;
	private Point endPoint;
	private ApplicationState applicationState;
	private ICommandPattern iCommand;
	private PaintCanvas paintCanvas;

	public click(ApplicationState applicationState, PaintCanvas paintCanvas) {
		this.applicationState = applicationState;
		this.paintCanvas = paintCanvas;
		addMouseListener(this);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		startPoint = new Point(e.getX(), e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		endPoint = new Point(e.getX(), e.getY());
		command = new Command(applicationState);
		iCommand = command.createCommand(startPoint, endPoint, paintCanvas);
		iCommand.run();
	}

}