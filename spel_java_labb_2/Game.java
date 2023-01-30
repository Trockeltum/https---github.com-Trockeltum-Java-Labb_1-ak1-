import java.awt.Graphics2D;
import java.io.*;
import java.util.*;


public class Game {
	private int tickcount = 0;
	BlueBox blueBox = new BlueBox(20,20,20,20);
	RedBox redBox = new RedBox(60,60, 20, 20);
	Spelare spelare = new Spelare(80,80,20,20);
	SquareCollection squares = new SquareCollection();
	public Game(GameBoard board) {
		
	}

	public void update(Keyboard keyboard) {
		int blue_y = this.blueBox.getY();
		this.blueBox.setY(blue_y+1);
		if (keyboard.isKeyDown(Key.Down)){
			this.spelare.setY(this.spelare.getY()+5);
		}
		if(keyboard.isKeyDown(Key.Up)){
			this.spelare.setY(this.spelare.getY()-5);
		}
		if(keyboard.isKeyDown(Key.Left)){
			this.spelare.setX(this.spelare.getX()-5);
		}
		if(keyboard.isKeyDown(Key.Right)){
			this.spelare.setX(this.spelare.getX()+5);
		}

		
		if(tickcount%40 == 0){
			for (int i = 0; i<20; i++){
				CyanBox temp = squares.get_square(i);
				temp.setY(temp.getY()+10);
			}
		}
		if (squares.get_square(0).getY() >= 600){
			System.exit(0);
		}
		tickcount ++;
	}

	public void draw(Graphics2D graphics) {
		for(int i=0;i<20; i++){
			this.squares.get_square(i).draw(graphics);
		}
		this.spelare.draw(graphics);
		//this.blueBox.draw(graphics);
		//this.redBox.draw(graphics);
		
	}
	
}
