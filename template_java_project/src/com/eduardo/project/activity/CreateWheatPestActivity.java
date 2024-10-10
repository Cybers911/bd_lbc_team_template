package com.eduardo.project.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eduardo.project.dynamoDB.WheatPestDAO;
import com.eduardo.project.models.WheatPest;
import com.eduardo.project.models.requests.CreateWheatPestRequest;
import com.eduardo.project.models.results.CreateWheatPestResult;

import javax.inject.Inject;

public class CreateWheatPestActivity implements RequestHandler<CreateWheatPestRequest, CreateWheatPestResult> {

    private final WheatPestDAO wheatPestDAO;

    @Inject
    public CreateWheatPestActivity(WheatPestDAO wheatPestDAO) {
        this.wheatPestDAO = wheatPestDAO;
    }

    @Override
    public CreateWheatPestResult handleRequest(CreateWheatPestRequest request, Context context) {
        WheatPest pest = new WheatPest(request.getPestId(), request.getPestName());
        wheatPestDAO.saveWheatPest(pest);
        return new CreateWheatPestResult("Wheat pest successfully created.");
    }
}
