/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Otavio
 */
public class Game {
    GameScene scene;

    public Game() {
        this.scene = new Scene();
        Screen.getInstance().addKeyListener(InputHandler.getInstance());
        
        Screen.getInstance().setVisible(true);
        Screen.getInstance().createBufferStrategy(2);
        gameLoop();
        Screen.getInstance().dispose();
    }
    
    private void gameLoop(){
        while(true){
            InputHandler.getInstance().update();
            this.scene.update();
            this.scene.render();
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void main(String[] args) {
        Game game = new Game();
    }
}
