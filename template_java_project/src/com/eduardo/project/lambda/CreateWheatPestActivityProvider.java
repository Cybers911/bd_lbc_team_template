package com.eduardo.project.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eduardo.project.dependency.DaggerServiceComponent;
import com.eduardo.project.dependency.ServiceComponent;
import com.eduardo.project.models.requests.CreateWheatPestRequest;
import com.eduardo.project.models.results.CreateWheatPestResult;


public class CreateWheatPestActivityProvider implements RequestHandler<CreateWheatPestRequest, CreateWheatPestResult> {

    private static ServiceComponent app;

    public CreateWheatPestActivityProvider() {
    }

    @Override
    public CreateWheatPestResult handleRequest(CreateWheatPestRequest createWheatPestRequest, Context context) {
        return getApp().provideCreateWheatPestActivity().handleRequest(createWheatPestRequest, context);
    }

    private ServiceComponent getApp() {
        if (app == null) {
            app = DaggerServiceComponent.create();
        }
        return app;
    }
}
