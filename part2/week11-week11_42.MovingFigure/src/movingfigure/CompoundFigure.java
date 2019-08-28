/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Marcell
 */
public class CompoundFigure extends Figure {
    
    List<Figure> figures;
    
    public CompoundFigure() {
        super(0, 0);
        figures = new ArrayList<Figure>();
    }
    
    public void add(Figure figure) {
        figures.add(figure);
    }
    
    @Override
    public void move(int dx, int dy) {
        for(Figure figure : figures) {
            figure.move(dx, dy);
        }
    }
    
    @Override
    public void draw(Graphics graphics) {
        for(Figure figure : figures) {
            figure.draw(graphics);
        }
    }
    
}
