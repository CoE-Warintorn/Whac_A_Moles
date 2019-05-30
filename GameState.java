import java.awt.*;
import java.awt.event.*;

public abstract class GameState {

	protected GameStateManager gsm;
	protected int score;

	public abstract void init();
	public abstract int updateScore();
	public abstract void draw(Graphics2D g2d);
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);
}