import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics2D;

public class Boxes{
    private ArrayList<CyanBox> lador = new ArrayList<CyanBox>();
    
    public Boxes(int antal){
        int j =0;
        int ii = 0;
        for(int i=0;i<antal;i++){
            if(i!=0 && i%40==0){
                j += 1;
                ii=0;
            }
            CyanBox cyanbox = new CyanBox(ii*20,20*j,19,19);
            this.lador.add(cyanbox);
            ii++;
            
        }
    }
    public CyanBox get_square(int i){
        return this.lador.get(i);
    }
    
    public void draw(Graphics2D graphics,int antal){
        for(int i=0; i<antal;i++){
            graphics.setColor(Color.cyan);
            graphics.drawRect(get_square(i).getX(), get_square(i).getY(), get_square(i).getWidth(), get_square(i).getHeight());
        }

    }
}
