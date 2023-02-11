package view.draw;

import model.interfaces.IShape;
import view.gui.PaintCanvas;

public class TriangleStrat implements IShape {
    @Override
    public CreateShape createShape(ShapeInfo shapeInfo, PaintCanvas canvas) {
        return new Triangle(shapeInfo,canvas);
    }
}
