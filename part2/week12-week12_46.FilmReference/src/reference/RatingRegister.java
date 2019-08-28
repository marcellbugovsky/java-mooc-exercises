/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.domain.*;

/**
 *
 * @author Marcell
 */
public class RatingRegister {
    
    private Map<Film, List<Rating>> register;
    private Map<Person, Map<Film, Rating>> personalRatings;

    public RatingRegister() {
        register = new HashMap<Film, List<Rating>>();
        personalRatings = new HashMap<Person, Map<Film, Rating>>();
    }
    
    public void addRating(Film film, Rating rating) {
        if(register.containsKey(film)) {
            register.get(film).add(rating);
        }else {
            register.put(film, new ArrayList<Rating>());
            register.get(film).add(rating);
        }
    }
    
    public void addRating(Person person, Film film, Rating rating) {
        if(personalRatings.containsKey(person)) {
            if(!personalRatings.get(person).containsKey(film)) {
                personalRatings.get(person).put(film, rating);
            }
        }else {
            personalRatings.put(person, new HashMap<Film, Rating>());
            personalRatings.get(person).put(film, rating);
        }
        addRating(film, rating);
    }
    
    public Rating getRating(Person person, Film film) {
        if(personalRatings.containsKey(person)) {
            if(personalRatings.get(person).containsKey(film)) {
                return personalRatings.get(person).get(film);
            }else {
                return Rating.NOT_WATCHED;
            }
        }else {
            return null;
        }
    }
    
    public Map<Film, Rating> getPersonalRatings(Person person) {
        if(personalRatings.containsKey(person)) {
            return personalRatings.get(person);
        }else {
            return new HashMap<Film, Rating>();
        }
    }
    
    public List<Person> reviewers() {
        List<Person> reviewers = new ArrayList<Person>();
        for(Person person : personalRatings.keySet()) {
            reviewers.add(person);
        }
        return reviewers;
    }
    
    public List<Film> getFilms() {
        List<Film> films = new ArrayList<Film>();
        for(Film film : register.keySet()) {
            films.add(film);
        }
        return films;
    }
    
    public List<Rating> getRatings(Film film) {
        return register.get(film);
    }
    
    public Map<Film, List<Rating>> filmRatings() {
        return register;
    }
}
