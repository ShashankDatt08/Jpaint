package model;

import java.util.ArrayList;
import java.util.Iterator;

import model.interfaces.IIteratorList;
import model.interfaces.ICheck;
import model.interfaces.IMatter;
import view.draw.CreateShape;

public class ShapeList implements IMatter {
	private ArrayList<CreateShape> createShape = new ArrayList<CreateShape>();
	private ArrayList<ICheck> check = new ArrayList<>();
	private int size;
	private ArrayList<CreateShape> shapes = new ArrayList<CreateShape>();
	private ArrayList<CreateShape> groupShape = new ArrayList<CreateShape>();
	private ArrayList<CreateShape> flip = new ArrayList<CreateShape>(); 
	private ArrayList<CreateShape> rotate = new ArrayList<CreateShape>(); 



	public void removeShape(CreateShape shape) {
		this.createShape.remove(shape);
		size--;
		alert();
	}
	
	public void groupAdd(CreateShape shape) {
		this.groupShape.add(shape);
		alert();
	}

	
	public void groupRemove(CreateShape shape) {
		this.groupShape.remove(shape);
		alert();
	}


	@Override
	public void registerObserver(ICheck observer) {
		this.check.add(observer);
	}

	public void addShape(CreateShape shape) {
		this.createShape.add(shape);
		size++;
		alert();
	}
	
	public void add(CreateShape shape) {
		this.shapes.add(shape);
		size++;
		alertOutline();
	}
	
	public void flipShape(CreateShape shape) {
		this.flip.add(shape);
		alertFlip();
	}
	public void rotateShape(CreateShape shape) {
		this.rotate.add(shape);
		alertRotate();
	}


	@Override
	public void cutObserver(ICheck observer) {
		this.check.remove(observer);
	}

	private void alert() {
		for (ICheck iCheck : check) {
			iCheck.update();
		}
	}
	
	private void alertOutline() {
		for (ICheck iCheck : check) {
			iCheck.updateOutline();
		}
	}
	
	private void alertFlip() {
		for (ICheck iCheck : check) {
			iCheck.flipShape();
		}		
	}
	
	private void alertRotate() {
		for (ICheck iCheck : check) {
			iCheck.rotateShape();
		}		
	}

	public void clear() {
		createShape.clear();
	}

	public IIteratorList getIteratorList() {
		return new ShapeListIterator();
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return createShape.isEmpty();
	}

	class ShapeListIterator implements IIteratorList {

		private Iterator<CreateShape> iti = createShape.iterator();

		@Override
		public boolean Next() {
			return iti.hasNext();
		}

		@Override
		public CreateShape obtainNext() {
			return iti.next();
		}

	}


}
