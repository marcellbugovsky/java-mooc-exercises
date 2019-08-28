/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

/**
 *
 * @author Marcell
 */
public class FilmComparator implements Comparator<Film> {
    
    private Map<Film, List<Rating>> ratings;
    
    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }
    
    private int getAverageRating(Film film) {
        int sum = 0;
        
        for(Rating rating : ratings.get(film)) {
            sum += rating.getValue();
        }
        
        return sum / ratings.get(film).size();
    }

    @Override
    public int compare(Film f1, Film f2) {
        return getAverageRating(f2) - getAverageRating(f1);
    }
}
