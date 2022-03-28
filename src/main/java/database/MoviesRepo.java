package database;

import io.jsondb.JsonDBTemplate;
import model.Movie;

public class MoviesRepo {

    public MoviesRepo() {
    }

    public void AddMovieToRepo(Movie movie)
    {
        Configuration.getJsonDBTemplate().insert(movie);
    }

}
