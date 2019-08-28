/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phoneBook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Marcell
 */
public class PhoneBook {
    private Map<String, Map<String, Set<String>>> persons;
    
    public PhoneBook() {
        this.persons = new HashMap<String, Map<String, Set<String>>>();
    }
    
    public void addNumber(String name, String number) {
        if(!this.persons.containsKey(name)) {
            this.persons.put(name, new HashMap<String, Set<String>>());
        }
        
        if(!this.persons.get(name).containsKey("numbers")) {
            this.persons.get(name).put("numbers", new HashSet<String>());
        }
        
        this.persons.get(name).get("numbers").add(number);
    }
    
    public void addAddress(String name, String address) {
        if(!this.persons.containsKey(name)) {
            this.persons.put(name, new HashMap<String, Set<String>>());
        }
        
        if(!this.persons.get(name).containsKey("addresses")) {
            this.persons.get(name).put("addresses", new HashSet<String>());
        }
        
        this.persons.get(name).get("addresses").add(address);
    }
    
    public Set<String> searchByName(String name) {
        if(this.persons.containsKey(name) && this.persons.get(name).containsKey("numbers")) {
            return this.persons.get(name).get("numbers");
        }else{
            return null;
        }
    }
    
    public Set<String> getAddresses(String name) {
        if(this.persons.containsKey(name) && this.persons.get(name).containsKey("addresses")) {
            return this.persons.get(name).get("addresses");
        }else{
            return null;
        }
    }
    
    public String searchByNumber(String number) {
        for(String name : this.persons.keySet()) {
            if(this.persons.get(name).get("numbers").contains(number)){
                return name;
            }
        }
        return null;
    }
    
    public void remove(String name) {
        this.persons.remove(name);
    }
    
    public List<String> searchByKeyword(String keyword) {
        List<String> results = new ArrayList<String>();
        for(String name : this.persons.keySet()) {
            if(name.contains(keyword)){
                results.add(name);
            }
            if(this.persons.get(name).containsKey("addresses")){
                for(String number : this.persons.get(name).get("addresses")){
                    if(number.contains(keyword)){
                        results.add(name);
                    }
                }
            }
        }
        Collections.sort(results);
        return results;
    }
}
