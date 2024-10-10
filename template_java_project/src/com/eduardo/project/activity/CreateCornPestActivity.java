package com.eduardo.project.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eduardo.project.dynamoDB.CornPestDAO;
import com.eduardo.project.models.CornPest;
import com.eduardo.project.models.requests.CreateCornPestRequest;
import com.eduardo.project.models.results.CreateCornPestResult;

import javax.inject.Inject;

public class CreateCornPestActivity implements RequestHandler<CreateCornPestRequest, CreateCornPestResult> {

    private final CornPestDAO cornPestDAO;

    @Inject
    public CreateCornPestActivity(CornPestDAO cornPestDAO) {
        this.cornPestDAO = cornPestDAO;
    }

    @Override
    public CreateCornPestResult handleRequest(CreateCornPestRequest request, Context context) {
        CornPest pest = new CornPest(request.getPestId(), request.getPestName());
        cornPestDAO.saveCornPest(pest);
        return new CreateCornPestResult("Corn pest successfully created.");
    }
}
