/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 *
 * @author Otavio
 */
public class SnakePlayer extends Snake {

    public SnakePlayer(int x, int y) {
        super(x, y);
        
    }
    
    public SnakePlayer(List<Point> body, Color color, int startSize, int x, int y) {
        super(body, color, x, y);
    }

    @Override
    public void act() {
        super.act();
        updateDir();
        
    }
    public void updateDir(){
        if(InputHandler.getInstance().isPressed(KeyEvent.VK_UP) || InputHandler.getInstance().isPressed(KeyEvent.VK_W)){
            setDirection(UP);
        }
        if(InputHandler.getInstance().isPressed(KeyEvent.VK_DOWN) || InputHandler.getInstance().isPressed(KeyEvent.VK_S)){
            setDirection(DOWN);
        }
        if(InputHandler.getInstance().isPressed(KeyEvent.VK_LEFT) || InputHandler.getInstance().isPressed(KeyEvent.VK_A)){
            setDirection(LEFT);
        }
        if(InputHandler.getInstance().isPressed(KeyEvent.VK_RIGHT) || InputHandler.getInstance().isPressed(KeyEvent.VK_D)){
            setDirection(RIGHT);
        }
    }
    
    
}
