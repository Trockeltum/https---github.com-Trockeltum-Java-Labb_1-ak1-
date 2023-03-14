import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;
import java.util.concurrent.*;
import java.awt.*;
import java.io.*;
import java.lang.*;
import java.nio.*;
import java.util.List;

public class Game{
	int nagot = 0;
	int nagot_1 = 0;
	int antal = 1;
	Boxes box = new Boxes(antal);
	int temp = box.Total_hp();
	Program program;
	GameBoard board;
	public int done = 0;
	Spelare spelare = new Spelare(400, 575, 5, 120,program);
	Boll boll = new Boll(200, 200, 20, 20);
	
	public Game(GameBoard board,Program program) {	
		this.program = program;
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
		program.latestrun.visual_list();
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
			nagot += 1;
			
		}

		if(nagot > 2){
			if (nagot == 3){
				program.latestrun.Scoring(spelare.score);
				program.latestrun.skriv(spelare.score);
				//Files file_manegment = new Files(spelare.score);

				List<Integer> highscores = new ArrayList<Integer>(Arrays.asList(1,2,3,4,9,8,7,6,5,4));
				Collections.sort(highscores,Collections.reverseOrder());
				if(highscores.get(highscores.size()-1) < spelare.score || highscores.size() <10){
					highscores.add(spelare.score); 
				}
				Collections.sort(highscores,Collections.reverseOrder());
				//System.out.println(highscores);
				
				List<Integer> Last_score = new ArrayList<Integer>(Arrays.asList(1,2,3));
				if(Last_score.size()>2){
					Last_score.remove(2);
				}
				Last_score.add(0, spelare.score);
				//System.out.println(Last_score);
				nagot++;
			}
			//int highscore[];
			
			
			//for(int i=0;i<10;i++){
			//	if(spelare.score>temp_lista[i]){
			//		temp_lista[i] = spelare.score;
			//		for(int ii=i;ii<10-i-1;ii++){
			//			temp_lista[ii-1] = highscore[ii];
			//		}
			//	} 
			//}
			//highscore = temp_lista;
			
			//int temp_lista_1[] = latest_run;
			//temp_lista_1[i] = spelare.score;
			//for(int i=1;i<3;i++){
			//	temp_lista[i] = latest_run[i-1];
			//}
			//latest_run = temp_lista_1;

			boll.speed_X = 0;
			boll.speed_Y = 0;
			//TimeUnit time = TimeUnit.SECONDS;
			//try {
			//	time.sleep(10);
			//} 
			//catch (InterruptedException e) {
			//	System.out.println("InterruptedExceptionJava");
			//}
			//System.exit(0);
		}
	}
}
