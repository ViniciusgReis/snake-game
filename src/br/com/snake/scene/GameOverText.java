package br.com.snake.scene;

import br.com.snake.graphics.Text;
import br.com.snake.util.Constants;

public class GameOverText extends Text{

	public GameOverText(int score) {
		super(Constants.GAME_OVER_COLOR, String.format(Constants.GAME_OVER_TEXT, score), Constants.GAME_OVER_LOCATION);
	}
}
