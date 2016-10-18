/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Otavio
 */
public class Fruit extends Actor {
    
    public Fruit(int x, int y) {
        super(x, y, Color.red);
        creatImage();
    }
    public Fruit(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public void act() {
        
    }

    @Override
    public void creatImage() {
        setImage(new BufferedImage(SIZERECT, SIZERECT, BufferedImage.TYPE_4BYTE_ABGR_PRE));
        Graphics2D g = (Graphics2D)getImage().getGraphics();
        g.setColor(getColor());
        g.fillRect(0, 0, SIZERECT, SIZERECT);
        g.dispose();
    }
    
}
