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
		
		switch(this.shadingType) {
		case FILLED_IN:
			Calculations calc = new Calculations(this.getStartPoint(), this.getEndPoint());
			Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.fillOval(calc.getX(), calc.getY(), calc.getx1(), calc.gety1());
			break;
		case OUTLINE:
			Calculations calculation = new Calculations(this.getStartPoint(), this.getEndPoint());
			Graphics2D graphicss2D = this.getPaintCanvas().getGraphics2D();
			graphicss2D.setStroke(new BasicStroke(5));
			graphicss2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphicss2D.drawOval(calculation.getX(), calculation.getY(), calculation.getx1(), calculation.gety1());
			break;
		case OUTLINE_AND_FILLED_IN:
			Calculations calculations = new Calculations(this.getStartPoint(), this.getEndPoint());
			Graphics2D graphicssss2D = this.getPaintCanvas().getGraphics2D();
			graphicssss2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphicssss2D.fillOval(calculations.getX(), calculations.getY(), calculations.getx1(), calculations.gety1());
			graphicssss2D.setStroke(new BasicStroke(5));
			graphicssss2D.setColor(colorMap.get(this.getSecondaryColor()));
			graphicssss2D.drawOval(calculations.getX(), calculations.getY(), calculations.getx1(), calculations.gety1());
			break;
		 default:
             throw new Error("Error in drawing shape.");
		}
	}
	
	@Override
	public void outlineSelect() {	
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		float flo[] = { 6.0f };
		graphics2D.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 6.0f, flo, 0.0f));
		graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
		int x = Math.min(startPoint.getX(), endPoint.getX());
		int y = Math.min(startPoint.getY(), endPoint.getY());
		int w = Math.abs(startPoint.getX() - endPoint.getX());
		int h = Math.abs(startPoint.getY() - endPoint.getY());
	    graphics2D.drawOval(x, y, w, h);
		
	}

	@Override
	public void flipShape() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rotateShape() {
		// TODO Auto-generated method stub
		
	}
	

}
