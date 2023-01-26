import java.awt.Graphics2D;
import java.io.*;
import java.util.*;


public class Game {
	private int tickcount = 0;
	BlueBox blueBox = new BlueBox(20,20,20,20);
	RedBox redBox = new RedBox(60,60, 20, 20);
	Spelare spelare = new Spelare(80,80,20,20);
	public Game(GameBoard board) {
		
	}

	public void update(Keyboard keyboard) {
		int blue_y = this.blueBox.getY();
		this.blueBox.setY(blue_y+1);
		if (keyboard.isKeyDown(null)){

		}
		else{
			if (keyboard.isKeyDown(Key.Down)){
				int temp_spelare_y = this.spelare.getY();
				this.spelare.setY(temp_spelare_y+1);
			}
			if (keyboard.isKeyDown(Key.Up)){
				int temp_spelare_y_up = this.spelare.getY();
				this.spelare.setY(temp_spelare_y_up-1);
			}
			if (keyboard.isKeyDown(Key.Left)){
				int temp_spelare_y_left = this.spelare.getX();
				this.spelare.setX(temp_spelare_y_left-1);
			}
			if (keyboard.isKeyDown(Key.Right)){
				int temp_spelare_y_Right = this.spelare.getX();
				this.spelare.setX(temp_spelare_y_Right+1);
			}
		}
		
		if(tickcount%40 == 0){
			for (int i = 0; i<20; i++){
				CyanBox temp = square_collection.get_square(i);
				temp.setY(temp.getY()+10);
			}
		}
		if (square_collection.get_square(0).getY() >= 600){
			System.exit(0);
		}
		tickcount ++;
	}

	public void draw(Graphics2D graphics) {
		this.spelare.draw(graphics);
		this.blueBox.draw(graphics);
		this.redBox.draw(graphics);
		
	}
	
}
