import java.awt.*;
import java.awt.event.*;

public class Level2State extends GameState {

	private Sprite sprite;
	private int timeCounter;
	private Color bgColor;
	private Color fontColor;
	private Font font;
	private boolean statred;
	private static final int GAME_TIME = 12;

	public Level2State(GameStateManager gsm) {
		this.gsm = gsm;

		sprite = new BigMole(KeyEvent.VK_SPACE);

		bgColor = new Color(192, 192, 192);
		fontColor = new Color(155, 155, 155);
		font = new Font("Century Gothic", Font.BOLD, 40);

		statred = false;
	}

	public void init() { 
		score = gsm.getScore();
		timeCounter = 0;
		sprite.init();
	}

	public int updateScore() {
		return score;
	}

	public void draw(Graphics2D g2d) {
		
		timeCounter++;

		drawBackground(g2d);

		if( !statred ) {

			int t = timeCounter/Game.FPS;

			if( t < 3 ) {
				g2d.setColor(new Color(155, 155, 155));
				g2d.setFont(new Font("Century Gothic", Font.BOLD, 100));
				g2d.drawString("!!!BONUS!!!", Game.FRAME_WIDTH/2-250, 300 );
			}
			else if( t < 6 ) {
				g2d.setColor(new Color(155, 155, 155));
				g2d.setFont(new Font("Century Gothic", Font.BOLD, 100));
				g2d.drawString("!!!BONUS!!!", Game.FRAME_WIDTH/2-250, 300 );
				g2d.drawString((6-t) + "...", Game.FRAME_WIDTH/2-100, 500 );
			}
			else {
				statred = true;
			}

		}
		else {

			if(timeCounter/Game.FPS < GAME_TIME) {
				drawScore(g2d);
				sprite.showMode(g2d);
				drawKey(g2d);
			}
			else if(timeCounter/Game.FPS >= GAME_TIME && timeCounter/Game.FPS < GAME_TIME + 4 ) {
				g2d.setColor(new Color(155, 155, 155));
				g2d.setFont(new Font("Century Gothic", Font.BOLD, 100));
				g2d.drawString("Times Up", Game.FRAME_WIDTH/2-200, 300 );
			}
			else if(timeCounter/Game.FPS == GAME_TIME + 4 ) {
				statred = false;
				gsm.setState(GameStateManager.MENUSTATE);
			}
			
			;
		}
		
		

	}

	private void drawBackground(Graphics2D g2d) {
		g2d.setColor(bgColor);
		g2d.fillRect(0, 0, Game.FRAME_WIDTH, Game.FRAME_HEIGHT);
	}

	private void drawScore(Graphics2D g2d) {
		g2d.setColor(fontColor);
		g2d.setFont(font);
		g2d.drawString("Score: " + gsm.getScore(), Game.FRAME_WIDTH*3/4 - 100, 80 );
	}

	private void drawKey(Graphics2D g2d) {
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("Century Gothic", Font.BOLD, 80));
		g2d.drawString("SpaceBar", Game.FRAME_WIDTH*1/4, Game.FRAME_HEIGHT*3/4 );
	}

	public void keyPressed(int k) {
		sprite.keyPressed(k);
	}
	public void keyReleased(int k) {
		score += sprite.keyReleased(k);
	}
}