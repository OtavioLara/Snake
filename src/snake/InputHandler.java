/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Otavio
 */
public class InputHandler implements KeyListener{
    private static final int PRESSED = 1;
    private static final int RELESED = 2;
    private static final int JUSTPRESSED = 3;
    
    private HashMap<Integer,Boolean> keyStatus;
    private HashMap<Integer,Integer> keyCache;
    
    private InputHandler() {
        keyStatus = new HashMap<>();
        keyCache = new HashMap<>();
    }
    
    public static InputHandler getInstance() {
        return InputHandlerHolder.INSTANCE;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        keyCache.put(e.getExtendedKeyCode(), PRESSED);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(keyCache.containsKey(e.getExtendedKeyCode()) && keyCache.get(e.getExtendedKeyCode()) == PRESSED){
            keyCache.put(e.getExtendedKeyCode(), JUSTPRESSED);
        }else{
            keyCache.put(e.getExtendedKeyCode(), RELESED);
        }
    }
    
    public void update(){
        ArrayList<Integer> justPressedKeys = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : keyCache.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            
            if(null != value)switch (value) {
                case PRESSED:
                    keyStatus.put(key, true);
                    break;
                case RELESED:
                    keyStatus.put(key, false);
                    break;
                default:
                    justPressedKeys.add(key);
                    keyStatus.put(key, true);
                    break;
            }
        }
        keyCache.clear();
        for (Integer justPressedKey : justPressedKeys) {
            keyCache.put(justPressedKey, RELESED);
        }
    }
    public boolean isPressed(int key){
        return keyStatus.containsKey(key) && keyStatus.get(key);
    }
    private static class InputHandlerHolder {

        private static final InputHandler INSTANCE = new InputHandler();
    }
}
