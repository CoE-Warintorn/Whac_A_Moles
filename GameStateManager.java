import java.util.ArrayList;
import java.awt.event.KeyEvent;

public class GameStateManager {

	private ArrayList<GameState> gameStates;
	private int currentState;
	private int score;
	public static final int MENUSTATE = 0;
	public static final int LEVEL1STATE = 1;
	public static final int LEVEL2STATE = 2;

	public GameStateManager() {
		gameStates = new ArrayList<GameState>();

		currentState = MENUSTATE;
		gameStates.add(new MenuState(this));
		gameStates.add(new Level1State(this));
		gameStates.add(new Level2State(this));


	}

	public void setState(int state) {
		currentState = state;
		init();
	}

	public void init() {
		gameStates.get(currentState).init();
	}

	public void resetScore() {
		score = 0;
	}

	public int getScore() {
		return score;
	}

	public void update() {
		score = gameStates.get(currentState).updateScore();
	}

	public void draw(java.awt.Graphics2D g2d) {
		gameStates.get(currentState).draw(g2d);
	}

	public void keyPressed(int k) {
		gameStates.get(currentState).keyPressed(k);
	}

	public void keyReleased(int k) {
		gameStates.get(currentState).keyReleased(k);
	}

}