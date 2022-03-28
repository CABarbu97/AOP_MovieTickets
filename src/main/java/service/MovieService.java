package service;

import database.MoviesRepo;
import model.Movie;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MovieService {
    private MoviesRepo moviesRepo = new MoviesRepo();

    public void AddMovie(String title,
                         String director,
                         Integer noOfTickets,
                         Integer price,
                         String startString,
                         String timeString)
    {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm");
        LocalDate start = LocalDate.parse(startString, dateFormatter);
        LocalTime time = LocalTime.parse(timeString,timeFormatter);

        Movie movie = new Movie(title,
                director,
                noOfTickets,
                price,
                start,
                time);

        moviesRepo.AddMovieToRepo(movie);

    }

    public List<Movie> getAllMovies(){
        return moviesRepo.getAllMovies();
    }

    public List<Movie> getMovieByTitle(String title){
        return moviesRepo.getMovieByTitle(title);
    }
}
