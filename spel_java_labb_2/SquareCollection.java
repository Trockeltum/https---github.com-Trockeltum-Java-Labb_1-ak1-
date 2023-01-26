import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics2D;

public class SquareCollection {
    private ArrayList<CyanBox> lador = new ArrayList<CyanBox>();

    public SquareCollection(){
        for(int i=0;i<20;i++){
            CyanBox cyanbox = new CyanBox(i*40+10,20,20,20);
            this.lador.add(cyanbox);
            
        }
    }
    public CyanBox get_square(int i){
        return this.lador.get(i);
    }
    
    public void draw(Graphics2D graphics){
        for(int i=0; i<20;i++){
            graphics.setColor(Color.cyan);
            graphics.drawRect(get_square(i).getX(), get_square(i).getY(), get_square(i).getWidth(), get_square(i).getHeight());
        }

    }
}
