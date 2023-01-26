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
        graphics.drawOval(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void update(Keyboard keyboard){
    }
}