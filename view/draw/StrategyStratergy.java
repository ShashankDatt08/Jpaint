package view.draw;

import model.ShapeShadingType;
import model.interfaces.IShapeShadingType;
import view.gui.FilledStrategy;
import view.gui.OutlineAndFilledInStrategy;
import view.gui.OutlineOnlyStrategy;

public class StrategyStratergy {
	public IShapeShadingType createStrategy(ShapeShadingType shadingType) {
		IShapeShadingType strategy = null;
		switch (shadingType) {
		case FILLED_IN:
			strategy = new FilledStrategy();
			break;
		case OUTLINE:
			strategy = new OutlineOnlyStrategy();
			break;
		case OUTLINE_AND_FILLED_IN:
			strategy = new OutlineAndFilledInStrategy();
			break;
		}
		return strategy;
	}
}
