package model.interfaces;

import view.draw.CreateShape;
import view.draw.ShapeInfo;
import view.gui.PaintCanvas;

public interface IShape {
    CreateShape createShape(ShapeInfo info, PaintCanvas canvas);
}
