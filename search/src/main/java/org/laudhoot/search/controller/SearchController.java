package org.laudhoot.search.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.laudhoot.search.model.Catalogue;
import org.laudhoot.search.model.Rating;
import org.laudhoot.search.model.SearchResults;
import org.laudhoot.search.services.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SearchController {

    @Autowired
    private RatingsService ratingsService;

    @RequestMapping("/search")
    public SearchResults search() {
        Catalogue catalogue = new Catalogue();
        catalogue.setProduct("PS4");
        SearchResults searchResults = new SearchResults(catalogue);

        Rating rating = ratingsService.getRating(catalogue.getProduct());
        if(rating!= null) {
            catalogue.setRating(rating.getRating());
        } else {
            searchResults.setErrorMessage("Ratings Unavailable!");
        }
        return searchResults;
    }

}