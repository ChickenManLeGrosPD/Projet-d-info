package model;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.Window;
import view.MapDrawer;

public class Door extends ActivableObject{
	private MapDrawer mapDrawer = MapDrawer.getInstance();
	private String destination;
	private char character;

	public Door(int X, int Y, String s, char c) {
		super(X, Y);
		destination = s;
		character = c;
	}
	public Door() {
		super();
	}
	public boolean isObstacle() {
		return true;
	}
	public void activate(Sums e) {
		Game game = Game.getInstance();
		if (e == game.getActivePlayer()) {
			game.changeMap(destination);
			mapDrawer.changeMap(Game.getInstance().getCurrentMap());
			int sizeH = mapDrawer.getCurrentMap().getSizeH();
			int sizeW = mapDrawer.getCurrentMap().getSizeW();
			switch (character) {
				case 'N' : e.teleportation(Math.round(sizeW/2) , 1); break;
				case 'S' : e.teleportation(Math.round(sizeW/2) ,sizeH - 2); break;
				case 'W' : e.teleportation(1, Math.round(sizeH/2) - 1); break;
				case 'E' : e.teleportation(sizeW - 2 , Math.round(sizeH/2) - 1); break;
				case 'H' : e.teleportation(e.getHouse().getDoor().getPosX(), e.getHouse().getDoor().getPosY() + 1); break;
				case 'M' : e.teleportation(6, 6); break;
				case 's' : Spa.getInstance().activate(e); e.teleportation (0, game.getCurrentMap().getSizeH() + 5); break;
			}
		}
		else {
			game.getCurrentMap().getObjects().remove(e); 
			game.getMaps().get(this.getDestination()).addObject(e);
			if (character == 's') {
				Spa.getInstance().activate(e); e.teleportation(0, game.getCurrentMap().getSizeH() + 5);
			}
		}
	}
	
	public void makeSprite() {
	}
	public char getChar() {
		return character;
	}
	public String getDestination() {
		return destination;
	}
}
