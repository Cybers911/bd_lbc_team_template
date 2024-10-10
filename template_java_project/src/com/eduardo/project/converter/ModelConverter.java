package com.eduardo.project.converter;

import com.eduardo.project.models.CornPest;
import com.eduardo.project.models.WheatPest;
import com.eduardo.project.models.results.CornPestResult;
import com.eduardo.project.models.results.WheatPestResult;

import java.util.List;
import java.util.stream.Collectors;

public class ModelConverter {

    public CornPestResult toCornPestResult(CornPest cornPest) {
        return CornPestResult.builder()
                .withPestId(cornPest.getPestId())
                .withPestName(cornPest.getPestName())
                .build();
    }

    public List<CornPestResult> toCornPestResultList(List<CornPest> cornPests) {
        return cornPests.stream()
                .map(this::toCornPestResult)
                .collect(Collectors.toList());
    }

    public WheatPestResult toWheatPestResult(WheatPest wheatPest) {
        return WheatPestResult.builder()
                .withPestId(wheatPest.getPestId())
                .withPestName(wheatPest.getPestName())
                .build();
    }

    public List<WheatPestResult> toWheatPestResultList(List<WheatPest> wheatPests) {
        return wheatPests.stream()
                .map(this::toWheatPestResult)
                .collect(Collectors.toList());
    }
}
