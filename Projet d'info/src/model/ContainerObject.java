package model;

import java.util.ArrayList;
import view.Map;

public class ContainerObject extends ActivableObject{
	private ArrayList<GameObject> objectContained = new ArrayList<GameObject>();
	private int row;
	public ContainerObject(int x, int y) {
		super(x,y);
		type = "STOCK";
		for (int i = 0; i<6; i++) {
			objectContained.add(new Apple());
		}
	}
	public ContainerObject() {
		super();
		type = "STOCK";
	}
	public void activate(Sums s) {
		this.open();
	}
	public void open(ContainerObject this) {
		Map.getInstance().drawContent(this);
	}
	public ArrayList<GameObject> switchRow(int row) {
		this.row = row;
		ArrayList<GameObject> objectsToReturn = new ArrayList<GameObject>(4);
		for (int i = 0; i < 4; i++) {
			if (i+4*row < objectContained.size()) {
				objectsToReturn.add(objectContained.get(i+row*4));
			}
		}
		return objectsToReturn;
	}
	@Override
	public boolean isObstacle() {
		return true;
	}

	@Override
	public void makeSprite() {
		
	}

}