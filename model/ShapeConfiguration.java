package model;

public class ShapeConfiguration {

	public ShapeColor getActivePrimaryColor() {
		return activePrimaryColor;
	}

	public void setActivePrimaryColor(ShapeColor activePrimaryColor) {
		this.activePrimaryColor = activePrimaryColor;
	}

	public ShapeColor getActiveSecondaryColor() {
		return activeSecondaryColor;
	}

	public void setActiveSecondaryColor(ShapeColor activeSecondaryColor) {
		this.activeSecondaryColor = activeSecondaryColor;
	}

	public ShapeType getShapeType() {
		return shapeType;
	}

	public void setShapeType(ShapeType shapeType) {
		this.shapeType = shapeType;
	}

	public ShapeShadingType getShadingType() {
		return shadingType;
	}

	public void setShadingType(ShapeShadingType shadingType) {
		this.shadingType = shadingType;
	}

	public ShapeColor activePrimaryColor;

	public ShapeColor activeSecondaryColor;

	public ShapeType shapeType;

	public ShapeShadingType shadingType;

	public ShapeConfiguration(ShapeColor activePrimaryColor, ShapeColor activeSecondaryColor, ShapeType shapeType,
			ShapeShadingType shadingType) {

		this.activePrimaryColor = activePrimaryColor;

		this.activeSecondaryColor = activeSecondaryColor;

		this.shapeType = shapeType;

		this.shadingType = shadingType;

	}

}
