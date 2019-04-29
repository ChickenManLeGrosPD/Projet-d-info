package model;

public abstract class ActivableObject extends GameObject implements Activable {
	protected int LifePoints;
	protected String type = "INTERACT";
	
	public ActivableObject(int x, int y) {
		super(x,y);
	}
	public ActivableObject() {
		super();
	}
	public void activate(Sums s) {
		
	}
	public String getType() {
		return type;
	}
	

}