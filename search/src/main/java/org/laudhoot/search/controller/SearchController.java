package org.laudhoot.search.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.laudhoot.search.model.Catalogue;
import org.laudhoot.search.model.Rating;
import org.laudhoot.search.model.SearchResults;
import org.laudhoot.search.repository.ProductRepository;
import org.laudhoot.search.services.RatingsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api("Search Service API")
@RestController
public class SearchController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RatingsService ratingsService;

    @Autowired
    private ProductRepository productRepository;

    @ApiOperation(value = "Searches for specified product.", response = SearchResults.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 404, message = "Not found!")})
    @GetMapping("/search/{searchText}")
    public SearchResults search(@PathVariable String searchText) {
        Catalogue catalogue = new Catalogue();
        catalogue.setProduct(productRepository.findByDescription(searchText));
        logger.info("found product : {}", catalogue.getProducts());
        if(catalogue.getProducts() == null || catalogue.getProducts().size() == 0)
            return new SearchResults("Product not found!");
        SearchResults searchResults = new SearchResults(catalogue);

        Rating rating = ratingsService.getRating(searchText);
        logger.info("found rating : {}", rating);
        if(rating != null) {
            catalogue.setRating(rating);
        } else {
            searchResults.setErrorMessage("Ratings Unavailable!");
        }
        logger.info("generated response : {}", searchResults);
        return searchResults;
    }

}