import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.BasicStroke;

public class Level1State extends GameState {


	private ArrayList<Sprite> sprite;
	private int timeCounter;
	private static final int GAME_TIME = 15;
	private Color bgColor;
	private Color fontColor;
	private Font font;
	private boolean statred;
	public static final int hPipeheight = 30;
	public static final int vPipeheight = 20;
	public static final int cabPipeheight = 60;

	public Level1State(GameStateManager gsm) {
		this.gsm = gsm;

		sprite = new ArrayList<Sprite>();
		sprite.add( new MoleLower(75 , Game.FRAME_HEIGHT -(hPipeheight+vPipeheight+cabPipeheight), KeyEvent.VK_S) );
		sprite.add( new MoleLower(Game.FRAME_WIDTH/2 - 75 , Game.FRAME_HEIGHT -(hPipeheight+vPipeheight+cabPipeheight), KeyEvent.VK_D) );
		sprite.add( new MoleLower(Game.FRAME_WIDTH - 150 -75 , Game.FRAME_HEIGHT -(hPipeheight+vPipeheight+cabPipeheight), KeyEvent.VK_F) );	
		sprite.add( new MoleUpper(75 , -290 +(hPipeheight+vPipeheight+cabPipeheight), KeyEvent.VK_J) );
		sprite.add( new MoleUpper(Game.FRAME_WIDTH/2 - 75 , -290 +(hPipeheight+vPipeheight+cabPipeheight), KeyEvent.VK_K) );
		sprite.add( new MoleUpper(Game.FRAME_WIDTH - 150 -75 , -290 +(hPipeheight+vPipeheight+cabPipeheight), KeyEvent.VK_L) );

		bgColor = new Color(192, 192, 192);
		fontColor = new Color(155, 155, 155);
		font = new Font("Century Gothic", Font.BOLD, 100);

		statred = false;
	}

	public void init() { 

		gsm.resetScore();
		score = 0;
		timeCounter = 0;

		for(Sprite s : sprite)
			s.init();

	}

	public int updateScore() {
		return score;
	}

	// Game Loops
	public void draw(Graphics2D g2d) {

		timeCounter++;

		drawBackground(g2d);

		if( !statred ) {

			int t = timeCounter/Game.FPS;

			if( t < 3 ) {
				g2d.setColor(new Color(155, 155, 155));
				g2d.setFont(new Font("Century Gothic", Font.BOLD, 100));
				g2d.drawString((3-t) + "...", Game.FRAME_WIDTH/2-100, Game.FRAME_HEIGHT/2+50 );
			}
			else {
				statred = true;
			}
		}
		else {

			if(timeCounter/Game.FPS < GAME_TIME) {
				drawScore(g2d);
				for(Sprite s : sprite)
					s.showMode(g2d);
			}
			else if(timeCounter/Game.FPS >= GAME_TIME && timeCounter/Game.FPS < GAME_TIME + 4 ) {
				g2d.setColor(fontColor);
				g2d.setFont(font);
				g2d.drawString("Times Up", Game.FRAME_WIDTH/2-200, Game.FRAME_HEIGHT/2 );
			}
			else if(timeCounter/Game.FPS == GAME_TIME + 4 ) {
				statred = false;
				gsm.setState(GameStateManager.LEVEL2STATE);
			}

			
		}
		
		drawPipe(g2d);
		drawKey(g2d);

	}

	private void drawBackground(Graphics2D g2d) {
		g2d.setColor(bgColor);
		g2d.fillRect(0, 0, Game.FRAME_WIDTH, Game.FRAME_HEIGHT);
	}

	private void drawScore(Graphics2D g2d) {
		g2d.setColor(fontColor);
		g2d.setFont(font);
		g2d.drawString("Score: " + gsm.getScore(), Game.FRAME_WIDTH/2-200, Game.FRAME_HEIGHT/2 );
	}

