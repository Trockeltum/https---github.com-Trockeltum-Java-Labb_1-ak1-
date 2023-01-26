import java.util.ArrayList;

public class square_collection {
    private ArrayList<CyanBox> lador = new ArrayList<CyanBox>();

    public square_collection(){
        for(int i=0;i<20;i++){
            CyanBox cyanbox = new CyanBox(i*40+10,20,20,20);
            this.lador.add(cyanbox);
            
        }
    }
    public CyanBox get_square(int i){
        return this.lador.get(i);
    }
}
