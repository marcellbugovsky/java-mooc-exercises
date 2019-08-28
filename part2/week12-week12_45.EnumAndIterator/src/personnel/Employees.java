/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Marcell
 */
public class Employees {

    List<Person> employees;
    
    public Employees() {
        employees = new ArrayList<Person>();
    }
    
    public void add(Person person) {
        employees.add(person);
    }
    
    public void add(List<Person> persons) {
        for(Person person : persons) {
            employees.add(person);
        }
    }
    
    public void print() {
        Iterator<Person> iterator = employees.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    
    public void print(Education education) {
        Iterator<Person> iterator = employees.iterator();
        while(iterator.hasNext()) {
            Person employee = iterator.next();
            if(employee.getEducation().equals(education)) {
                System.out.println(employee);
            }
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> iterator = employees.iterator();
        while(iterator.hasNext()) {
            Person employee = iterator.next();
            if(employee.getEducation() == education) {
                iterator.remove();
            }
        }
    }
}
