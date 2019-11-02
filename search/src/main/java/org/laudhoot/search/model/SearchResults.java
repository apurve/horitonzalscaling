package org.laudhoot.search.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class SearchResults {

    private Catalogue catalogue;

    public SearchResults() {
    }

    public SearchResults(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    public Catalogue getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

}
