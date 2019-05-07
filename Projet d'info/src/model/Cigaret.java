package model;

public class Cigaret extends DeletableObject{
	public Cigaret(int X, int Y) {
		super(X, Y);
		user = "Teen";
		type = "SMOKE";
		lifePoints = 5;
		price = 10;
	}
	public Cigaret() {
		super();
		user = "Teen";
		type = "SMOKE";
		lifePoints = 5;
		price = 10;
	}
	public void activate (Sums s) {
		System.out.println("Smoke");
		((Teen) s).smoke(this);
		notifyDeletableObserver();
	}
	
	public boolean isObstacle() {
		return false;
	}
	public void makeSprite() {
		sprite = Constantes.cigaret;
	}

}
