package view.draw;

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
	private ShapeColorMap colorMap = ShapeColorMap.getInstance();

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

	private void clearCanvas() {
		Graphics2D graphics2D = paintCanvas.getGraphics2D();
		graphics2D.setColor(colorMap.get(ShapeColor.WHITE));
		graphics2D.fillRect(0, 0, 1200, 800);
	}

}
