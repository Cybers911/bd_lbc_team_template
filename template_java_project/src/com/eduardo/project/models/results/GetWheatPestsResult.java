package com.eduardo.project.models.results;

import com.eduardo.project.models.WheatPest;

import java.util.List;

public class GetWheatPestsResult {

    private List<WheatPest> wheatPests;

    public GetWheatPestsResult() {}

    public GetWheatPestsResult(List<WheatPest> wheatPests) {
        this.wheatPests = wheatPests;
    }

    public List<WheatPest> getWheatPests() {
        return wheatPests;
    }

    public void setWheatPests(List<WheatPest> wheatPests) {
        this.wheatPests = wheatPests;
    }
}
