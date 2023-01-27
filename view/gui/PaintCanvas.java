package view.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import controller.CommandPattern.URCommand;
import view.interfaces.IUndoable;

public class PaintCanvas extends JComponent implements IUndoable {

	private List<Rectangle> rectangle;
    private List<Rectangle> removed;

	public PaintCanvas() {
		rectangle = new ArrayList<>();
		removed = new ArrayList<>();
        
    }

	public void drawingNewRectangle(int x, int y, int width, int height) {
		rectangle.add(new Rectangle(x, y, width, height));
		repaint();
	}
	
	@Override
	public void undo() {
		if (!rectangle.isEmpty()) {
			removed.add(rectangle.remove(rectangle.size() - 1));
            repaint();
        }		
	}

	@Override
	public void redo() {
		if (!removed.isEmpty()) {
			rectangle.add(removed.remove(removed.size() - 1));
			 repaint();
	        }		
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		for (Rectangle recta : rectangle) {
			g.drawRect(recta.x, recta.y, recta.width, recta.height);
			URCommand.add(this);
		}
	    
		graphics2d.setColor(Color.GREEN);
		graphics2d.fillRect(12, 13, 200, 400);

		// Outlined rectangle
		graphics2d.setStroke(new BasicStroke(5));
		graphics2d.setColor(Color.BLUE);
		graphics2d.drawRect(12, 13, 200, 400);

		// Selected Shape
		Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[] { 9 }, 0);
		graphics2d.setStroke(stroke);
		graphics2d.setColor(Color.BLACK);
		graphics2d.drawRect(7, 8, 210, 410);
	}

}
