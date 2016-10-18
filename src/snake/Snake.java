package snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Snake extends Actor {

    private List<Point> body;
    private Color color;
    private int startSize;
    private int dir;

    public final static int LEFT = 1;
    public final static int RIGHT = 2;
    public final static int UP = 3;
    public final static int DOWN = 4;

    public Snake(List<Point> body, Color color, int x, int y) {
        super(x, y);
        this.body = body;
        this.color = color;

    }

    public Snake(int x, int y) {
        super(x, y,Color.black);
        this.body = new ArrayList<>();
        this.body.add(new Point(getX(), getY()));
        this.color = new Color(0, 0, 0);
        
        setImage(new BufferedImage(25, 25, BufferedImage.TYPE_4BYTE_ABGR_PRE));
        Graphics2D g = (Graphics2D) getImage().getGraphics();
        g.setColor(getColor());
        g.fillRect(0, 0, 25, 25);
        g.dispose();
    }

    @Override
    public void act() {
        switch (dir) {
            case LEFT:
                super.move(-1, 0);
                break;
            case RIGHT:
                super.move(1, 0);
                break;
            case UP:
                super.move(0, -1);
                break;
            default:
                super.move(0, 1);
                break;
        }
    }

    public void setDirection(int dir) {
        this.dir = dir;
    }
}
