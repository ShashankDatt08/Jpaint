package view.gui;

import controller.Point;
import controller.CommandPattern.ICommandPattern;
import model.persistence.ApplicationState;
import view.commands.SelectShapes;

public class Selecting implements IMode {
    @Override
    public ICommandPattern createCommand(Point start, Point end, ApplicationState mode, PaintCanvas paintCanvas) {
        return new SelectShapes(start,end);
    }
}
