package model;

public class AStarThread implements Runnable{
	private Game g;
	private Sums p;
	private int x;
	private int y;

	public AStarThread(Game g, Sums p, int x, int y) {
		this.g= g;
		this.p = p;
		this.x = x;
		this.y = y;
		
	}
	
	@Override
	public void run() {
		int direction = 0;
		synchronized(p) {
		while(direction != -1) {
			direction = (new AStar(p.getPosX(), p.getPosY(), x, y, g.getGameObjects())).getNextStep();
			switch (direction) {
				case 0 : g.movePlayer(1,0,p); break;
				case 1 : g.movePlayer(0,-1,p); break;
				case 2 : g.movePlayer(-1,0,p); break;
				case 3 : g.movePlayer(0,1,p); break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	}
	public Sums getSums() {
		return p;
	}
		

}
