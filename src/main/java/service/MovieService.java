package service;

import database.MoviesRepo;
import model.Movie;

import java.time.LocalDate;
import java.time.LocalTime;

public class MovieService {
    private MoviesRepo moviesRepo = new MoviesRepo();

    public void AddMovie(String title,
                         String director,
                         Integer noOfTickets,
                         Integer price,
                         LocalDate start,
                         LocalTime time)
    {
        Movie movie = new Movie(title,
                director,
                noOfTickets,
                price,
                start,
                time);

        moviesRepo.AddMovieToRepo(movie);

    }
}
