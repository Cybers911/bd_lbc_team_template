package bd_lbc_team_template.template_java_project.lambda;
import bd_lbc_team_template.template_java_project.DAOS.PestDAO;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.util.Map;


public class WheatPestsHandler implements RequestHandler<Map<String, String>, String> {

    private static final String TABLE_NAME = "WheatPests";
    private PestDAO pestDAO = new PestDAO(TABLE_NAME);

    @Override
    public String handleRequest(Map<String, String> input, Context context) {
    String method = input.get("httpMethod");

    switch (method) {
    case "GET":
        return handleGetRequest(input);
    case "POST":
        return handlePostRequest(input);
    case "PUT":
        return handlePutRequest(input);
    default:
        return "Unsupported HTTP method: " + method;
    }
}

private String handleGetRequest(Map<String, String> input) {
    String pestId = input.get("pestId");
    if (pestId != null) {
        return pestDAO.getPest(pestId).toJSON();
    } else {
        return "Pest ID not provided.";
    }
}

private String handlePostRequest(Map<String, String> input) {
    String pestId = input.get("pestId");
    String pestName = input.get("pestName");

    if (pestId == null || pestName == null) {
        return "Missing parameters";
    }

    pestDAO.addPest(pestId, pestName);
    return "Pest added successfully.";
}

private String handlePutRequest(Map<String, String> input) {
    String pestId = input.get("pestId");
    String pestName = input.get("pestName");

    if (pestId == null) {
        return "Pest ID is required.";
    }

    pestDAO.updatePest(pestId, pestName);
    return "Pest updated successfully.";
}
