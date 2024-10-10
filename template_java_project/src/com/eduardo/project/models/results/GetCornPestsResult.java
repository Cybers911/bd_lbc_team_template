package com.eduardo.project.models.results;

import com.eduardo.project.models.CornPest;

import java.util.List;

public class GetCornPestsResult {

    private List<CornPest> cornPests;

    public GetCornPestsResult() {}

    public GetCornPestsResult(List<CornPest> cornPests) {
        this.cornPests = cornPests;
    }

    public List<CornPest> getCornPests() {
        return cornPests;
    }

    public void setCornPests(List<CornPest> cornPests) {
        this.cornPests = cornPests;
    }
}

