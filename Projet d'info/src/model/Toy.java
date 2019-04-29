package model;
import java.util.Random;
public class Toy extends ActivableObject{
	private int value;
	private int BringHappiness;
	public Toy(int x, int y) {
		super(x,y);
		Random r = new Random();
		value = r.nextInt(20-10+1)+1;
		BringHappiness = r.nextInt(10-5+1)+1;
	}
	public void activate(Kid s) {
		s.Play(this);
	}
	public int getValue(){
		return value;
	}
	public int BeHappy() {
		return BringHappiness;
	}
	public boolean isObstacle() {
		return false;
	}
	public void makeSprite() {
	}
}