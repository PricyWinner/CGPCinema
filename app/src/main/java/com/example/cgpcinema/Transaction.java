package com.example.cgpcinema;

import java.util.Date;

public class Transaction {
    Movie movie;
    String location;
    String time;
    Date transactionDate;


    public Transaction(Movie movie, String location, String time, Date transactionDate) {
        this.movie = movie;
        this.location = location;
        this.time = time;
        this.transactionDate = transactionDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }


    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
