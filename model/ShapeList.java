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


	public void removeShape(CreateShape shape) {
		this.createShape.remove(shape);
		size--;
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
		//size++;
		alertOutline();
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
