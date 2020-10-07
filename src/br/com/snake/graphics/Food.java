package br.com.snake.graphics;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import br.com.snake.scene.Snake;
import br.com.snake.util.Constants;
import br.com.snake.util.GameUtils;

public class Food extends Rect{
	private int eatenTimes;
	
	public Food(KillSnake killSnake, Snake snake, Rectangle drawingArea) {
		setColor(Constants.FOOD_COLOR);
		setDimension(new Dimension(Constants.FOOD_SIZE,Constants.FOOD_SIZE));
		setRandomLocation(killSnake, snake, drawingArea);
	}
	
	public void setRandomLocation(KillSnake killSnake, Snake snake,Rectangle drawingArea) {
		int offset = 5;
		
		do {
			int minX = (int) drawingArea.getMinX() + offset;
			int minY = (int) drawingArea.getMinY() + offset;
	
			int maxX = (int)drawingArea.getMaxX() - Constants.FOOD_SIZE - offset;
			int maxY = (int)drawingArea.getMaxY() - Constants.FOOD_SIZE - offset;
			
			int randomX = GameUtils.random(minX, maxX);
			int randomY = GameUtils.random(minY, maxY);
			setLocation(new Point(randomX, randomY));
		} while (snake.intersects(this));
	}
	
	public void checkIfEaten(KillSnake killSnake, Snake snake, Rectangle drawingArea) {
		if (snake.intersects(this)) {
			eatenTimes++;
			setRandomLocation(killSnake, snake, drawingArea);
			snake.elongate();
		}
	}
	
	public int getEatenTimes() {
		return eatenTimes;
	}
}
