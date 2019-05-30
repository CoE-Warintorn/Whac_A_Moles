import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;

public class MoleLower extends SmallMole {

	// Mole Width = 150
	// Mole Height Head = 120
	// Mole Height Body = 200
	// Mole Tall = 200 + 120/2 = 260
	private boolean upORdown;
	private boolean showORnot;	

	public MoleLower(int x, int y, int keyCode){
		super(x, y, keyCode);
		speedMove = randomSpeed();
		upORdown = true;
		showORnot = randomShow();
	}

	public void liveMode(Graphics2D g2d) {

		int thick = 5;
		// Head
		g2d.setColor(new Color(139, 69, 19)); // Brown Color
		g2d.fillOval(x, y, 150, 120);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawArc(x, y, 150, 120, 0, 180);
		// Body
		g2d.setColor(new Color(139, 69, 19)); // Brown Color
		g2d.fillRect(x, y+60, 150, 200);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawLine(x, y+60, x, y+260);
		g2d.drawLine(x+150, y+60, x+150, y+260);
		g2d.drawLine(x, y+260, x+150, y+260);
		// Black Eye
		g2d.setColor(Color.BLACK);
		g2d.fillOval(x+50-20-5+10, y+40, 40-20, 60-10);
		g2d.fillOval(x+100-20+5+10, y+40, 40-20, 60-10);
		// White Eye
		g2d.setColor(Color.WHITE);
		g2d.fillOval(x+50-20-5+5+5, y+45, 15-5, 25+5);
		g2d.fillOval(x+100-20+5+5+5, y+45, 15-5, 25+5);
		// Nose
		g2d.setColor(new Color(255, 102, 102)); // Pink Color
		g2d.fillOval(x+50, y+100, 50, 30);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawOval(x+50, y+100, 50, 30);
		g2d.setColor(Color.WHITE);
		g2d.fillOval(x+55, y+105, 20, 10);
		// live
		move(speedMove);

	}

	public void dieMode(Graphics2D g2d) {
		int thick = 5;
		// Body
		g2d.setColor(new Color(139, 69, 19)); // Brown Color
		g2d.fillRect(x, y+60+50, 150, 150);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawRect(x, y+60+50, 150, 150);
		// Head
		g2d.setColor(new Color(139, 69, 19)); // Brown Color
		g2d.fillOval(x-125+75, y+100, 250, 100);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawOval(x-125+75, y+100, 250, 100);
		g2d.drawArc(x+75-60,y+110,120,40,180,180);

	}

	private void move(int speed) {

		if(y<Game.FRAME_HEIGHT-300-(Level1State.hPipeheight+Level1State.vPipeheight+Level1State.cabPipeheight)/2) {
			upORdown = true;
			speedMove = randomSpeed();
		}
		else if(y>Game.FRAME_HEIGHT-(Level1State.hPipeheight+Level1State.vPipeheight+Level1State.cabPipeheight)){
			upORdown = false;
			speedMove = randomSpeed();
			showORnot = randomShow();
		}

		if( showORnot ) {
			if(upORdown && !isDead()) {
				y+=speed;
			}
			else if(!upORdown && !isDead()) {
				y-=speed;
			}
		}
		else {
			showORnot = randomShow();
		}
		
	}

	public boolean beatable() {
		if( y<Game.FRAME_HEIGHT-300-(Level1State.hPipeheight+Level1State.vPipeheight+Level1State.cabPipeheight)/2+40 )
			return true;
		else
			return false;
	}
	
}