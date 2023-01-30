import java.awt.Color;
import java.awt.Graphics2D;

public class Spelare extends Sprite{
    private Color color;
    public Spelare(int x, int y, int height, int width){
        super(x, y, width, height);
    }
    
    @Override
    public void draw(Graphics2D graphics){
        graphics.setColor(Color.cyan);
        graphics.drawRect(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void update(Keyboard keyboard){
        if(getX()>0){
            if(keyboard.isKeyDown(Key.Left)){
                setX(getX()-5);
            }
        }
        if(getX()<766){
            if(keyboard.isKeyDown(Key.Right)){
                setX(getX()+5);
            }
        }
    }
}