/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;

/**
 *
 * @author Marcell
 */
public class PersonalBoard extends GameOfLifeBoard {
    
    public PersonalBoard(int width, int height) {
        super(width, height);
    }

    @Override
    public void initiateRandomCells(double probabilityForEachCell) {
        for(int x = 0; x < super.getWidth(); x++) {
            for(int y = 0; y < super.getHeight(); y++) {
                if(new Random().nextDouble() <= probabilityForEachCell) {
                    turnToLiving(x, y);
                }else{
                    turnToDead(x, y);
                }
            }
        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        if(x < super.getWidth() && x >= 0 && y < super.getHeight() && y >= 0) {
            return super.getBoard()[x][y];
        }else{
            return false;
        }
    }

    @Override
    public void turnToLiving(int x, int y) {
        if(x < super.getWidth() && x >= 0 && y < super.getHeight() && y >= 0) {
            super.getBoard()[x][y] = true;
        }
    }

    @Override
    public void turnToDead(int x, int y) {
        if(x < super.getWidth() && x >= 0 && y < super.getHeight() && y >= 0) {
            super.getBoard()[x][y] = false;
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        int livingNeighbours = 0;
        if(x < super.getWidth() - 1) {
            if(isAlive(x + 1, y)){
                livingNeighbours++;
            }
            if(y < super.getHeight() - 1) {
                if(isAlive(x + 1, y + 1)) {
                    livingNeighbours++;
                }
            }
            if(y > 0) {
                if(isAlive(x + 1, y - 1)) {
                    livingNeighbours++;
                }
            }
        }
        if(x > 0) {
            if(isAlive(x - 1, y)) {
                livingNeighbours++;
            }
            if(y < super.getHeight() - 1) {
                if(isAlive(x - 1, y + 1)) {
                    livingNeighbours++;
                }
            }
            if(y > 0) {
                if(isAlive(x - 1, y - 1)) {
                    livingNeighbours++;
                }
            }
        }
        if(y < super.getHeight() - 1) {
            if(isAlive(x, y + 1)) {
                livingNeighbours++;
            }
        }
        if(y > 0) {
            if(isAlive(x, y - 1)) {
                livingNeighbours++;
            }
        }
        return livingNeighbours;
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        if(isAlive(x, y) && getNumberOfLivingNeighbours(x, y) < 2 || isAlive(x, y) && getNumberOfLivingNeighbours(x, y) > 3) {
            turnToDead(x, y);
        }else if(!isAlive(x, y) && getNumberOfLivingNeighbours(x, y) == 3) {
            turnToLiving(x, y);
        }
    }
    
}
