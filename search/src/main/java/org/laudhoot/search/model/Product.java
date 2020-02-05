package org.laudhoot.search.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Product {

    @Id
    @JsonIgnore
    private Long id;

    @ApiModelProperty(name = "description", required = true, value = "String", notes = "A brief description of the product.")
    private String description;
    @ApiModelProperty(name = "price", required = true, value = "float", notes = "Selling price of the product.")
    private BigDecimal price;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId().equals(product.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
