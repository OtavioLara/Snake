/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Image;

/**
 *
 * @author Otavio
 */
public interface Renderable {
    public int getX();
    public int getY();
    public void creatImage();
    public Image getImage();
}
