package com.eduardo.project.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eduardo.project.dynamoDB.WheatPestDAO;
import com.eduardo.project.models.requests.UpdateWheatPestRequest;
import com.eduardo.project.models.results.UpdateWheatPestResult;

import javax.inject.Inject;

public class UpdateWheatPestActivity implements RequestHandler<UpdateWheatPestRequest, UpdateWheatPestResult> {

    private final WheatPestDAO wheatPestDAO;

    @Inject
    public UpdateWheatPestActivity(WheatPestDAO wheatPestDAO) {
        this.wheatPestDAO = wheatPestDAO;
    }

    @Override
    public UpdateWheatPestResult handleRequest(UpdateWheatPestRequest request, Context context) {
        wheatPestDAO.updateWheatPest(request.getPestId(), request.getPestName());
        return new UpdateWheatPestResult("Wheat pest successfully updated.");
    }
}
