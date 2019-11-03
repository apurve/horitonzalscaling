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

    @Override
    @HystrixCommand(fallbackMethod = "getRatingFallback")
    public Rating getRating(String product) {
        Rating rating = restTemplate.getForObject("http://RATING-SERVICE/rating/"+product, Rating.class);
        return rating;
    }

    public Rating getRatingFallback(String product) {
        return null;
    }

}
