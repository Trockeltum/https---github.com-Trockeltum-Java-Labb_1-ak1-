import java.awt.Color;
import java.awt.Graphics2D;

public class ColoredBox extends Sprite {
    private Color color;

    @Override
    public void update(Keyboard keyboard){
        
    };

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(this.color);
		graphics.fillRect(this.getX(),this.getY(),this.getWidth(),this.getHeight());
    };

    public ColoredBox(int x, int y, int width, int height, Color color) {
        super(x, y, width, height);
        this.color = color;
        
    };

}
    
    