import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class Program extends JFrame {
	GameBoard board;
	private JPanel panel;
	GridLayout layout = new GridLayout(1,2);
	private int hej = 1; 
	Latest_runs latestrun;
	public Program() {
		setLayout(layout);	

		board = new GameBoard(this);
		add(board,0);
		if (hej == 1){
			System.out.println("hej");
			latestrun =  new Latest_runs(board);
			System.out.println("hej");
			add(latestrun,1);
			hej= 2;
		}

		setResizable(true);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
		board.start();
	}
	
	@Override
	protected void processKeyEvent(KeyEvent e) {
		super.processKeyEvent(e);
		board.processKeyEvent(e);
	}

	public static void main(String[] args) {
		//final_score finalscore = new final_score();
		Program program = new Program();
	}


}
