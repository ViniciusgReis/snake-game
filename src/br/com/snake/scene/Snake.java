package br.com.snake.scene;

import java.awt.Dimension;
import java.awt.Point;

import br.com.snake.core.Direction;
import br.com.snake.graphics.Rect;
import br.com.snake.graphics.Shape;
import br.com.snake.util.Constants;
import br.com.snake.util.GameUtils;

public class Snake extends Shape{
	
	private Direction direction;
	private int piecesToElongate;
	
	public Snake() {
		super(Constants.SNAKE_COLOR);
		direction = Direction.NONE;
		
		Point location = new Point(Constants.SNAKE_START_X,Constants.SNAKE_START_Y);
		Dimension dimension = new Dimension(Constants.SNAKE_PIECE_SIZE,Constants.SNAKE_PIECE_SIZE);
		Rect rect = new Rect(location,dimension);
		addRect(rect);
		
		for (int i = 1; i < Constants.SNAKE_INITIAL_SIZE; i++) {
			rect = duplicateRect(rect,Direction.LEFT);
			addRect(rect);
		}
	}
	
	public void move() {
		if(direction != Direction.NONE) {
			Rect head = getFirstRect();
			//Rect tail = getLastRect();
			
			GameUtils.moveRect(getRects());
			
			Rect newHead = duplicateRect(head, direction);
			getRects().set(0, newHead);
		}
	}
	
	public void elongate() {
		piecesToElongate = Constants.SNAKE_ELONGATE_PIECES;
	}
	
	public synchronized void left() {
		if (direction.canChangeTo(Direction.LEFT)) {
			direction = Direction.LEFT;
		}
	}
	
	public synchronized void right() {
		if (direction.canChangeTo(Direction.RIGHT)) {
			direction = Direction.RIGHT;
		}
	}
	
	public synchronized void up() {
		if (direction.canChangeTo(Direction.UP)) {
			direction = Direction.UP;
		}
	}
	
	public synchronized void down() {
		if (direction.canChangeTo(Direction.DOWN)) {
			direction = Direction.DOWN;
		}
	}
	
	public boolean collideSwithItSelf() {
		Rect head = getFirstRect();
		for (int i = 1; i < getRects().size(); i++) {
			if (head.intersects(getRects().get(i))){
				return true;
			}
		}
		return false;
	}
}
