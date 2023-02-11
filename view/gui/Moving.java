package view.gui;

import controller.Point;
import controller.CommandPattern.ICommandPattern;
import model.persistence.ApplicationState;
import view.commands.MoveShapes;

public class Moving implements IMode {
    @Override
    public ICommandPattern createCommand(Point start, Point end, ApplicationState mode, PaintCanvas paintCanvas) {
        return new MoveShapes(end);
    }
}
