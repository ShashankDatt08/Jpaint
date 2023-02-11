package view.draw;

import controller.Point;
import model.ShapeConfiguration;
import view.gui.PaintCanvas;

public class Triangle extends CreateShape{

    public Triangle(ShapeInfo info, PaintCanvas paintCanvas) {
        super(info,paintCanvas);
    }

    @Override
    public void draw() {
        strategy.draw(this);
    }

    @Override
    public CreateShape createShape() {
        return new Triangle(new ShapeInfo(new Point(this.startPoint.getX(),this.startPoint.getY()),
                new Point(this.endPoint.getX(),this.endPoint.getY()),
                new ShapeConfiguration(this.config.getActivePrimaryColor(),this.config.getActiveSecondaryColor(),this.config.getShapeType(),this.config.getShadingType())),
                this.paintCanvas);
    }

}
