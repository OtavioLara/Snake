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
    private List<Image> imageBody;
    private Color color;
    private int size;
    private int dir;

    public final static int LEFT = 1;
    public final static int RIGHT = 2;
    public final static int UP = 3;
    public final static int DOWN = 4;

    public Snake(List<Point> body, Color color, int x, int y) {
        super(x, y);
        this.size = 1;
        this.body = body;
        this.color = color;
    }

    public Snake(int x, int y, int size) {
        super(x, y, Color.black);
        this.size = size;
        this.color = new Color(0, 0, 0);
        creatSnake();
        creatImage();
    }

    public void creatSnake() {
        this.body = new ArrayList<>();
        this.body.add(new Point(getX(), getY()));
        for (int i = 1; i < size; i++) {
            this.body.add(new Point(getX() - (i * SIZERECT), getY()));
        }
    }

    @Override
    public void act() {
        switch (dir) {
            case LEFT:
                super.move(-SIZERECT, 0);
                break;
            case RIGHT:
                super.move(SIZERECT, 0);
                break;
            case UP:
                super.move(0, -SIZERECT);
                break;
            default:
                super.move(0, SIZERECT);
                break;
        }
        moveBody();
    }

    public void moveBody() {
        this.body.remove(this.body.get(size-1));
        this.body.add(0, new Point(getX(), getY()));
    }

    public void setDirection(int dir) {
        if (dir == UP && this.dir == DOWN) {

        } else if (dir == DOWN && this.dir == UP) {

        } else if (dir == RIGHT && this.dir == LEFT) {

        } else if (dir == LEFT && this.dir == RIGHT) {

        } else {
            this.dir = dir;
        }
    }
    public List<Point> getBody(){
        return this.body;
    }
    @Override
    public void creatImage() {
        setImage(new BufferedImage(SIZERECT, SIZERECT, BufferedImage.TYPE_4BYTE_ABGR_PRE));
        Graphics2D g = (Graphics2D) getImage().getGraphics();
        g.setColor(getColor());
        g.fillRect(0, 0, SIZERECT, SIZERECT);
        g.dispose();
    }
}
