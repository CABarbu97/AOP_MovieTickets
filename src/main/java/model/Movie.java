package model;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

import java.time.LocalDate;
import java.time.LocalTime;

@Document(collection = "movies", schemaVersion = "1.0")
public class Movie {
    @Id
    private String id;
    private String title;
    private String director;
    private Integer noOfTickets;
    private Integer price;
    private LocalDate start;
    private LocalTime time;

    public Movie(){}

    public Movie(String title, String director, Integer noOfTickets, Integer price, LocalDate start, LocalTime time) {
        this.title = title;
        this.director = director;
        this.noOfTickets = noOfTickets;
        this.price = price;
        this.start = start;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getNoOfTickets() {
        return noOfTickets;
    }

    public void setNoOfTickets(Integer noOfTickets) {
        this.noOfTickets = noOfTickets;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
