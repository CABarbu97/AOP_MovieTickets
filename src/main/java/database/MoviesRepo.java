package database;

import exceptions.NoMovieException;
import exceptions.NoTicketsException;
import io.jsondb.query.Update;
import model.Movie;

import java.util.List;
import java.util.regex.Pattern;

public class MoviesRepo {

    public MoviesRepo() {
    }

    public void AddMovieToRepo(Movie movie) {
        Configuration.getJsonDBTemplate().insert(movie);
    }

    public List<Movie> getAllMovies() {
        return Configuration.getJsonDBTemplate().getCollection(Movie.class);
    }

    public List<Movie> getMovieByTitle(String title) throws NoMovieException{
            String jxQuery = String.format("/.[title='%s']", title);
            List<Movie> movies = Configuration.getJsonDBTemplate().find(jxQuery, Movie.class);
            if (movies.isEmpty())
                throw new NoMovieException("The movie does not exist");
            return movies;
    }

    public List<Movie> getMovieByTitleAndDate(String title, String date) {
        Pattern p = Pattern.compile("");
        String jxQuery = String.format("/.[title='%s' and start='%s']", title, date);
        List<Movie> movies = Configuration.getJsonDBTemplate().find(jxQuery, Movie.class);
        if(movies.isEmpty())
            throw new NoMovieException("The movie does not exist on that date");
        return movies;
    }

    public Movie getMoviesByTitleDateAndTime(String title, String startString, String timeString) {
        String jxQuery =
                String.format("/.[title='%s' and start='%s' and time='%s']", title, startString, timeString);
        Movie movie = Configuration.getJsonDBTemplate().findOne(jxQuery, Movie.class);
        if(movie==null)
            throw new NoMovieException("No movie at the specified time");
        return movie;
    }

    public Movie retrieveTickets(Movie chosenMovie, Integer noOfTickets) throws NoTicketsException {
        String jxQuery =
                String.format("/.[title='%s' and start='%s' and time='%s']",
                        chosenMovie.getTitle(), chosenMovie.getStart().toString(),
                        chosenMovie.getTime().toString());

        Integer remainingTickets = chosenMovie.getNoOfTickets() - noOfTickets;
        Update update = Update.update("noOfTickets", chosenMovie.getNoOfTickets());
        update.set("noOfTickets", remainingTickets);
        return Configuration.getJsonDBTemplate().findAndModify(jxQuery, update, Movie.class);


    }
}