	private void drawPipe(Graphics2D g2d) {
		int thick = 5;
		// Upper
		g2d.setColor(new Color(0, 100, 0));
		g2d.fillRect(75 , hPipeheight, 150, vPipeheight);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawRect(75 , hPipeheight, 150, vPipeheight);

		g2d.setColor(new Color(0, 100, 0));
		g2d.fillRect(Game.FRAME_WIDTH/2 -75 , hPipeheight, 150, vPipeheight);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawRect(Game.FRAME_WIDTH/2 -75 , hPipeheight, 150, vPipeheight);

		g2d.setColor(new Color(0, 100, 0));
		g2d.fillRect(Game.FRAME_WIDTH -150 -75 , hPipeheight, 150, vPipeheight);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawRect(Game.FRAME_WIDTH -150 -75 , hPipeheight, 150, vPipeheight);

		g2d.setColor(new Color(0, 100, 0));
		g2d.fillRect(75-15 , hPipeheight+vPipeheight, 180, cabPipeheight);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawRect(75-15 , hPipeheight+vPipeheight, 180, cabPipeheight);

		g2d.setColor(new Color(0, 100, 0));
		g2d.fillRect(Game.FRAME_WIDTH/2 -90 , hPipeheight +vPipeheight, 180, cabPipeheight);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawRect(Game.FRAME_WIDTH/2 -90 , hPipeheight +vPipeheight, 180, cabPipeheight);

		g2d.setColor(new Color(0, 100, 0));
		g2d.fillRect(Game.FRAME_WIDTH -150 -75 -15 , hPipeheight +vPipeheight, 180, cabPipeheight);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawRect(Game.FRAME_WIDTH -150 -75 -15 , hPipeheight +vPipeheight, 180, cabPipeheight);

		g2d.setColor(new Color(0, 100, 0));
		g2d.fillRect(0, 0, Game.FRAME_WIDTH, hPipeheight);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawRect(0, 0, Game.FRAME_WIDTH, hPipeheight);

		// Lower
		g2d.setColor(new Color(0, 100, 0));
		g2d.fillRect(75 , Game.FRAME_HEIGHT -hPipeheight -25 -vPipeheight, 150, vPipeheight);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawRect(75 , Game.FRAME_HEIGHT -hPipeheight -25 -vPipeheight, 150, vPipeheight);

		g2d.setColor(new Color(0, 100, 0));
		g2d.fillRect(Game.FRAME_WIDTH/2 -75 , Game.FRAME_HEIGHT -hPipeheight -25 -vPipeheight, 150, vPipeheight);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawRect(Game.FRAME_WIDTH/2 -75 , Game.FRAME_HEIGHT -hPipeheight -25 -vPipeheight, 150, vPipeheight);

		g2d.setColor(new Color(0, 100, 0));
		g2d.fillRect(Game.FRAME_WIDTH -150 -75 , Game.FRAME_HEIGHT -hPipeheight -25 -vPipeheight, 150, vPipeheight);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawRect(Game.FRAME_WIDTH -150 -75 , Game.FRAME_HEIGHT -hPipeheight -25 -vPipeheight, 150, vPipeheight);

		g2d.setColor(new Color(0, 100, 0));
		g2d.fillRect(75-15 , Game.FRAME_HEIGHT -hPipeheight -25 -vPipeheight -cabPipeheight, 180, cabPipeheight);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawRect(75-15 , Game.FRAME_HEIGHT -hPipeheight -25 -vPipeheight -cabPipeheight, 180, cabPipeheight);

		g2d.setColor(new Color(0, 100, 0));
		g2d.fillRect(Game.FRAME_WIDTH/2 -90 , Game.FRAME_HEIGHT -hPipeheight -25 -vPipeheight -cabPipeheight, 180, cabPipeheight);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawRect(Game.FRAME_WIDTH/2 -90 , Game.FRAME_HEIGHT -hPipeheight -25 -vPipeheight -cabPipeheight, 180, cabPipeheight);

		g2d.setColor(new Color(0, 100, 0));
		g2d.fillRect(Game.FRAME_WIDTH -150 -75 -15 , Game.FRAME_HEIGHT -hPipeheight -25 -vPipeheight -cabPipeheight, 180, cabPipeheight);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawRect(Game.FRAME_WIDTH -150 -75 -15 , Game.FRAME_HEIGHT -hPipeheight -25 -vPipeheight -cabPipeheight, 180, cabPipeheight);

		g2d.setColor(new Color(0, 100, 0));
		g2d.fillRect(0, Game.FRAME_HEIGHT -hPipeheight -25, Game.FRAME_WIDTH, hPipeheight);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawRect(0, Game.FRAME_HEIGHT -hPipeheight -25, Game.FRAME_WIDTH, hPipeheight);

	}

	private void drawKey(Graphics2D g2d) {
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("Century Gothic", Font.BOLD, 50));

		// Upper
		g2d.drawString("J", 75 -15 +75, hPipeheight +vPipeheight +cabPipeheight -10);
		g2d.drawString("K", Game.FRAME_WIDTH/2 -90 +75 , hPipeheight +vPipeheight +cabPipeheight -10);
		g2d.drawString("L", Game.FRAME_WIDTH -150 -75 -15 +75 , hPipeheight +vPipeheight +cabPipeheight -10);

		// Lower
		g2d.drawString("S", 75 -15 +75, Game.FRAME_HEIGHT -hPipeheight -25 -vPipeheight -10 );
		g2d.drawString("D", Game.FRAME_WIDTH/2 -90 +75, Game.FRAME_HEIGHT -hPipeheight -25 -vPipeheight -10 );
		g2d.drawString("F", Game.FRAME_WIDTH -150 -75 -15 +75, Game.FRAME_HEIGHT -hPipeheight -25 -vPipeheight -10 );
	}

	public void keyPressed(int k) {
		for(Sprite s : sprite)
			s.keyPressed(k);
	}
	public void keyReleased(int k) {
		for(Sprite s : sprite)
			score += s.keyReleased(k);
	}
}