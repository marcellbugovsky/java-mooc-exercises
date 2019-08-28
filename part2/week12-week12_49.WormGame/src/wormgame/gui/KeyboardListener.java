/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.gui;

import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.*;
import java.awt.event.KeyListener;
import wormgame.Direction;
import wormgame.domain.Worm;

/**
 *
 * @author Marcell
 */
public class KeyboardListener implements KeyListener {

    private Worm worm;

    public KeyboardListener(Worm worm) {
        this.worm = worm;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent key) {
        switch(key.getKeyCode()) {
            case VK_UP: worm.setDirection(Direction.UP); break;
            case VK_DOWN: worm.setDirection(Direction.DOWN); break;
            case VK_LEFT: worm.setDirection(Direction.LEFT); break;
            case VK_RIGHT: worm.setDirection(Direction.RIGHT); break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
