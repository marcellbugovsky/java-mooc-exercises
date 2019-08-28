package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Random random;
    private Apple apple;

    public WormGame(int width, int height) {
        super(1000, null);
        
        random = new Random();

        this.width = width;
        this.height = height;
        this.continues = true;

        addActionListener(this);
        setInitialDelay(2000);
        
        worm = new Worm(width / 2, height / 2, Direction.DOWN, this);
        setRandomApple();
    }
    
    public Apple getApple() {
        return apple;
    }
    
    public void setApple(Apple apple) {
        this.apple = apple;
    }
    
    public void setRandomApple() {
        apple = new Apple(random.nextInt(width - 1), random.nextInt(height - 1));
    }
    
    public Worm getWorm() {
        return worm;
    }
    
    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }else {
            worm.move();
            if(worm.runsInto(apple)) {
                worm.grow();
                setRandomApple();
            }else if(worm.runsIntoItself()) {
                continues = false;
            }
        }
        updatable.update();
        super.setDelay(1000 / worm.getLength());
    }

}
