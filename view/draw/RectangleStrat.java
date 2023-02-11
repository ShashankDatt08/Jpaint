package view.draw;

import model.interfaces.IShape;
import view.gui.PaintCanvas;

public class RectangleStrat implements IShape {
    @Override
    public CreateShape createShape(ShapeInfo shapeInfo, PaintCanvas canvas) {
        return new Rectangle(shapeInfo,canvas);
    }
}
