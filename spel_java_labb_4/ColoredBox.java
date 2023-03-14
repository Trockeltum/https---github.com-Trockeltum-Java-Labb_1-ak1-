import java.awt.Color;
import java.awt.Graphics2D;
import java.lang.Math;

public class ColoredBox extends Sprite {
    private Color color;
    public int hp;
    public int dead;
    
    @Override
    public void update(Keyboard keyboard){
        
    };

    @Override
    public void draw(Graphics2D graphics){
        if(hp > 3){
            graphics.setColor(Color.green);
            graphics.fillRect(getX(), getY(), getWidth(),getHeight());
        }
        else if(hp > 2){
            graphics.setColor(Color.blue);
            graphics.fillRect(getX(), getY(), getWidth(),getHeight());
        }
        else if(hp > 1){
            graphics.setColor(Color.red);
            graphics.fillRect(getX(), getY(), getWidth(),getHeight());
        }
    }

    public ColoredBox(int x, int y, int width, int height, Color color) {
        super(x, y, width, height);
        this.hp = (int)(Math.random() * (4-2+1)) + 2;
        this.dead = 1;
        this.color = color;
    };

}