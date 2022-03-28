package controller;

import jdk.swing.interop.SwingInterOpUtils;
import model.Movie;
import service.MovieService;
import view.MovieView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MovieController {
    private Movie model;
    private MovieService service;
    private MovieView view;

    public MovieController() {
    }

    public MovieController(Movie model, MovieService service, MovieView view) {
        this.model = model;
        this.service = service;
        this.view = view;
    }

    public String getMovieTitle() {
        return model.getTitle();
    }

    public void setMovieTitle(String title) {
        this.model.setTitle(title);
    }

    public String getMovieDirector() {
        return model.getDirector();
    }

    public void setMovieDirector(String director) {
        this.model.setDirector(director);
    }

    public Integer getMovieNoOfTickets() {
        return model.getNoOfTickets();
    }

    public void setMovieNoOfTickets(Integer noOfTickets) {
        this.model.setNoOfTickets(noOfTickets);
    }

    public Integer getMoviePrice() {
        return model.getPrice();
    }

    public void setMoviePrice(Integer price) {
        this.model.setPrice(price);
    }

    public LocalDate getMovieStart() {
        return model.getStart();
    }

    public void setMovieStart(LocalDate start) {
        this.model.setStart(start);
    }

    public LocalTime getMovieTime() {
        return model.getTime();
    }

    public void setMovieTime(LocalTime time) {
        this.model.setTime(time);
    }


    public void AddMovie()
    {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Movie title is: ");
        String title = scanner.nextLine();
        System.out.println("Movie director is: ");
        String director = scanner.nextLine();
        System.out.println("Number of tickets is: ");
        Integer noOfTickets = scanner.nextInt();
        System.out.println("Price is: ");
        Integer price = scanner.nextInt();
        System.out.println("Start date is: (d/MM/yyyy)");
        String startString = scanner.nextLine();
        LocalDate start = LocalDate.parse(startString, dateFormatter);
        System.out.println("Time is: (hh:mm) ");
        String timeString = scanner.nextLine();
        LocalTime time = LocalTime.parse(timeString,timeFormatter);

        service.AddMovie(title, director, noOfTickets, price, start, time);

    }

}
