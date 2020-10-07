package br.com.snake.graphics;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import br.com.snake.scene.Snake;
import br.com.snake.util.Constants;
import br.com.snake.util.GameUtils;

public class KillSnake extends Rect{
	
	public KillSnake(KillSnake killSnake,Food food, Snake snake, Rectangle drawingArea) {
		setColor(Constants.KILL_COLOR);
		setDimension(new Dimension(Constants.KILL_SIZE,Constants.KILL_SIZE));
		setRandomLocation(killSnake, food, snake, drawingArea);
	}
	
	public void setRandomLocation(KillSnake killSnake, Food food,Snake snake, Rectangle drawingArea) {
		int offset = 5;

		do {
			int minX = (int) drawingArea.getMinX() + offset;
			int minY = (int) drawingArea.getMinY() + offset;
			
			int maxX = (int) drawingArea.getMaxX() - Constants.KILL_SIZE - offset;
			int maxY = (int) drawingArea.getMaxY() - Constants.KILL_SIZE - offset;
			
			int randomX = GameUtils.random(minX, maxX);
			int randomY = GameUtils.random(minY, maxY);
			setLocation(new Point(randomX, randomY));
		
		} while (snake.intersects(food) );
	}
	
	public void checkTimeKillSnake(KillSnake killSnake, Food food, Snake snake, Rectangle drawingArea) {
		int getFood = 0;
		int meta = 3;
		getFood = food.getEatenTimes();
		if(getFood == meta) {
			setRandomLocation(killSnake, food, snake, drawingArea);
			meta += 3;
			getFood = 0;
			return;
		}
	}
}
