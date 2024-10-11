package com.eduardo.project.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eduardo.project.dynamoDB.CornPestDAO;
import com.eduardo.project.models.CornPest;
import com.eduardo.project.models.requests.GetCornPestsRequest;
import com.eduardo.project.models.results.GetCornPestsResult;

import javax.inject.Inject;
import java.util.List;

public class GetCornPestsActivity implements RequestHandler<GetCornPestsRequest, GetCornPestsResult> {

    private final CornPestDAO cornPestDAO;

    @Inject
    public GetCornPestsActivity(CornPestDAO cornPestDAO) {
        this.cornPestDAO = cornPestDAO;
    }

    @Override
    public GetCornPestsResult handleRequest(GetCornPestsRequest request, Context context) {
        List<CornPest> pests = cornPestDAO.getAllPests();
        return new GetCornPestsResult(pests);
    }
}
