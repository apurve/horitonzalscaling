package org.laudhoot.reviews.controller;

import org.laudhoot.reviews.model.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingsController {

    @RequestMapping("/rating/{product}")
    public Rating getRatings(@PathVariable("product") String product) {
        if(product.equals("PS4")) {
            return new Rating(5);
        }
        return new Rating(0);
    }

}