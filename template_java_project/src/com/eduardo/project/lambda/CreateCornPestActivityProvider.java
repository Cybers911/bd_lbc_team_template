package com.eduardo.project.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eduardo.project.dependency.DaggerServiceComponent;
import com.eduardo.project.dependency.ServiceComponent;
import com.eduardo.project.models.requests.CreateCornPestRequest;
import com.eduardo.project.models.results.CreateCornPestResult;

public class CreateCornPestActivityProvider implements RequestHandler<CreateCornPestRequest, CreateCornPestResult> {

    private static ServiceComponent app;

    public CreateCornPestActivityProvider() {
    }

    @Override
    public CreateCornPestResult handleRequest(CreateCornPestRequest createCornPestRequest, Context context) {
        return getApp().provideCreateCornPestActivity().handleRequest(createCornPestRequest, context);
    }

    private ServiceComponent getApp() {
        if (app == null) {
            app = DaggerServiceComponent.create();
        }
        return app;
    }
}
