import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics2D;

public class Boxes{
    private ArrayList<CyanBox> lador = new ArrayList<CyanBox>();
    
    public Boxes(int antal){
        int j =0;
        int ii = 0;
        for(int i=0;i<antal;i++){
            if(i!=0 && i%10==0){
                j += 1;
                ii=0;
            }
            CyanBox cyanbox = new CyanBox(ii*20*4,20*j*4,19*4,19*4);
            this.lador.add(cyanbox);
            ii++;
            
        }
    }
    public void draw(Graphics2D Graphics){
        for(int i=0; i<len_squares();i++){
            get_square(i).draw(Graphics);
        }
    }
    public int Total_hp(){
        int Total_hp = 0;
        for(int i=0; i<len_squares();i++){
            Total_hp += get_square(i).hp;
        }
        return Total_hp;
    }
    public int alive(){
        for(int i=0;i<len_squares();i++){
            get_square(i).dead = 1;
        }
        return 0;
    }

    public CyanBox get_square(int i){
        return this.lador.get(i);
    }

    public int len_squares(){
        return this.lador.size();
    }
}
