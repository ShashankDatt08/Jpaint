package view.draw;

import model.interfaces.IShape;
import view.gui.PaintCanvas;

public class HexagonStrat implements IShape {

	@Override
	public CreateShape createShape(ShapeInfo info, PaintCanvas canvas) {
		// TODO Auto-generated method stub
        return new Hexagon(info,canvas);
	}

}
