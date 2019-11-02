package org.laudhoot.search.controller;

import org.laudhoot.search.model.Catalogue;
import org.laudhoot.search.model.Rating;
import org.laudhoot.search.model.SearchResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SearchController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/search")
    public SearchResults search() {
        Catalogue catalogue = new Catalogue();
        catalogue.setProduct("PS4");

        Rating rating = restTemplate.getForObject("http://RATING-SERVICE/rating/"+catalogue.getProduct(), Rating.class);

        catalogue.setRating(rating.getRating());
        return new SearchResults(catalogue);
    }

}