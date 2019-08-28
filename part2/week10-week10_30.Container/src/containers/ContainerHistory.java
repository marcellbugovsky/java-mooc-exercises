/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Marcell
 */
public class ContainerHistory {
    private List<Double> history;
    
    public ContainerHistory() {
        this.history = new ArrayList<Double>();
    }
    
    public void add(double situation) {
        history.add(situation);
    }
    
    public void reset() {
        history.clear();
    }
    
    public double maxValue() {
        if(!history.isEmpty()){
            return Collections.max(history);
        }else{
            return 0;
        }
    }
    
    public double minValue() {
        if(!history.isEmpty()){
            return Collections.min(history);
        }else{
            return 0;
        }
    }
    
    public double average() {
        if(!history.isEmpty()){
            double sum = 0;
            for(double value : history){
                sum+= value;
            }
            return sum / (double) history.size();
        }else{
            return 0;
        }
    }
    
    public double greatestFluctuation() {
        if(!history.isEmpty() && history.size() > 1){
            double greatestFluctuation = 0;
            for(int i = 1; i < history.size(); i++) {
                if(greatestFluctuation < Math.abs(history.get(i) - history.get(i - 1))) {
                    greatestFluctuation = Math.abs(history.get(i) - history.get(i -1));
                }
            }
            return greatestFluctuation;
        }else{
            return 0;
        }
    }
    
    public double variance() {
        if(!history.isEmpty() && history.size() > 1) {
            double sum = 0;
            for(double value : history) {
                sum += Math.pow((value - average()), 2);
            }
            return sum / (history.size() - 1);
        }else{
            return 0;
        }
    }
    
    public String toString() {
        return history.toString();
    }
}
