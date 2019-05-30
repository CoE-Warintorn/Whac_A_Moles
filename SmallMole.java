import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public abstract class SmallMole extends Sprite {

	protected int speedMove;

	protected int startX;
	protected int startY;

	private int timeCounter;
	private double timeDisappear = 0.3;
	private double timeRespawn = 0.7;

	protected int randomSpeed() {  
	   return (int)(Math.random() * 5) + 1;
	}

	protected boolean randomShow() {  
	   return Math.random() < 0.01;
	}

	public SmallMole(int x, int y, int keyCode) {
		super(x, y, keyCode);
		startX = x;
		startY = y;
	}

	public void init() {
		timeCounter = 0;
		x = startX;
		y = startY;
	}

	public void showMode(java.awt.Graphics2D g2d){
		
		if( isDead() ) {
			timeCounter++;
			dieMode(g2d);
			if( (double)timeCounter/Game.FPS == timeDisappear ) {
				x = startX;
				y = startY;
			}
			if( (double)timeCounter/Game.FPS == timeRespawn ) {
				dead = false;
				scored = false;
				timeCounter = 0;
			}
		}
		else {
			liveMode(g2d);
		}
	}

	public int scoreUp() {
		return 10;
	}

	public abstract boolean beatable();

	public void keyPressed(int k) {
		
		if(k == keyCode && beatable() && !isDead()) { 	
			dead = true;
		}
	}

	public int keyReleased(int k) {

		if(k == keyCode && !scored && isDead()){ 
			scored = true;
			return scoreUp(); 
		}
		return 0;
	}
}