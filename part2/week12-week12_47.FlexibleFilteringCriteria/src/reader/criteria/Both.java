/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;

/**
 *
 * @author Marcell
 */
public class Both implements Criterion {

    Criterion criteria1;
    Criterion criteria2;
    
    public Both(Criterion criteria1, Criterion criteria2) {
        this.criteria1 = criteria1;
        this.criteria2 = criteria2;
    }

    @Override
    public boolean complies(String line) {
        return criteria1.complies(line) && criteria2.complies(line);
    }
    
    
}
