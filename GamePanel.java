import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	private Timer loop;
	private GameStateManager gsm;

	public GamePanel() {
		
		loop = new Timer(1000/Game.FPS, this);
		loop.start();

		gsm = new GameStateManager();
		init();

		addKeyListener(this);

		setFocusable(true);
		requestFocus();
	}

	// Game Loop
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		update();
		draw(g2d);
		
	}
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	public void init() {
		gsm.init();
	}

	public void update() {
		gsm.update();
	}

	public void draw(Graphics2D g2d) {
		gsm.draw(g2d);
	}

	// KeyListener
	public void keyPressed(KeyEvent k) {
		int key = k.getKeyCode();
		gsm.keyPressed(key);
	}

	public void keyReleased(KeyEvent k) {
		int key = k.getKeyCode();
		gsm.keyReleased(key);
	}

	public void keyTyped(KeyEvent k) {}
}