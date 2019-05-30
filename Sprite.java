import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public abstract class Sprite {
	protected int x;
	protected int y;
	protected int keyCode;
	protected boolean dead;
	protected boolean scored;

	public Sprite(int x,int y, int keyCode) {
		this.keyCode = keyCode;
		this.x = x;
		this.y = y;
		dead = false;
		scored = false;
	}

	public abstract void init();
	public abstract void showMode(Graphics2D g2d);
	public abstract void liveMode(Graphics2D g2d);
	public abstract void dieMode(Graphics2D g2d);
	public abstract int scoreUp();

	public boolean isDead() {
		return dead;
	}

	public abstract void keyPressed(int k);
	public abstract int keyReleased(int k);

}