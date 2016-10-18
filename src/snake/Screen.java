/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferStrategy;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Otavio
 */
public class Screen extends JFrame {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private Screen() {
        super();
        setSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BufferStrategy bs = getBufferStrategy();
        /*
        if(bs == null){
            createBufferStrategy(2);
            return;
        }
        bs.show();
         */
    }

    public void render(List<Renderable> renderables) {
        Graphics2D g = (Graphics2D) getGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        for (Renderable renderable : renderables) {
            if (renderable instanceof Snake) {
                for (Point piece : ((Snake) renderable).getBody()) {
                    g.drawImage(renderable.getImage(), (int)piece.getX(), (int)piece.getY(), null);
                }
            } else {
                g.drawImage(renderable.getImage(), renderable.getX(), renderable.getY(), null);
            }
        }
        g.dispose();
    }

    public static Screen getInstance() {
        return ScreenHolder.INSTANCE;
    }

    private static class ScreenHolder {

        private static final Screen INSTANCE = new Screen();
    }
}
