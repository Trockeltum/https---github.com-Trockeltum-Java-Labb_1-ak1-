import javax.swing.*;
import java.awt.*;

public class HIGHSCORE extends JFrame {
    private JPanel panel;
    public HIGHSCORE(){
        setTitle("Score: "); // Sätter en titel
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Vad den ska göra när man trycker på krysset uppe i höger
        setSize(1,400); // Storlek 
        setLocationRelativeTo(null); // Gör det möjligt att ändra storlek
        setResizable(true); // ändrar storlek
        int antal_inputs = 10;
        
        JPanel panel = new JPanel(new GridLayout(10,10,30,10));
        panel.setBackground(Color.BLACK);

        JPanel panel_2 = new JPanel(new GridLayout(1,1,10,10));
        panel_2.setBackground(Color.BLACK);
        
        JLabel label_1 = new JLabel("HIGHSCORE");
        label_1.setForeground(Color.yellow);
        panel_2.add(label_1);

        JPanel panel_1 = new JPanel(new GridLayout(10,10,10,10));
        panel_1.setBackground(Color.BLACK);

        JPanel panel_3 = new JPanel(new GridLayout(10,10,10,10));
        panel_3.setBackground(Color.BLACK);

        for(int i=1;i<=antal_inputs;i++){
            JLabel label = new JLabel(Integer.toString(i)+". ");
            label.setForeground(Color.yellow);
            label.setBackground(Color.BLACK);
            label.setSize(20, 20);
            label.setBounds(50,50, 10,20);

            JTextField textField = new JTextField("TESTAR "+ Integer.toString(i));
            textField.setBackground(Color.BLACK);
            textField.setSelectedTextColor(Color.YELLOW);;
            textField.setForeground(Color.YELLOW);

            JLabel label_3 = new JLabel(Integer.toString(i*100+i*10+i));
            label_3.setForeground(Color.yellow);

            if(i == antal_inputs){
                textField.setFocusable(true);
                textField.setText(" ");

            }
            else{
                textField.setFocusable(false);
                textField.setBorder(null);
            }
            panel_3.add(label_3);
            panel.add(textField);
            panel_1.add(label);
        }
        add(panel_3,BorderLayout.EAST);
        add(panel_2,BorderLayout.NORTH);
        add(panel_1,BorderLayout.WEST);
        add(panel,BorderLayout.CENTER);
        setVisible(true); // Gör den synlig
    }

}
