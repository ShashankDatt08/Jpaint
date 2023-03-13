package view.draw;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import javax.swing.JOptionPane;

import controller.Point;
import model.ShapeConfiguration;
import view.gui.PaintCanvas;

public class Text extends CreateShape {

	public Text(ShapeInfo info, PaintCanvas paintCanvas) {
		super(info, paintCanvas);
	}

	private ShapeColorMap colorMap = ShapeColorMap.getInstance();

	@Override
	public CreateShape createShape() {
		return new Text(new ShapeInfo(new Point(this.startPoint.getX(), this.startPoint.getY()),
				new Point(this.endPoint.getX(), this.endPoint.getY()),
				new ShapeConfiguration(this.config.getActivePrimaryColor(), this.config.getActiveSecondaryColor(),
						this.config.getShapeType(), this.config.getShadingType())),
				this.paintCanvas);
	}

	@Override
	public void draw() {
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		int x = startPoint.getX() ;
		int y = startPoint.getY() ;
		Calculations calc = new Calculations(this.getStartPoint(), this.getEndPoint());
		String enter = JOptionPane.showInputDialog("Enter Text here : ");
        JOptionPane.getRootFrame().dispose();
		switch (this.shadingType) {
		case FILLED_IN:
			
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.drawString(enter, calc.getX(), calc.getY());
			break;
		case OUTLINE:
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.drawString(enter, x, y);
			break;
		case OUTLINE_AND_FILLED_IN:
			graphics2D.setColor(colorMap.get(this.getPrimaryColor()));
			graphics2D.drawString(enter, x, y);
			graphics2D.setStroke(new BasicStroke(5));
			graphics2D.setColor(colorMap.get(this.getSecondaryColor()));
			graphics2D.drawString(enter, x, y);
			break;
		default:
			throw new Error("Error in drawing shape.");
		}


	}

	@Override
	public void outlineSelect() {
		Graphics2D graphics2D = this.getPaintCanvas().getGraphics2D();
		int x = Math.min(startPoint.getX(), endPoint.getX());
		int y = Math.min(startPoint.getY(), endPoint.getY());
		String enter;
		enter = JOptionPane.showInputDialog("Enter Text here : ");
		graphics2D.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[] { 9 }, 0));
		graphics2D.drawString(enter, x, y);
	}

	@Override
	public void flipShape() {

	}

	@Override
	public void rotateShape() {
	}

}
