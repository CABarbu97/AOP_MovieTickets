package service;

import database.MoviesRepo;
import exceptions.InvalidDateException;
import exceptions.InvalidTimeException;
import exceptions.NoMovieException;
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
        try{
            return moviesRepo.getMovieByTitle(title);
        }
        catch (NoMovieException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public List<Movie> getMovieByTitleAndDate(String title, String date){
        try {
            if (date.split("-").length != 3) {
                throw new InvalidDateException();
            }
        }catch (InvalidDateException ide){
            ide.printStackTrace();
        }
        try {
            return moviesRepo.getMovieByTitleAndDate(title, date);
        } catch (InvalidDateException ide) {
            ide.printStackTrace();
            return null;
        }
    }

    public Movie getMovieByTitleDateAndTime(String title, String startString, String timeString) {
        try{
            if(timeString.split(":").length != 2){
                throw new InvalidTimeException("The time format is invalid");
            }
        }catch (InvalidTimeException ite){
            ite.printStackTrace();
        }
        try{
            return moviesRepo.getMoviesByTitleDateAndTime(title, startString, timeString);
        }catch (InvalidTimeException ite){
            ite.printStackTrace();
            return null;
        }
    }

    public Movie retrieveTickets(Movie chosenMovie, Integer noOfTickets) {
        return moviesRepo.retrieveTickets(chosenMovie, noOfTickets);
    }
}
