/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Otavio
 */
public class Scene extends GameScene{
    private List<Actor> actors;
    
    public Scene() {
        actors = new ArrayList<>();
        Fruit f = new Fruit(50, 50);
        SnakePlayer s = new SnakePlayer(100, 100, 6);
        addActor(f);
        addActor(s);
    }    
}
