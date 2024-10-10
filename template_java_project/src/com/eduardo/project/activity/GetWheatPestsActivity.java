package com.eduardo.project.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eduardo.project.dynamoDB.WheatPestDAO;
import com.eduardo.project.models.WheatPest;
import com.eduardo.project.models.requests.GetWheatPestsRequest;
import com.eduardo.project.models.results.GetWheatPestsResult;

import javax.inject.Inject;
import java.util.List;

public class GetWheatPestsActivity implements RequestHandler<GetWheatPestsRequest, GetWheatPestsResult> {

    private final WheatPestDAO wheatPestDAO;

    @Inject
    public GetWheatPestsActivity(WheatPestDAO wheatPestDAO) {
        this.wheatPestDAO = wheatPestDAO;
    }

    @Override
    public GetWheatPestsResult handleRequest(GetWheatPestsRequest request, Context context) {
        List<WheatPest> pests = wheatPestDAO.getAllPests();
        return new GetWheatPestsResult(pests);
    }
}
