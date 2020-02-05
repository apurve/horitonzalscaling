package org.laudhoot.search.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Catalogue {

    @ApiModelProperty(notes = "The list of products matching the search text.", name = "products", value = "list")
    private List<Product> products;

    @ApiModelProperty(notes = "Rating of the product retrieved from ratings service.", name = "rating", value = "reference")
    private Rating rating;

    public Catalogue() {
    }

    public Catalogue(Product product, Rating rating) {
        this.products = new ArrayList();
        products.add(product);
        this.rating = rating;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProduct(List<Product> products) {
        this.products = products;
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
        return getProducts().equals(catalogue.getProducts()) &&
                getRating().equals(catalogue.getRating());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProducts(), getRating());
    }

    @Override
    public String toString() {
        return "Catalogue{" +
                "products=" + products +
                ", rating=" + rating +
                '}';
    }
}