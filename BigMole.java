import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BigMole extends Sprite {

	private static final int bigmoleSize = 500;

	public BigMole(int keyCode) {
		super(0,0,keyCode);
	}

	public void init() {

	}

	public void showMode(Graphics2D g2d){
		if( isDead() )	dieMode(g2d);
		else 			liveMode(g2d);
	}

	public void liveMode(Graphics2D g2d) {
		int thick = 10;
		// Head
		g2d.setColor(new Color(139, 69, 19)); // Brown Color
		g2d.fillOval((Game.FRAME_WIDTH-bigmoleSize)/2, (Game.FRAME_HEIGHT-bigmoleSize)/2, bigmoleSize, bigmoleSize);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawOval((Game.FRAME_WIDTH-bigmoleSize)/2, (Game.FRAME_HEIGHT-bigmoleSize)/2, bigmoleSize, bigmoleSize);
		// Black Eye
		g2d.setColor(Color.BLACK);
		g2d.fillOval((Game.FRAME_WIDTH-70)/2-70, (Game.FRAME_HEIGHT-150)/2-70, 70, 150);
		g2d.fillOval((Game.FRAME_WIDTH-70)/2+70, (Game.FRAME_HEIGHT-150)/2-70, 70, 150);
		// White Eye
		g2d.setColor(Color.WHITE);
		g2d.fillOval((Game.FRAME_WIDTH-70)/2-70+5, (Game.FRAME_HEIGHT-150)/2-50, 30, 80);
		g2d.fillOval((Game.FRAME_WIDTH-70)/2+70+5, (Game.FRAME_HEIGHT-150)/2-50, 30, 80);
		// Nose
		g2d.setColor(new Color(255, 102, 102)); // Pink Color
		g2d.fillOval((Game.FRAME_WIDTH-100)/2, (Game.FRAME_HEIGHT-60)/2+60, 100, 60);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawOval((Game.FRAME_WIDTH-100)/2, (Game.FRAME_HEIGHT-60)/2+60, 100, 60);
		g2d.setColor(Color.WHITE);
		g2d.fillOval((Game.FRAME_WIDTH-100)/2+15, (Game.FRAME_HEIGHT-60)/2+60+20, 50, 20);

	}

	public void dieMode(Graphics2D g2d) {
		int thick = 10;
		// Head
		g2d.setColor(new Color(139, 69, 19)); // Brown Color
		g2d.fillOval((Game.FRAME_WIDTH-bigmoleSize)/2, (Game.FRAME_HEIGHT-bigmoleSize)/2, bigmoleSize, bigmoleSize);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawOval((Game.FRAME_WIDTH-bigmoleSize)/2, (Game.FRAME_HEIGHT-bigmoleSize)/2, bigmoleSize, bigmoleSize);
		// X Eye
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(30));
		g2d.drawLine((Game.FRAME_WIDTH-350)/2, (Game.FRAME_HEIGHT-100)/2-25, (Game.FRAME_WIDTH+350)/2, (Game.FRAME_HEIGHT+100)/2-25);
		g2d.drawLine((Game.FRAME_WIDTH-350)/2, (Game.FRAME_HEIGHT+100)/2-25, (Game.FRAME_WIDTH+350)/2, (Game.FRAME_HEIGHT-100)/2-25);
		// Nose
		g2d.setColor(new Color(255, 102, 102)); // Pink Color
		g2d.fillOval((Game.FRAME_WIDTH-100)/2, (Game.FRAME_HEIGHT-60)/2+60, 100, 60);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawOval((Game.FRAME_WIDTH-100)/2, (Game.FRAME_HEIGHT-60)/2+60, 100, 60);
		g2d.setColor(Color.WHITE);
		g2d.fillOval((Game.FRAME_WIDTH-100)/2+15, (Game.FRAME_HEIGHT-60)/2+60+20, 50, 20);

	}

	public int scoreUp() {
		return 50;
	}

	public void keyPressed(int k) {

		if(k == keyCode) { 
			dead = true; 
		}
	}

	public int keyReleased(int k) {

		if(k == keyCode) { 
			dead = false; 
			return scoreUp(); 
		}	
		return 0;
	}

}