package view.draw;

import controller.Point;
import model.ShapeConfiguration;
import view.gui.PaintCanvas;


public class Rectangle extends CreateShape{

    public Rectangle(ShapeInfo info, PaintCanvas paintCanvas) {
        super(info,paintCanvas);
    }

    public void draw() {
        strategy.draw(this);
    }

    @Override
    public CreateShape createShape() {
        return new Rectangle(new ShapeInfo(new Point(this.startPoint.getX(),this.startPoint.getY()),
                new Point(this.endPoint.getX(),this.endPoint.getY()),
                new ShapeConfiguration(this.config.getActivePrimaryColor(),this.config.getActiveSecondaryColor(),this.config.getShapeType(),this.config.getShadingType())),
                this.paintCanvas);
    }


}
