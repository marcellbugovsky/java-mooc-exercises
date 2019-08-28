/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Marcell
 */
public class MindfulDictionary {
    private Map<String, String> dictionary;
    private File file;
    private Scanner reader;
    
    public MindfulDictionary() {
        dictionary = new HashMap<String, String>();
    }
    
    public MindfulDictionary(String file) throws FileNotFoundException {
        this();
        this.file = new File(file);
    }
    
    public void add(String word, String translation) {
        if(!dictionary.containsKey(word)) {
            dictionary.put(word, translation);
        }
    }
    
    public boolean load() {
        try{
            reader = new Scanner(file);
            while(reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] words = line.split(":");
                dictionary.put(words[0], words[1]);
            }
            reader.close();
            return true;
        }catch(Exception e) {
            return false;
        }
    }
    
    public boolean save() {
        try{
            FileWriter writer = new FileWriter(file);
            for(String key : dictionary.keySet()) {
                writer.write(key + ":" + dictionary.get(key) + "\n");
            }
            writer.close();
            return true;
        }catch(Exception e) {
            return false;
        }
    }
    
    public String translate(String word) {
        if(dictionary.containsKey(word)) {
            return dictionary.get(word);
        }else if(dictionary.containsValue(word)) {
            for(String key : dictionary.keySet()) {
                if(dictionary.get(key).equals(word)) {
                    return key;
                }
            }
        }
        return null;
    }
    
    public void remove(String word) {
        if(dictionary.containsKey(word)) {
            dictionary.remove(word);
        }else if(dictionary.containsValue(word)) {
            String toBeRemoved = "";
            for(String key : dictionary.keySet()) {
                if(dictionary.get(key).equals(word)) {
                    toBeRemoved = key;
                }
            }
            dictionary.remove(toBeRemoved);
        }
    }
        
}
