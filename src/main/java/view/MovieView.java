package view;

import model.Movie;

import java.util.List;

public class MovieView {

    public void printMovieDetails(List<Movie> movies){
        System.out.println("Movies: \n");
        for(Movie movie : movies) {
            System.out.println("Title: " + movie.getTitle());
            System.out.printf("Director: " + movie.getDirector()+ " - ");
            System.out.printf("Number of tickets: " + movie.getNoOfTickets()+ " - ");
            System.out.printf("Price: " + movie.getPrice() + " - ");
            System.out.printf("Date: " + movie.getStart()+ " - ");
            System.out.printf("Time: " + movie.getTime()+ "  \n\n");
        }
    }

    public void printDateAndTimeForMovie(List<Movie> movies)
    {
        for(Movie movie : movies) {
            System.out.println("Date is: " + movie.getStart());
            System.out.println("Time is: " + movie.getTime() + " \n");
        }
    }

    public void printTimeForMovie(List<Movie> movies) {
        for(Movie movie : movies) {
            System.out.println("Time is: " + movie.getTime() + " \n");
        }
    }

    public void printTicketsForMovie(Movie movie) {
            System.out.println("Available tickets: " + movie.getNoOfTickets() + " \n");
    }

    public void printReceipt(Movie chosenMovie, Integer noOfTickets) {
        System.out.println("Your total is: " + chosenMovie.getPrice() * noOfTickets + "\n");
        System.out.println("You now have " + noOfTickets + " tickets for ");
        System.out.println("Title: " + chosenMovie.getTitle());
        System.out.printf("Director: " + chosenMovie.getDirector()+ " - ");
        System.out.printf("Date: " + chosenMovie.getStart()+ " - ");
        System.out.printf("Time: " + chosenMovie.getTime()+ "  \n\n");
    }
}
