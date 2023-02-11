package model.interfaces;

import view.draw.Ellipse;
import view.draw.Rectangle;
import view.draw.Triangle;

public interface IShapeShadingType {

	void draw(Rectangle r);

	void draw(Ellipse e);

	void draw(Triangle t);

}
