import java.awt.Color;
import java.awt.Graphics2D;
import java.lang.Math;

public class Boll extends ColoredBox{
    public Boll(int x, int y, int width, int height){
        super(x,y,width,height,Color.green);
    }
    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.lightGray);
		graphics.fillOval(this.getX(),this.getY(),this.getWidth(),this.getHeight());
    };

    @Override
    public void update(Keyboard keyboard){
        if(this.getY()>620){
            System.out.println("Score: ");
            System.exit(0);
        }
        //if (DetectCollision()==true){
        //    bounce(DetectCollision());
            //Score++;
            //begin=0;
        //}
        
        this.setY(getY()+1);
        this.setX(getX()+1);
    }
}