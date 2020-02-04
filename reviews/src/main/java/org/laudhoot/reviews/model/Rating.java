package org.laudhoot.reviews.model;

public class Rating {

    private int rating;

    private String port;

    public Rating() {
    }

    public Rating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
