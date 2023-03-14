import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;
import java.util.concurrent.*;
import java.awt.*;
import java.io.*;
import java.lang.*;
import java.nio.*;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import java.awt.event.*;  
import javax.swing.*;

public class Latest_runs extends JPanel{
    public int varden(int i){
        return Integer.valueOf(list_1.get(i));
    }
    List<String> list_1 = new ArrayList<>();
    int temp_2 = 1;
    int len_latest = 0;
    int len_high = 0;
    List<String> namn = new ArrayList<>();
    List<String> list = new ArrayList<>();
    DefaultListModel<String> l1 = new DefaultListModel<>();
	DefaultListModel<String> l2 = new DefaultListModel<>();
    GameBoard board;
    List<Integer> temp_lista_1 = new ArrayList<Integer>();

    public void visual_list(){ // Gör listorna som man ser
        if(list.size()>3){
            len_latest = 3;
        }else{
            len_latest = list.size()-1;
        }
        if(list_1.size()>10){
            len_high = 10;
        }else{
            len_high = list_1.size()-1;
        }
        l1.addElement("Highscore: ");
        l1.removeAllElements();
        l2.removeAllElements();
        for(int i=0;i<len_high;i++){
            l1.addElement(Integer.toString(i+1)+": "+namn.get(i)+" "+list_1.get(i));

        }
        l2.addElement("Latest runs: ");
        
        for(int i=0;i<len_latest;i++){
            l2.addElement(Integer.toString(i+1)+": "+list.get(i));
        }
    }

    public void read_from_file(){
        try {
            namn = Files.readAllLines(new File("namn.txt").toPath(), Charset.defaultCharset());
            System.out.println(list);
            list = Files.readAllLines(new File("latestrun.txt").toPath(), Charset.defaultCharset());   
            System.out.println("hej");
            System.out.println(list);
            list_1 = Files.readAllLines(new File("Highscore.txt").toPath(), Charset.defaultCharset()); 
            System.out.println(list_1);
        } catch (Exception e) {
            
        }
    }
    
    public void Scoring(int score){
            JTextField jTextField = new JTextField(3);
            jTextField.setDocument(new JTextFieldLimit(3));
            jTextField.setBackground(Color.BLACK);
            jTextField.setBorder(null);
            //setVisible(true);
            jTextField.setSelectionColor(Color.red);
            jTextField.setCaretColor(Color.CYAN);
            jTextField.setFocusable(true);
            jTextField.setForeground(Color.yellow);
            JButton jButton = new JButton("Submit");
            jButton.setBackground(Color.red);
            jButton.setFocusable(false);
            jButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String str  = jTextField.getText();
                    for(int i=0;i<11;i++){
                        if(score == varden(i) && temp_2 == 1){
                            namn.set(i,str);
                            temp_2++;
                        }
                    }
                }
            });
            try {
                FileWriter writer_2 = new FileWriter("namn.txt",false);
                for(int i=0;i<namn.size();i++){
                    writer_2.write((namn.get(i)+"\n"));
                }
                writer_2.close();	
            } catch (Exception e) {
                // TODO: handle exception
            }
            JPanel jPanel = new JPanel();
            jPanel.setBackground(Color.BLACK);
            jPanel.add(jTextField);
            jPanel.add(jButton);
            add(jPanel);

            JPanel jPanel3 = new JPanel();
            jPanel3.setBackground(Color.BLACK);
            add(jPanel3);
    }

    public void skriv(int score){
        if(1==1){ //Lägger till i lates_run listan
            Collections.reverse(list);
            list.add(Integer.toString(score));
            Collections.reverse(list);
            System.out.println("HEJ"+list);
        }
        
        System.out.println("LISTA: "+list_1);
        list_1.add(Integer.toString(score));
        for(int i=0;i<list_1.size();i++){
            temp_lista_1.add(Integer.valueOf(list_1.get(i)));
        }
        Collections.sort(temp_lista_1, Collections.reverseOrder());
        System.out.println("Första"+temp_lista_1);
        System.out.println("Andra"+list_1.size());
        
        for(int i=0;i<temp_lista_1.size();i++){
            list_1.set(i,Integer.toString(temp_lista_1.get(i)));
        }
        
        
        try {
            FileWriter writer_1 = new FileWriter("latestrun.txt",false);
            for(int i=0;i<list.size();i++){
                writer_1.write((list.get(i)+"\n"));
            }
            writer_1.close();	
        } catch (Exception e) {
            // TODO: handle exception
        }
        //namn.set(0,"");
        

        int hej = 1;
        try {
            FileWriter writer = new FileWriter("Highscore.txt",false);
            for(int i=0;i<list_1.size();i++){
                //if(hej == 1 && score > Integer.valueOf(list_1.get(i))){
                //    writer.write(str+": "+(list_1.get(i))+"\n");
                //   hej++;
                //}else{
                    writer.write((list_1.get(i))+"\n"); 
            //}
            }
            writer.close();	
        } catch (Exception e) {
        }
    }
    public Latest_runs(GameBoard board){
		//setTitle("Score: "); // Sätter en titel
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Vad den ska göra när man trycker på krysset uppe i höger
		//setSize(10,200); // Storlek 
		//setLocationRelativeTo(null); // Gör det möjligt att ändra storlek
		//setResizable(true); // ändrar storlek

		//JPanel panel = new JPanel(new GridLayout(2,1,30,10));
		//panel.setBackground(Color.BLACK);
        GridLayout layout = new GridLayout(2,2);
        setLayout(layout);

        read_from_file();

        int score = board.game.spelare.score;
		
        if(1==1){ //Kollar längden på listorna
            if(list.size()>3){
                len_latest = 3;
            }else{
                len_latest = list.size()-1;
            }
            if(list_1.size()>10){
                len_high = 10;
            }else{
                len_high = list_1.size()-1;
            } 
            System.out.println("HIGH "+len_high);
            System.out.println("LAST "+len_latest);
        }
        
        String str = "VAD";
        
        skriv(score);
        System.out.println("JAS");
        


		JList<String> List = new JList<String>(l1);
		List.setBackground(Color.BLACK);
		List.setForeground(Color.YELLOW);
		List.setFocusable(false);
		//panel.add(myList);
		add(List,0);

		JList<String> List_1 = new JList<String>(l2);
		List_1.setBackground(Color.BLACK);
		List_1.setForeground(Color.YELLOW);
		List_1.setFocusable(false);
		//panel.add(mylist_1);
		add(List_1,1);
    } //catch (Exception e) {
    //}
	}

