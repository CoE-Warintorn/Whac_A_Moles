import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;

public class MoleUpper extends SmallMole {

	// Mole Width = 150
	// Mole Height Head = 120
	// Mole Height Body = 200
	// Mole Tall = 200 + 120/2 = 260
	private boolean upORdown;
	private boolean showORnot;	

	public MoleUpper(int x, int y, int keyCode){
		super(x, y, keyCode);
		speedMove = randomSpeed();
		upORdown = false;
		showORnot = randomShow();
	}

	public void liveMode(Graphics2D g2d) {

		int thick = 5;
		speedMove = randomSpeed();
		// Head
		g2d.setColor(new Color(139, 69, 19)); // Brown Color
		g2d.fillOval(x, y+200-60, 150, 120);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawArc(x, y+200-60, 150, 120, 180-10, 180+20);
		// Body
		g2d.setColor(new Color(139, 69, 19)); // Brown Color
		g2d.fillRect(x, y, 150, 200);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawLine(x, y, x, y+200);
		g2d.drawLine(x+150, y, x+150, y+200);
		g2d.drawLine(x, y, x+150, y);
		// Black Eye
		g2d.setColor(Color.BLACK);
		g2d.fillOval(x+50-20-5+10, y+260-40-50, 40-20, 60-10);
		g2d.fillOval(x+100-20+5+10, y+260-40-50, 40-20, 60-10);
		// White Eye
		g2d.setColor(Color.WHITE);
		g2d.fillOval(x+50-20-5+5+5, y+260-45-30, 15-5, 25+5);
		g2d.fillOval(x+100-20+5+5+5, y+260-45-30, 15-5, 25+5);
		// Nose
		g2d.setColor(new Color(255, 102, 102)); // Pink Color # Nose
		g2d.fillOval(x+50, y+260-100-30, 50, 30);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawOval(x+50, y+260-100-30, 50, 30);
		g2d.setColor(Color.WHITE);
		g2d.fillOval(x+55, y+260-105-10, 20, 10);
		// live
		move(speedMove);

	}

	public void dieMode(Graphics2D g2d) {
		int thick = 5;
		// Body
		g2d.setColor(new Color(139, 69, 19)); // Brown Color
		g2d.fillRect(x, y, 150, 150);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawRect(x, y, 150, 150);
		// Head
		g2d.setColor(new Color(139, 69, 19)); // Brown Color
		g2d.fillOval(x-125+75, y+260-100-100, 250, 100);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(thick));
		g2d.drawOval(x-125+75, y+260-100-100, 250, 100);
		g2d.drawArc(x+75-60,y+260-110-40,120,40,0,180);


	}

	private void move(int speed) {

		if(y<-300+(Level1State.hPipeheight+Level1State.vPipeheight+Level1State.cabPipeheight)) {
			upORdown = false;
			speedMove = randomSpeed();
			showORnot = randomShow();
		}
		else if(y>(Level1State.hPipeheight+Level1State.vPipeheight+Level1State.cabPipeheight)/2){
			upORdown = true;
			speedMove = randomSpeed();
		}

		if( showORnot ) {
			if(upORdown && !isDead()) {
				y-=speed;
			}
			else if(!upORdown && !isDead()) {
				y+=speed;
			}
		}
		else {
			showORnot = randomShow();
		}
		
	}

	public boolean beatable() {
		if( y>(Level1State.hPipeheight+Level1State.vPipeheight+Level1State.cabPipeheight)/2-40 )
			return true;
		else
			return false;
	}

}