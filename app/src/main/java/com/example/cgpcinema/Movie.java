package com.example.cgpcinema;

public class Movie {
    String id;
    String title;
    String year;
    String imageURL;
    String rating;

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }

    public Movie() {

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
    public Movie(String id, String title, String year, String imageURL, String rating) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.imageURL = imageURL;
        this.rating = rating;
    }
}
