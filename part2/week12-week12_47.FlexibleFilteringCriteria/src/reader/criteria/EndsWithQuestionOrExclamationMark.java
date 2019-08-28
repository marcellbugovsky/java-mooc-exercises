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
public class EndsWithQuestionOrExclamationMark implements Criterion {

    
    public EndsWithQuestionOrExclamationMark() {
    }

    @Override
    public boolean complies(String line) {
        return (line.endsWith("!") || line.endsWith("?"));
    }
}
