package view.gui;

//static factory
public class Mode {
	public static IMode getDrawMode() {
		return new Drawing();
	}

	public static IMode getSelectMode() {
		return new Selecting();
	}

	public static IMode getMoveMode() {
		return new Moving();
	}

}
