package view.draw;

import java.awt.Color;
import java.awt.Graphics2D;

import model.ShapeColor;
import model.ShapeList;
import model.ShapeListManager;
import model.interfaces.IIteratorList;
import model.interfaces.ICheck;
import view.gui.PaintCanvas;

public class Shaper implements ICheck {
	private ShapeList shapeList = ShapeListManager.getShapeList();
	private ShapeList selectedList = ShapeListManager.getSelectedShapeList();
	private PaintCanvas paintCanvas;

	public Shaper(PaintCanvas paintCanvas) {
		this.paintCanvas = paintCanvas;
	}

	@Override
	public void update() {
		clearCanvas();
		IIteratorList iteratorList = shapeList.getIteratorList();
		while (iteratorList.Next()) {
			iteratorList.obtainNext().draw();
		}
	}

	@Override
	public void updateOutline() {
		IIteratorList iteratorList = selectedList.getIteratorList();
		while (iteratorList.Next()) {
			iteratorList.obtainNext().outlineSelect();
		}
	}
	@Override
	public void flipShape() {
		IIteratorList iteratorList = selectedList.getIteratorList();
		while (iteratorList.Next()) {
			iteratorList.obtainNext().flipShape();
		}		
	}

	@Override
	public void rotateShape() {
		IIteratorList iteratorList = selectedList.getIteratorList();
		while (iteratorList.Next()) {
			iteratorList.obtainNext().rotateShape();
		}			
	}
	
	
	private void clearCanvas() {
		Graphics2D graphics2D = paintCanvas.getGraphics2D();
		graphics2D.setColor(Color.WHITE);
		graphics2D.fillRect(0, 0, 1200, 800);
	}



}
