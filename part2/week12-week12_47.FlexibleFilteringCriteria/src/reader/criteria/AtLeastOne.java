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
public class AtLeastOne implements Criterion {

    Criterion[] criterias;
    
    public AtLeastOne(Criterion... criterias) {
        this.criterias = criterias;
    }

    @Override
    public boolean complies(String line) {
        boolean result = false;
        for(Criterion criteria : criterias) {
            if(criteria.complies(line)) {
                result = true;
            }
        }
        return result;
    }
    
    
}
