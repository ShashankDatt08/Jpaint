package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.gui.PaintCanvas;

public class click extends MouseAdapter {
	private PaintCanvas paint;
	private int X1;
	private int X2;
	private int X;
	private int Y;
	
	public click(PaintCanvas paint) {
		this.paint = paint;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		X = e.getX();
		Y = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		X1 = Math.abs(X - e.getX());
		X2 = Math.abs(Y - e.getY());
		int x = Math.min(X, e.getX());
		int y = Math.min(Y, e.getY());
		paint.drawingNewRectangle(x, y, X1, X2);
	}
}
