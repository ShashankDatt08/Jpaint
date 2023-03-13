package view.draw;

import model.interfaces.IShape;
import view.gui.PaintCanvas;

public class PentagonStrat implements IShape {

	@Override
	public CreateShape createShape(ShapeInfo info, PaintCanvas canvas) {
		// TODO Auto-generated method stub
        return new Pentagon(info,canvas);
	}

}
