package view.gui;

import controller.Point;
import controller.CommandPattern.ICommandPattern;
import model.persistence.ApplicationState;

//strategy
public interface IMode {
    ICommandPattern createCommand(Point start, Point end, ApplicationState mode, PaintCanvas paintCanvas);
}
