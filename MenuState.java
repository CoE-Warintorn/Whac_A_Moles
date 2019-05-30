import java.awt.*;
import java.awt.event.*;

public class MenuState extends GameState {

	private String[] options = {"Start", "Exit"};
	private Color titleColor;
	private Font titleFont;
	private Font font;
	private int currentOption;
	private Color bg;

	public MenuState(GameStateManager gsm) {

		this.gsm = gsm;

		titleColor = new Color(128, 0, 0); 
		titleFont = new Font("Century Gothic", Font.BOLD, 90);
		font = new Font("Arial", Font.PLAIN, 40);
		bg = new Color(180, 180, 180);
	}

	public void init() {
		currentOption = 0;
	}

	public int updateScore() { 
		score = gsm.getScore();
		return score; 
	}

	public void draw(Graphics2D g2d) {

		drawBackground(g2d);

		g2d.setColor(titleColor);
		g2d.setFont(titleFont);
		g2d.drawString(Game.GAME_NAME, (Game.FRAME_WIDTH)/4 - 110, (Game.FRAME_HEIGHT)/4);

		g2d.setColor(new Color(155, 155, 155));
		g2d.setFont(new Font("Century Gothic", Font.BOLD, 70));
		g2d.drawString("High Score: " + gsm.getScore(), (Game.FRAME_WIDTH)/4 - 50, (Game.FRAME_HEIGHT)/4+150);

		// draw menu options
		g2d.setFont(font);
		for(int i = 0; i < options.length; i++) {
			if(i == currentOption) {
				g2d.setColor(Color.BLACK);
			}
			else {
				g2d.setColor(Color.RED);
			}
			g2d.drawString(options[i], (Game.FRAME_WIDTH)/2 - 50, (Game.FRAME_HEIGHT)/4 + 250 + i*100);
		}

	}

	private void drawBackground(Graphics2D g2d) {
		g2d.setColor(bg);
		g2d.fillRect(0, 0, Game.FRAME_WIDTH, Game.FRAME_HEIGHT);
	}

	public void select() {
		switch(currentOption) {
			case 0: // Start
				gsm.setState(GameStateManager.LEVEL1STATE);
				break;
			case 1: // Quit
				System.exit(0);
				break;
		}
	}

	public void keyPressed(int k) {

		if(k == KeyEvent.VK_ENTER) {
			select();
		}

		if(k == KeyEvent.VK_UP) {
			currentOption--;
			if(currentOption == -1) {
				currentOption = options.length -1;
			}
		}

		if(k == KeyEvent.VK_DOWN) {
			currentOption++;
			if(currentOption == options.length) {
				currentOption = 0;
			}
		}
	}

	public void keyReleased(int k) {}
}