import java.awt.Color;
import java.awt.Graphics2D;
import java.lang.Math;

public class Boll extends ColoredBox{
    int speed_Y = 2*2;
    int speed_X = 2;
    int spelar_hp = 3;
    
    public Boll(int x, int y, int width, int height){
        super(x,y,width,height,Color.green);
    }
    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.lightGray);
		graphics.fillOval(this.getX(),this.getY(),this.getWidth(),this.getHeight());
    };

    //@Override
    public void update(Keyboard keyboard){
        this.setY(getY()+speed_Y);
        this.setX(getX()+speed_X);
    }

}