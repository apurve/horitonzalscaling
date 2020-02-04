package org.laudhoot.search.services;

import org.laudhoot.search.model.Rating;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="RATING-SERVICE")
@RibbonClient(name="RATING-SERVICE")
public interface RatingsServiceProxy {

    @RequestMapping("/ratings/{product}")
    public Rating getRatings(@PathVariable("product") String product);

}
