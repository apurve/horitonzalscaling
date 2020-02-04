package org.laudhoot.search.services;

import org.laudhoot.search.model.Rating;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="application-gateway")
@RibbonClient(name="rating-service")
public interface RatingsServiceProxy {

    @RequestMapping("/rating-service/ratings/{product}")
    public Rating getRatings(@PathVariable("product") String product);

}