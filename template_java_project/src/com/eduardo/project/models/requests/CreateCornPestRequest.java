package com.eduardo.project.models.requests;

public class CreateCornPestRequest {

    private String pestId;
    private String pestName;

    public CreateCornPestRequest() {}

    public CreateCornPestRequest(String pestId, String pestName) {
        this.pestId = pestId;
        this.pestName = pestName;
    }

    public String getPestId() {
        return pestId;
    }

    public void setPestId(String pestId) {
        this.pestId = pestId;
    }

    public String getPestName() {
        return pestName;
    }

    public void setPestName(String pestName) {
        this.pestName = pestName;
    }
}
