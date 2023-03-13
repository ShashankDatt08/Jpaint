package view.draw;

import java.awt.Color;
import java.util.EnumMap;

import model.ShapeColor;

public final class ShapeColorMap {
	private static ShapeColorMap instance = new ShapeColorMap();
	private final EnumMap<ShapeColor, Color> colorMap = new EnumMap<ShapeColor, Color>(ShapeColor.class);

	private ShapeColorMap() {

		colorMap.put(ShapeColor.BLACK, Color.BLACK);
		colorMap.put(ShapeColor.BLUE, Color.BLUE);
		colorMap.put(ShapeColor.CYAN, Color.CYAN);
		colorMap.put(ShapeColor.DARK_GRAY, Color.DARK_GRAY);
		colorMap.put(ShapeColor.GRAY, Color.GRAY);
		colorMap.put(ShapeColor.GREEN, Color.GREEN);
		colorMap.put(ShapeColor.LIGHT_GRAY, Color.LIGHT_GRAY);
		colorMap.put(ShapeColor.MAGENTA, Color.MAGENTA);
		colorMap.put(ShapeColor.ORANGE, Color.ORANGE);
		colorMap.put(ShapeColor.PINK, Color.PINK);
		colorMap.put(ShapeColor.RED, Color.RED);
		colorMap.put(ShapeColor.WHITE, Color.WHITE);
		colorMap.put(ShapeColor.YELLOW, Color.YELLOW);

	}

	public static Color getInstance(ShapeColor color) {
		return instance.get(color);
	}
		

	public Color get(ShapeColor enumColor) {
		return colorMap.get(enumColor);
	}

}