/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulgame;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author Nenden
 */
public class Handler {
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    
    public void tick(){
        for(int i=0;i<object.size(); i++){
            GameObject tempObject = object.get(i);
            
            tempObject.tick();
        }
    }
    
    public void render(Graphics g){
        for(int i=0;i<object.size(); i++){
            GameObject tempObject = object.get(i);
            
            tempObject.render(g);
        }
    }
    
    public void addObject(GameObject object){
        this.object.add(object);
    }
    
    /**
     *
     * @return
     */
    public boolean EmptyIs(){
        return this.object.isEmpty();
    }
    public void removeObject(GameObject object){
        this.object.remove(object);
    }
}
