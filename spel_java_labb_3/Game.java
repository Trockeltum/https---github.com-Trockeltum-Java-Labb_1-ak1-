import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;

public class Game {
	int antal = 40*4;

	Boxes box = new Boxes(antal);

	Spelare spelare = new Spelare(400, 575, 5, 30);
	Boll boll = new Boll(200, 200, 20, 20);

	public Game(GameBoard board) {

	}

	public void update(Keyboard keyboard) {
		this.spelare.update(keyboard);
		this.boll.update(keyboard);
	}

	public void draw(Graphics2D graphics) {
		for(int i=0;i<antal; i++){
			this.box.get_square(i).draw(graphics);
		}
		this.spelare.draw(graphics);
		this.boll.draw(graphics);
	}
}
