/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Marcell
 */
public class PersonalDuplicateRemover implements DuplicateRemover {
    private Map<String, Integer> strings;
    
    public PersonalDuplicateRemover() {
        this.strings = new HashMap<String, Integer>();
    }
    
    @Override
    public void add(String characterString) {
        if(!this.strings.containsKey(characterString)) {
            this.strings.put(characterString, 0);
        }else{
            this.strings.put(characterString, this.strings.get(characterString) + 1);
        }
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        int duplicates = 0;
        for(Integer duplicate : this.strings.values()) {
            duplicates += duplicate;
        }
        return duplicates;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return this.strings.keySet();
    }

    @Override
    public void empty() {
        this.strings.clear();
    }
}
