/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.Map;
import reference.domain.Person;

/**
 *
 * @author Marcell
 */
public class PersonComparator implements Comparator<Person> {
    
    private Map<Person, Integer> peopleIdentities;
    
    public PersonComparator(Map<Person, Integer> peopleIdentities) {
        this.peopleIdentities = peopleIdentities;
    }
    
    @Override
    public int compare(Person p1, Person p2) {
        return peopleIdentities.get(p2) - peopleIdentities.get(p1);
    }
    
}
