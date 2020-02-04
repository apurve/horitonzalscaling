package org.laudhoot.search.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.laudhoot.search.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RatingServiceImpl implements RatingsService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RatingsServiceProxy ratingsServiceProxy;

    @Override
    @HystrixCommand(fallbackMethod = "getRatingFallback")
    public Rating getRating(String product) {
        //return restTemplate.getForObject("http://RATING-SERVICE/ratings/"+product, Rating.class);
        return ratingsServiceProxy.getRatings(product);
    }

    public Rating getRatingFallback(String product) {
        return null;
    }

}
