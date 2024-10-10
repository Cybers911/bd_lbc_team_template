package com.eduardo.project.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.eduardo.project.dependency.DaggerServiceComponent;
import com.eduardo.project.dependency.ServiceComponent;
import com.eduardo.project.models.requests.GetCornPestsRequest;

public class GetCornPestsActivityProvider implements RequestHandler<GetCornPestsRequest, GetCornPestsResult> {

    private static ServiceComponent app;

    public GetCornPestsActivityProvider() {
    }

    @Override
    public GetCornPestsResult handleRequest(GetCornPestsRequest getCornPestsRequest, Context context) {
        return getApp().provideGetCornPestsActivity().handleRequest(getCornPestsRequest, context);
    }

    private ServiceComponent getApp() {
        if (app == null) {
            app = DaggerServiceComponent.create();
        }
        return app;
    }
}
