package org.laudhoot.search.controller;

import com.netflix.discovery.converters.Auto;
import org.laudhoot.search.model.Catalogue;
import org.laudhoot.search.model.Rating;
import org.laudhoot.search.model.SearchResults;
import org.laudhoot.search.repository.ProductRepository;
import org.laudhoot.search.services.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @Autowired
    private RatingsService ratingsService;

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/search/{searchText}")
    public SearchResults search(@PathVariable String searchText) {
        Catalogue catalogue = new Catalogue();
        catalogue.setProduct(productRepository.findByDescription(searchText));
        SearchResults searchResults = new SearchResults(catalogue);

        Rating rating = ratingsService.getRating(searchText);
        if(rating != null) {
            catalogue.setRating(rating);
        } else {
            searchResults.setErrorMessage("Ratings Unavailable!");
        }
        return searchResults;
    }

}