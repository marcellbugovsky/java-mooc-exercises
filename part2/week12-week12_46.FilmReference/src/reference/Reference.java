/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.Collections;
import java.util.List;
import reference.comparator.FilmComparator;
import reference.domain.Film;
import reference.domain.Person;

/**
 *
 * @author Marcell
 */
public class Reference {
    
    private RatingRegister register;
    
    public Reference(RatingRegister register) {
        this.register = register;
    }
    
    public Film recommendFilm(Person person) {
        List<Film> films = register.getFilms();
        Collections.sort(films, new FilmComparator(register.filmRatings()));
        for(Film film : films) {
            if(!register.getPersonalRatings(person).containsKey(film)) {
                return film;
            }
        }
        return null;
    }
}
