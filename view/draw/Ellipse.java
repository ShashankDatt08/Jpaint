package view.draw;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import controller.Point;
import model.ShapeConfiguration;
import view.gui.PaintCanvas;

public class Ellipse extends CreateShape {

	public Ellipse(ShapeInfo info, PaintCanvas paintCanvas) {
		super(info, paintCanvas);
	}
	private ShapeColorMap colorMap = ShapeColorMap.getInstance();

	public CreateShape createShape() {
		return new Ellipse(new ShapeInfo(new Point(this.startPoint.getX(), this.startPoint.getY()),
				new Point(this.endPoint.getX(), this.endPoint.getY()),
				new ShapeConfiguration(this.config.getActivePrimaryColor(), this.config.getActiveSecondaryColor(),
						this.config.getShapeType(), this.config.getShadingType())),
				this.paintCanvas);
	}
	
	@Override
	public void draw() {
		Calculations calc = new Calculations(this.getStartPoint(), this.getEndPoint());
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		switch(this.shadingType) {
		case FILLED_IN:
			
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.fillOval(calc.getX(), calc.getY(), calc.getx1(), calc.gety1());
			break;
		case OUTLINE:
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.drawOval(calc.getX(), calc.getY(), calc.getx1(), calc.gety1());
			break;
		case OUTLINE_AND_FILLED_IN:
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.fillOval(calc.getX(), calc.getY(), calc.getx1(), calc.gety1());
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(colorMap.get(this.getSecondaryColor()));
			graphics2D.drawOval(calc.getX(), calc.getY(), calc.getx1(), calc.gety1());
			break;
		 default:
             throw new Error("Error in drawing shape.");
		}
	}
	
	@Override
	public void outlineSelect() {	
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		graphics2D.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0));
		int x = Math.min(startPoint.getX(), endPoint.getX());
		int y = Math.min(startPoint.getY(), endPoint.getY());
		int w = Math.abs(startPoint.getX() - endPoint.getX());
		int h = Math.abs(startPoint.getY() - endPoint.getY());
	    graphics2D.drawOval(x, y, w, h);
		
	}

	@Override
	public void flipShape() {
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
		Calculations calc = new Calculations(this.getStartPoint(), this.getEndPoint());
		int x = calc.getX();
		int y = calc.getY();
		int temp = x;
		x = y;
		y = temp;	
		switch(this.shadingType) {
		case FILLED_IN:		
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.fillOval(x,y, calc.getx1(), calc.gety1());
			break;
		case OUTLINE:
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.drawOval(x,y, calc.getx1(), calc.gety1());
			break;
		case OUTLINE_AND_FILLED_IN:
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.fillOval(x,y, calc.getx1(), calc.gety1());
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(colorMap.get(this.getSecondaryColor()));
			graphics2D.drawOval(x,y, calc.getx1(), calc.gety1());
			break;
		 default:
             throw new Error("Error in flipping shape.");
		}
	}

	@Override
	public void rotateShape() {
		Calculations calc = new Calculations(this.getStartPoint(), this.getEndPoint());
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		graphics2D.rotate(Math.toRadians(180), this.getStartPoint().getX(), this.getStartPoint().getY());

		switch(this.shadingType) {
		case FILLED_IN:			
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.fillOval(calc.getX(), calc.getY(), calc.getx1(), calc.gety1());
			break;
		case OUTLINE:
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.drawOval(calc.getX(), calc.getY(), calc.getx1(), calc.gety1());
			break;
		case OUTLINE_AND_FILLED_IN:
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.fillOval(calc.getX(), calc.getY(), calc.getx1(), calc.gety1());
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(colorMap.get(this.getSecondaryColor()));
			graphics2D.drawOval(calc.getX(), calc.getY(), calc.getx1(), calc.gety1());
			break;
		 default:
             throw new Error("Error in rotating shape.");
		}
		
	}
	

}
