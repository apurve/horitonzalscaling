package org.laudhoot.reviews.controller;

import org.laudhoot.reviews.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingsController {

    @Autowired
    Environment environment;

    @RequestMapping("/ratings/{product}")
    public Rating getRatings(@PathVariable("product") String product) {
        Rating rating = null;
        switch (product) {
            case "PS4" : {rating = new Rating(5);break;}
            case "OnePlus 5T" : {rating = new Rating(4);break;}
            case "Nexon EV" : {rating = new Rating(2);break;}
            case "Laptop" : {rating = new Rating(3);break;}
        }
        if(rating!=null)
            rating.setPort(environment.getProperty("server.port"));
        return rating;
    }

}