/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author Otavio
 */
public abstract class Actor implements Renderable {

    private Image img;
    private int x;
    private int y;
    private Color color;

    public Actor(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Actor(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract void act();

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
    
    @Override
    public Image getImage(){
        return img;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(int x, int y) {
        this.x += x;
        this.y += y;
    }
    
    public void setImage(Image img){
        this.img = img;
    }

}
