package view.draw;

import model.interfaces.IShape;
import view.gui.PaintCanvas;

public class LineStrat implements IShape {
    @Override
    public CreateShape createShape(ShapeInfo shapeInfo, PaintCanvas canvas) {
        return new Line(shapeInfo,canvas);
    }

}
