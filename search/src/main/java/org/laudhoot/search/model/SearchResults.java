package org.laudhoot.search.model;

public class SearchResults {

    private Catalogue catalogue;

    private String errorMessage;

    public SearchResults(Catalogue catalogue) {
        this.catalogue = catalogue;
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

}
