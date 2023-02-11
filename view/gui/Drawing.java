package view.gui;

import controller.Point;
import controller.CommandPattern.ICommandPattern;
import model.persistence.ApplicationState;
import view.commands.DrawShape;

public class Drawing implements IMode {
    @Override
    public ICommandPattern createCommand(Point start, Point end, ApplicationState mode, PaintCanvas paintCanvas) {
        return new DrawShape(start,end,mode,paintCanvas);
    }

}
