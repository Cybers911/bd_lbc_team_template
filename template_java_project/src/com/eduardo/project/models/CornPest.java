package com.eduardo.project.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "CornPests")
public class CornPest {

    private String pestId;
    private String pestName;

    public CornPest() {}

    public CornPest(String pestId, String pestName) {
        this.pestId = pestId;
        this.pestName = pestName;
    }

    @DynamoDBHashKey(attributeName = "pestId")
    public String getPestId() {
        return pestId;
    }

    public void setPestId(String pestId) {
        this.pestId = pestId;
    }

    @DynamoDBAttribute(attributeName = "pestName")
    public String getPestName() {
        return pestName;
    }

    public void setPestName(String pestName) {
        this.pestName = pestName;
    }
}