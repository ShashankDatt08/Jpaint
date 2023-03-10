package model;

public final class ShapeListManager {
	private static ShapeList shapeList = new ShapeList();
	private static ShapeList clipboardList = new ShapeList();
	private static ShapeList selectList = new ShapeList();
	private static ShapeList movingList = new ShapeList();
	private static ShapeList groupList = new ShapeList();


	public static ShapeList getShapeList() {
		return shapeList;
	}

	public static ShapeList getClipboardShapeList() {
		return clipboardList;
	}

	public static ShapeList getMovingShapeList() {
		return movingList;
	}

	public static ShapeList getSelectedShapeList() {
		return selectList;
	}
	
	public static ShapeList getGroupShapeList() {
		return groupList;
	}

}
