
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marcell
 */
public class RingingCentre {
    private Map<Bird, List<String>> observations;
    
    public RingingCentre() {
        this.observations = new HashMap<Bird, List<String>>();
    }
    
    public void observe(Bird bird, String place) {
        if(!this.observations.containsKey(bird)) {
            this.observations.put(bird, new ArrayList<String>());
        }
        this.observations.get(bird).add(place);
    }
    
    public void observations(Bird bird) {
        if(this.observations.containsKey(bird)){
            System.out.println(bird + " observations: " + this.observations.get(bird).size());
            for(String place : this.observations.get(bird)){
                System.out.println(place);
            }
        }else{
            System.out.println(bird + " observations: 0");
        }
    }
}
