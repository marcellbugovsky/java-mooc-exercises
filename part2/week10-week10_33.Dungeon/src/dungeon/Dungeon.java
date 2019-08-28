/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Marcell
 */
public class Dungeon {
    private int length;
    private int height;
    private int vampires;
    private int moves;
    private boolean vampiresMove;
    private List<Character> vampireList;
    private Character player;
    private Random random;
    private Scanner reader;
    private boolean gameRunning;
    
    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        vampireList = new ArrayList<Character>();
        reader = new Scanner(System.in);
        random = new Random();
    }
    
    public void run() {
        gameRunning = true;
        characterSetup();
        
        while(moves > 0 && !vampireList.isEmpty()) {
            System.out.println(moves);
            System.out.println("");
            printCharacters();
            drawBoard();
            playerMove();
            moves--;
        }
        
        printCharacters();
        drawBoard();
        if(vampireList.isEmpty()) {
            System.out.println("YOU WIN");
        }else{
            System.out.println("YOU LOSE");
        }
    }
    
    private boolean validMovement(Character character, int dx, int dy) {
        for(Character vampire : vampireList) {
            if(vampire.getX() == character.getX() + dx && vampire.getY() == character.getY() + dy) {
                return false;
            }
        }
        if(character.getX() + dx > length - 3 && character.getY() + dy > height - 3) {
            return false;
        }
        return true;
    }
    
    private void vampireMove(Character vampire, int turns) {
        if(vampiresMove) {
            int dx = 0;
            int dy = 0;
            for(int i = 0; i < turns; i++) {
                switch(random.nextInt(4)) {
                    case 0: dy--; break;
                    case 1: dx--; break;
                    case 2: dx++; break;
                    case 3: dy++; break;
                }
            }
            if(validMovement(vampire, dx, dy)) {
                vampire.move(dx, dy);
            }
        }
    }
    
    private void playerMove() {
        String command = reader.nextLine();
        for(int i = 0; i < command.length(); i++) {
            switch(command.charAt(i)){
                case 'w': if(player.getY() - 1 < height){player.move(0, -1);} break;
                case 'a': if(player.getX() - 1 < height){player.move(-1, 0);} break;
                case 's': if(player.getY() + 1 < height){player.move(0, 1);} break;
                case 'd': if(player.getX() + 1 < height){player.move(1, 0);} break;
            }
        }
        int playerX = player.getX();
        int playerY = player.getY();
        
        List<Character> toBeRemoved = new ArrayList<Character>();
        for(Character vampire : vampireList) {
            if(vampire.getX() == playerX && vampire.getY() == playerY) {
                toBeRemoved.add(vampire);
            }
        }
        for(Character vampire : toBeRemoved) {
            vampireList.remove(vampire);
        }
        for(Character vampire : vampireList) {
            vampireMove(vampire, command.length());
        }
    }
    
    private void drawBoard() {
        for(int i = 0; i < height; i++){
            for(int j = 0; j < length; j++) {
                boolean drawn = false;
                if(player.getX() == j && player.getY() == i) {
                    System.out.print(player.getName());
                    drawn = true;
                }
                for(Character vampire : vampireList) {
                    if(vampire.getX() == j && vampire.getY() == i && !drawn) {
                        System.out.print(vampire.getName());
                        drawn = true;
                    }
                }
                if(!drawn) {
                    System.out.print(".");
                }
            }
            System.out.print("\n");
        }
        System.out.println("");
    }

    private void characterSetup() {
        player = new Character("@", 0, 0);
        List<List<Integer>> coordinates = getNonRepetetiveCoordinates(vampires);
        for(int i = 0; i < vampires; i++) {
            vampireList.add(new Character("v", coordinates.get(i).get(0), coordinates.get(i).get(1)));
        }
    }
    
    private void printCharacters() {
        System.out.println(player);
        for(Character vampire : vampireList) {
            System.out.println(vampire);
        }
        System.out.println("");
    }
    
    private List<List<Integer>> getNonRepetetiveCoordinates(int amount) {
        List<List<Integer>> coordinates = new ArrayList<List<Integer>>();
        for(int i = 0; i < amount; i++) {
            while(true){
                List<Integer> xy = new ArrayList<Integer>();
                xy.add(random.nextInt(length));
                xy.add(random.nextInt(height));
                if(!coordinates.contains(xy) && !(xy.get(0) == 0 && xy.get(1) == 0)) {
                    coordinates.add(xy);
                    break;
                }
            }
        }
        return coordinates;
    }
}
