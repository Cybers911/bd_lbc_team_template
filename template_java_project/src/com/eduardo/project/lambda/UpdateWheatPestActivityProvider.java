package com.eduardo.project.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eduardo.project.dependency.DaggerServiceComponent;
import com.eduardo.project.dependency.ServiceComponent;
import com.eduardo.project.models.requests.UpdateWheatPestRequest;
import com.eduardo.project.models.results.UpdateWheatPestResult;

public class UpdateWheatPestActivityProvider implements RequestHandler<UpdateWheatPestRequest, UpdateWheatPestResult> {

    private static ServiceComponent app;

    public UpdateWheatPestActivityProvider() {
    }

    @Override
    public UpdateWheatPestResult handleRequest(UpdateWheatPestRequest updateWheatPestRequest, Context context) {
        return getApp().provideUpdateWheatPestActivity().handleRequest(updateWheatPestRequest, context);
    }

    private ServiceComponent getApp() {
        if (app == null) {
            app = DaggerServiceComponent.create();
        }
        return app;
    }
}
