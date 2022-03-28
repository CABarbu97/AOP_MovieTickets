package view;

import model.Movie;

public class MovieView {
    public void printMovieDetails(Movie movie){
        System.out.println("Movie Details: ");
        System.out.println("Title: "+ movie.getTitle());
        System.out.printf("Director: "+ movie.getDirector());
        System.out.printf("Number of tickets: "+ movie.getNoOfTickets());
        System.out.printf("Price: " + movie.getPrice());
        System.out.printf("Date: " + movie.getStart());
        System.out.printf("Time: "+ movie.getTime());
    }


}
