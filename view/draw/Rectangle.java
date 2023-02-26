package view.draw;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import controller.Point;
import model.ShapeConfiguration;
import view.gui.PaintCanvas;


public class Rectangle extends CreateShape{

    public Rectangle(ShapeInfo info, PaintCanvas paintCanvas) {
        super(info,paintCanvas);
    }
	private ShapeColorMap colorMap = ShapeColorMap.getInstance();

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

	@Override
	public void outlineSelect() {
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		float flo[] = { 6.0f };
		graphics2D.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 6.0f, flo, 0.0f));
		int x = Math.min(startPoint.getX(), endPoint.getX());
		int y = Math.min(startPoint.getY(), endPoint.getY());
		int w = Math.abs(startPoint.getX() - endPoint.getX());
		int h = Math.abs(startPoint.getY() - endPoint.getY());
		graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
	    graphics2D.drawRect(x, y, w, h);
				
	}


}
