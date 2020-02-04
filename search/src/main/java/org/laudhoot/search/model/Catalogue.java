package org.laudhoot.search.model;

import java.util.Objects;

public class Catalogue {

    private Product product;

    private Rating rating;

    public Catalogue() {
    }

    public Catalogue(Product product, Rating rating) {
        this.product = product;
        this.rating = rating;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Catalogue)) return false;
        Catalogue catalogue = (Catalogue) o;
        return getRating() == catalogue.getRating() &&
                getProduct().equals(catalogue.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProduct(), getRating());
    }

    @Override
    public String toString() {
        return "Catalogue{" +
                "product=" + product +
                ", rating=" + rating +
                '}';
    }
}