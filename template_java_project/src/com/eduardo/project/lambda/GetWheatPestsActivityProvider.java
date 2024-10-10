package com.eduardo.project.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eduardo.project.dependency.DaggerServiceComponent;
import com.eduardo.project.dependency.ServiceComponent;
import com.eduardo.project.models.requests.GetWheatPestsRequest;
import com.eduardo.project.models.results.GetWheatPestsResult;

public class GetWheatPestsActivityProvider implements RequestHandler<GetWheatPestsRequest, GetWheatPestsResult> {

    private static ServiceComponent app;

    public GetWheatPestsActivityProvider() {
    }

    @Override
    public GetWheatPestsResult handleRequest(GetWheatPestsRequest getWheatPestsRequest, Context context) {
        return getApp().provideGetWheatPestsActivity().handleRequest(getWheatPestsRequest, context);
    }

    private ServiceComponent getApp() {
        if (app == null) {
            app = DaggerServiceComponent.create();
        }
        return app;
    }
}
