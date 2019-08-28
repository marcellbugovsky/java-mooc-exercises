/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author Marcell
 */
public class Character {
    private String name;
    private int x;
    private int y;
    
    public Character(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
    
    public String getName() {
        return name;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void move(int dx, int dy) {
        if(x + dx >= 0) {
            x += dx;
        }
        if(y + dy >= 0) {
            y += dy;
        }
    }
    
    @Override
    public String toString() {
        return name + " " + x + " " + y;
    }
    
}
