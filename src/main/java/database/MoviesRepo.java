package database;

import io.jsondb.JsonDBTemplate;
import model.Movie;

import java.util.List;

public class MoviesRepo {

    public MoviesRepo() {
    }

    public void AddMovieToRepo(Movie movie)
    {
        Configuration.getJsonDBTemplate().insert(movie);
    }

    public List<Movie> getAllMovies()
    {
        return Configuration.getJsonDBTemplate().getCollection(Movie.class);
    }

    public List<Movie> getMovieByTitle(String title){
        String jxQuery = String.format("/.[title]=%s",title);
        return Configuration.getJsonDBTemplate().find(jxQuery, Movie.class);
    }

}
