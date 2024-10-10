package com.eduardo.project.activity;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eduardo.project.dynamoDB.CornPestDAO;
import com.eduardo.project.models.requests.UpdateCornPestRequest;
import com.eduardo.project.models.results.UpdateCornPestResult;

import javax.inject.Inject;

public class UpdateCornPestActivity implements RequestHandler<UpdateCornPestRequest, UpdateCornPestResult> {

    private final CornPestDAO cornPestDAO;

    @Inject
    public UpdateCornPestActivity(CornPestDAO cornPestDAO) {
        this.cornPestDAO = cornPestDAO;
    }

    @Override
    public UpdateCornPestResult handleRequest(UpdateCornPestRequest request, Context context) {
        cornPestDAO.updateCornPest(request.getPestId(), request.getPestName());
        return new UpdateCornPestResult("Corn pest successfully updated.");
    }
}
