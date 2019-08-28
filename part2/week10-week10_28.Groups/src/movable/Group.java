/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcell
 */
public class Group implements Movable {
    private List<Movable> organisms;
    
    public Group() {
        this.organisms = new ArrayList<Movable>();
    }
    
    public void addToGroup(Movable movable) {
        this.organisms.add(movable);
    }
    
    @Override
    public String toString() {
        String str = "";
        for(Movable movable : this.organisms) {
            str += movable + "\n";
        }
        return str;
    }

    @Override
    public void move(int dx, int dy) {
        for(Movable movable : this.organisms) {
            movable.move(dx, dy);
        }
    }
    
}
