package view.draw;

import controller.Point;
import model.ShapeConfiguration;
import view.gui.PaintCanvas;

public class Ellipse extends CreateShape {

	public Ellipse(ShapeInfo info, PaintCanvas paintCanvas) {
		super(info, paintCanvas);
	}

	public CreateShape createShape() {
		return new Ellipse(new ShapeInfo(new Point(this.startPoint.getX(), this.startPoint.getY()),
				new Point(this.endPoint.getX(), this.endPoint.getY()),
				new ShapeConfiguration(this.config.getActivePrimaryColor(), this.config.getActiveSecondaryColor(),
						this.config.getShapeType(), this.config.getShadingType())),
				this.paintCanvas);
	}

	@Override
	public void draw() {
		strategy.draw(this);
	}

}
