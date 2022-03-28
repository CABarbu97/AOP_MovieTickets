package database;

import exceptions.NoTicketsException;
import io.jsondb.JsonDBTemplate;
import io.jsondb.query.Update;
import model.Movie;

import java.time.LocalDate;
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
        String jxQuery = String.format("/.[title='%s']", title);
        return Configuration.getJsonDBTemplate().find(jxQuery, Movie.class);
    }

    public List<Movie> getMovieByTitleAndDate(String title, String date){
        String jxQuery = String.format("/.[title='%s' and start='%s']", title, date);
        return Configuration.getJsonDBTemplate().find(jxQuery, Movie.class);
    }

    public Movie getMoviesByTitleDateAndTime(String title, String startString, String timeString) {
        String jxQuery =
                String.format("/.[title='%s' and start='%s' and time='%s']", title, startString, timeString);
        return Configuration.getJsonDBTemplate().findOne(jxQuery, Movie.class);
    }

    public Movie retrieveTickets(Movie chosenMovie, Integer noOfTickets) throws NoTicketsException{
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
