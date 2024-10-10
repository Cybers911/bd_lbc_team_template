package com.eduardo.project.models.requests;

public class UpdateCornPestRequest {

    private String pestId;
    private String pestName;

    public UpdateCornPestRequest() {}

    public UpdateCornPestRequest(String pestId, String pestName) {
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
