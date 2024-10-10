package com.eduardo.project.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eduardo.project.dependency.DaggerServiceComponent;
import com.eduardo.project.dependency.ServiceComponent;
import com.eduardo.project.models.requests.UpdateCornPestRequest;
import com.eduardo.project.models.results.UpdateCornPestResult;

public class UpdateCornPestActivityProvider implements RequestHandler<UpdateCornPestRequest, UpdateCornPestResult> {

    private static ServiceComponent app;

    public UpdateCornPestActivityProvider() {
    }

    @Override
    public UpdateCornPestResult handleRequest(UpdateCornPestRequest updateCornPestRequest, Context context) {
        return getApp().provideUpdateCornPestActivity().handleRequest(updateCornPestRequest, context);
    }

    private ServiceComponent getApp() {
        if (app == null) {
            app = DaggerServiceComponent.create();
        }
        return app;
    }
}
