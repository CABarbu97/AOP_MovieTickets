package model;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

import java.time.LocalDate;
import java.time.LocalTime;

@Document(collection = "orders", schemaVersion = "1.0")
public class Order {
    @Id
    private String id;
    private String movieTitle;
    private Integer noOfTickets;
    private LocalDate date;
    private LocalTime time;
    private Integer total;

    public Order(){}

    public Order(String movieTitle, Integer noOfTickets, LocalDate date, LocalTime time, Integer total) {
        this.movieTitle = movieTitle;
        this.noOfTickets = noOfTickets;
        this.date = date;
        this.time = time;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public Integer getNoOfTickets() {
        return noOfTickets;
    }

    public void setNoOfTickets(Integer noOfTickets) {
        this.noOfTickets = noOfTickets;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
