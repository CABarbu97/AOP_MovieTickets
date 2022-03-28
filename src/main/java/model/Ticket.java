package model;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

import java.time.LocalDate;
import java.time.LocalTime;

@Document(collection = "tickets", schemaVersion = "1.0")
public class Ticket {
    @Id
    private String id;
    private Integer ticketNumber;
    private String movieName;
    private Integer price;
    private LocalDate date;
    private LocalTime time;

    public Ticket() {}

    public Ticket(Integer ticketNumber, String movieName, Integer price, LocalDate date, LocalTime time, String id) {
        this.ticketNumber = ticketNumber;
        this.movieName = movieName;
        this.price = price;
        this.date = date;
        this.time = time;
        this.id = id;
    }

    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
