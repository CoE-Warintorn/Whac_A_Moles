import javax.swing.JFrame;

public class Game {

	public static final String GAME_NAME = "Whac A Mole";
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 650;
	public static final int FPS = 120;

	private JFrame frame;

	public Game() {

		frame = new JFrame();

		frame.setTitle(GAME_NAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(FRAME_WIDTH ,FRAME_HEIGHT);
		frame.setResizable(false);

		frame.setContentPane(new GamePanel());

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	public static void main(String args[]) {

		new Game();

	}

}