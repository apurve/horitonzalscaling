package org.laudhoot.search.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @RequestMapping("/search")
    public String search() {
        return "search results";
    }
}
