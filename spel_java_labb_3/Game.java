import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;
import java.util.concurrent.*;
import java.awt.*;
import java.io.*;
import java.lang.*;

public class Game {
	int nagot = 0;
	int nagot_1 = 0;
	int antal = 10*2;
	Boxes box = new Boxes(antal);
	int temp = box.Total_hp();

	Spelare spelare = new Spelare(400, 575, 5, 120);
	Boll boll = new Boll(200, 200, 20, 20);


	public Game(GameBoard board) {
	
	}

	public void update(Keyboard keyboard) {
		this.spelare.update(keyboard);
		this.boll.update(keyboard);
		DetectCollision DetectCollision = new DetectCollision(boll,spelare,box);
		if(boll.getY()>620){
            boll.spelar_hp -= 1;
			boll.setX(200);
			boll.setY(200);
        }
	}

	public void draw(Graphics2D graphics) {
		graphics.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		for(int i=0;i<antal; i++){
				this.box.get_square(i).draw(graphics);
		}
		this.spelare.draw(graphics);
		this.boll.draw(graphics);
		if (boll.spelar_hp > 0){
			graphics.drawString("HP left: "+" "+( boll.spelar_hp-1), 10, 570);
		}
		else{
			graphics.drawString("HP left: "+" "+"DÖD", 10, 570);
		}

		graphics.drawString("Du har Totalt"+" "+( spelare.score)+" Poäng", 10, 550);
		//graphics.drawString("Grattis Du Fick Totalt"+( spelare.score)+" Poäng", 400, 300);
		
		if((box.Total_hp()-antal)<= 0){
			graphics.drawString("Grattis Du Fick Totalt"+" "+( spelare.score)+" Poäng", 20, 300);
			nagot += 1;
		}
		
		if (boll.spelar_hp < 1){
			graphics.drawString("Du Dog Men Du Fick Totalt"+" "+( spelare.score)+" Poäng", 20, 300);
			//System.out.println(nagot);
			nagot += 1;
		}

		if(nagot > 2){
			
			TimeUnit time = TimeUnit.SECONDS;
			try {
				time.sleep(10);
			} 
			catch (InterruptedException e) {
				System.out.println("InterruptedExceptionJava");
			}
			System.exit(0);
		}
	}
}
