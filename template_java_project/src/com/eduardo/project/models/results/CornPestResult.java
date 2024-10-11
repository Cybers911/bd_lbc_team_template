package com.eduardo.project.models.results;

public class CornPestResult {

    private String pestId;
    private String pestName;

    private CornPestResult(Builder builder) {
        this.pestId = builder.pestId;
        this.pestName = builder.pestName;
    }

    public String getPestId() {
        return pestId;
    }

    public String getPestName() {
        return pestName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String pestId;
        private String pestName;

        public Builder withPestId(String pestId) {
            this.pestId = pestId;
            return this;
        }

        public Builder withPestName(String pestName) {
            this.pestName = pestName;
            return this;
        }

        public CornPestResult build() {
            return new CornPestResult(this);
        }
    }
}
