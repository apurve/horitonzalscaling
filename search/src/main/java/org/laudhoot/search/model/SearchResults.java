package org.laudhoot.search.model;

import io.swagger.annotations.ApiModelProperty;

public class SearchResults {

    @ApiModelProperty(notes = "The catalogue of products matching the search text.", name = "catalogue", value = "reference")
    private Catalogue catalogue;

    @ApiModelProperty(notes = "Description of error in case resource not found.", name = "errorMessage", value = "String")
    private String errorMessage;

    public SearchResults(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    public SearchResults(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public SearchResults() { }

    public Catalogue getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "SearchResults{" +
                "catalogue=" + catalogue +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
