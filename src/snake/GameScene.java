/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Otavio
 */
public abstract class GameScene {
    private List<Actor> actors = new LinkedList<>();
    
    public void addActor(Actor actor){
        actors.add(actor);
    }
    public void removeActor(Actor actor){
        actors.remove(actor);
    }
    public void render(){
        List<Renderable> renderable = new LinkedList<>(actors);
        Screen.getInstance().render(renderable);
    }
    public void update(){
        for (Actor actor : actors) {
            actor.act();
        }
    }
}
